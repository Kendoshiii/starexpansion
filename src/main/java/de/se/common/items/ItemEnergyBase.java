package de.se.common.items;

import java.text.NumberFormat;
import java.util.List;

import cofh.api.energy.ItemEnergyContainer;
import de.se.StarExpansion;
import de.se.common.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * This class was created by Ellpeck and modified by Kendoshiii
 */

public class ItemEnergyBase extends ItemEnergyContainer{

	private final String name;

	public ItemEnergyBase(int capacity, int maxReceive, String name) {
		super(capacity, maxReceive);
		this.name = name;
		this.setRegistryName(Reference.MODID, name);
		this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setCreativeTab(StarExpansion.INSTANCE.tab);
	}
	
	@Override
	public String getUnlocalizedName(){
		return "item." + Reference.MODID + ":" + name;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName();
	}
	
    public boolean shouldAddCreative(){
        return true;
    }
    
    @Override
    public boolean getShareTag(){
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, NonNullList<ItemStack> list){
        ItemStack stackFull = new ItemStack(this);
        this.setEnergy(stackFull, this.getMaxEnergyStored(stackFull));
        list.add(stackFull);

        ItemStack stackEmpty = new ItemStack(this);
        this.setEnergy(stackEmpty, 0);
        list.add(stackEmpty);
    }

    @Override
    public boolean showDurabilityBar(ItemStack itemStack){
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack){
        double maxAmount = this.getMaxEnergyStored(stack);
        double energyDif = maxAmount-this.getEnergyStored(stack);
        return energyDif/maxAmount;
    }

    public void setEnergy(ItemStack stack, int energy){
        NBTTagCompound compound = stack.getTagCompound();
        if(compound == null){
            compound = new NBTTagCompound();
        }
        compound.setInteger("Energy", energy);
        stack.setTagCompound(compound);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool){
        NumberFormat format = NumberFormat.getInstance();
        list.add(format.format(this.getEnergyStored(stack))+"/"+format.format(this.getMaxEnergyStored(stack))+(" SF"));
    }
    
}
