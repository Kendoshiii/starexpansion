package de.se.common.items;

import java.util.HashMap;
import java.util.Map;

import de.se.StarExpansion;
import de.se.common.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item{

	private String name;
	
	public ItemBase(String name) {
		
		this.name = name;
		
		setRegistryName(Reference.MODID, name);
		setCreativeTab(StarExpansion.INSTANCE.tab);
		
	}
	
	@Override
	public String getUnlocalizedName(){
		return "item." + Reference.MODID + ":" + name;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (getHasSubtypes()) {
			return getUnlocalizedName() + "." + stack.getItemDamage();
		}

		return getUnlocalizedName();
	}
}
