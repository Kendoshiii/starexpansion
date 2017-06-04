package de.se.common.items.tools;

import java.util.List;

import de.se.StarExpansion;
import de.se.common.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToolForgeHammer extends ItemBase{

	private static String name;
	
	public ToolForgeHammer(int i, String name) {
		super(name);
		this.name = name;
		setMaxDamage(i);
		setMaxStackSize(1);
	}

	@Override
	public String getUnlocalizedName(){
		return "item." + StarExpansion.MODID + ":" + name;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (getHasSubtypes()) {
			return getUnlocalizedName() + "." + stack.getItemDamage();
		}

		return getUnlocalizedName();
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		
		ItemStack stack = itemStack.copy();
		
		stack.setItemDamage(stack.getItemDamage() + 1);
		stack.setCount(1);
		
		return stack;
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		
		int damage = stack.getMaxDamage() - stack.getItemDamage() + 1;
		tooltip.add("Durability: " + damage);
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
}
