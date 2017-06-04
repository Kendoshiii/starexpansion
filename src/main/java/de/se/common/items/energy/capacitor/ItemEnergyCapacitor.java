package de.se.common.items.energy.capacitor;

import java.util.List;

import cofh.api.energy.IEnergyContainerItem;
import de.se.StarExpansion;
import de.se.common.items.ItemEnergyBase;
import de.se.common.utils.helper.StringHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEnergyCapacitor extends ItemEnergyBase{

	public ItemEnergyCapacitor(int capacity, int maxReceive, String name) {
		super(capacity, maxReceive, name);
		this.setMaxStackSize(1);
	}

	@Override
    public EnumRarity getRarity(ItemStack stack){
        return EnumRarity.RARE;
    }

    @Override
    public boolean hasEffect(ItemStack stack){
        return this.isDischargeMode(stack);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
        if(!world.isRemote && entity instanceof EntityPlayer && this.isDischargeMode(stack)){
            EntityPlayer player = (EntityPlayer)entity;
            for(int i = 0; i < player.inventory.getSizeInventory(); i++){
                ItemStack slot = player.inventory.getStackInSlot(i);
                if(isValid(slot)){
                    int received = 0;

                    Item item = slot.getItem();
                    if(item instanceof IEnergyContainerItem){
                        received = ((IEnergyContainerItem)item).receiveEnergy(slot, this.extractEnergy(stack, Integer.MAX_VALUE, true), false);
                    }

                    if(received > 0){
                        this.extractEnergy(stack, received, false);
                    }
                }
            }
        }
    }
 
    public static boolean isValid(ItemStack stack){
        return stack != ItemStack.EMPTY && !ItemStack.areItemStacksEqual(stack, getNull()) && stack.getCount() > 0 && stack.getItem() != ItemStack.EMPTY.getItem();
    }
    
    public static ItemStack getNull(){
        return ItemStack.EMPTY;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand){
        
    	ItemStack stack = player.getHeldItem(hand);
    	if(!worldIn.isRemote && player.isSneaking()){
            boolean isDischarge = this.isDischargeMode(stack);
            this.setDischargeMode(stack, !isDischarge);

            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        }
        return super.onItemRightClick(worldIn, player, hand);
    }

    private boolean isDischargeMode(ItemStack stack){
        return stack.hasTagCompound() && stack.getTagCompound().getBoolean("DischargeMode");
    }

    private void setDischargeMode(ItemStack stack, boolean mode){
        if(!stack.hasTagCompound()){
            stack.setTagCompound(new NBTTagCompound());
        }

        stack.getTagCompound().setBoolean("DischargeMode", mode);
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool){
        super.addInformation(stack, player, list, bool);
        list.add(StringHelper.localize("tooltip."+StarExpansion.MODID+".capacitor."+(this.isDischargeMode(stack) ? "discharge" : "noDischarge")));
        list.add(StringHelper.localize("tooltip."+StarExpansion.MODID+".capacitor.changeMode"));
    }
    
}
