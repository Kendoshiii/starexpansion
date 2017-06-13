package de.se.common.tiles.repairer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.se.common.config.ConfigValues;
import de.se.common.container.repairer.ContainerRepairer;
import de.se.common.lib.Reference;
import de.se.common.utils.SEUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

public class TileRepairer extends TileEntityLockableLoot implements ITickable{

	private NonNullList<ItemStack> workspace;
	private EnumFacing orientation = EnumFacing.DOWN;
	private EnergyStorage storage = new EnergyStorage(ConfigValues.repairerEnergyPerPoint * 1000);

	public TileRepairer() {
		this.workspace = NonNullList.withSize(1, ItemStack.EMPTY);
	}

	@Override
	public void update() {
		if (!world.isRemote) {
			if (storage.getEnergyStored() > ConfigValues.repairerEnergyPerPoint) {
				if (tryRepair()) {
					storage.extractEnergy(ConfigValues.repairerEnergyPerPoint, false);
				}
			}
		}
	}

	public boolean tryRepair() {
		if (getStackInSlot(0).isEmpty())
			return false;

		if (isExtractable()) {
			ejectItem();
			return false;
		}
		getStackInSlot(0).setItemDamage(getStackInSlot(0).getItemDamage() - 1);
		if (getStackInSlot(0).getItem().getClass().toString().contains("slimeknights.tconstruct.tools")) {
			NBTTagCompound tag = getStackInSlot(0).getTagCompound();
			if (tag != null && tag.hasKey("Stats")) {
				NBTTagCompound stats = tag.getCompoundTag("Stats");
				stats.setBoolean("Broken",false);
				tag.setTag("Stats", stats);
				getStackInSlot(0).setTagCompound(tag);
			}
		}
		return true;
	}

	private boolean isExtractable() {
		return !getStackInSlot(0).isItemDamaged() || !(getStackInSlot(0).getItem().isRepairable() || getStackInSlot(0).getItem().getClass().toString().contains("slimeknights.tconstruct.tools")) || ConfigValues.blacklist.contains(getStackInSlot(0).getItem().getUnlocalizedName()) || (ConfigValues.restrictRepairs && !(getStackInSlot(0).getItem() instanceof ItemTool || getStackInSlot(0).getItem() instanceof ItemArmor || getStackInSlot(0).getItem() instanceof ItemSword || getStackInSlot(0).getItem() instanceof ItemBow));
	}

	private void ejectItem() {
		if (SEUtils.addToPriorityInventory(this.getWorld(), this.pos, getStackInSlot(0).copy())) {
			decrStackSize(0, 1);
			return;
		}
		
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		if (this.world == null)
		{
			return true;
		}

		if (this.world.getTileEntity(this.pos) != this)
		{
			return false;
		}

		return player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64D;
	}


	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

	}

	@Override
	public int getSizeInventory() {
		return this.workspace.size();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.workspace.get(slot);
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		this.fillWithLoot(null);
		if (isExtractable()) {
			ItemStack itemstack = ItemStackHelper.getAndSplit(this.getItems(), index, count);

			if (!itemstack.isEmpty()) {
				this.markDirty();
			}

			return itemstack;
		} else {
			return ItemStack.EMPTY;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		this.fillWithLoot(null);
		return isExtractable() ? ItemStackHelper.getAndRemove(this.getItems(), index) : ItemStack.EMPTY;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public void markDirty() {
		super.markDirty();
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return itemstack.getItem().isDamageable();
	}

	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
		this.workspace = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(data, this.workspace);
		if (data.hasKey("energy")) {
			storage.receiveEnergy(data.getInteger("energy"),false);
		}
		this.orientation = EnumFacing.VALUES[data.getByte("orientation")];
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
		ItemStackHelper.saveAllItems(data, this.workspace);
		data.setInteger("energy", storage.getEnergyStored());
		data.setByte("orientation", (byte) this.orientation.ordinal());
		return data;
	}

	@Override
	public String getName() {
		return "Flux-Repairer";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
	}

	public EnumFacing getOrientation() {
		return orientation;
	}

	public void setOrientation(EnumFacing orientation) {
		this.orientation = orientation;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound compound = new NBTTagCompound();

		compound.setByte("orientation", (byte) this.orientation.ordinal());

		return new SPacketUpdateTileEntity(this.pos, 0, compound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		if (pkt.getTileEntityType() == 0)
		{
			NBTTagCompound compound = pkt.getNbtCompound();

			this.orientation = EnumFacing.VALUES[compound.getByte("orientation")];
		}
	}

	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) {
			return CapabilityEnergy.ENERGY.cast(storage);
		}

		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
		return capability == CapabilityEnergy.ENERGY || super.hasCapability(capability, facing);
	}

	@Override
	public NBTTagCompound getUpdateTag()
	{
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public NonNullList<ItemStack> getItems()
	{
		return this.workspace;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.workspace)
		{
			if (!itemstack.isEmpty())
			{
				return false;
			}
		}

		return true;	
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerRepairer(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return Reference.MODID + ":flux-repairer";
	}
	
}
