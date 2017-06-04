package de.se.common.items;

import java.util.HashMap;
import java.util.Map;

import de.se.StarExpansion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item{

	private String name;
	
	public Map<Integer, String> nameMap = new HashMap<Integer, String>();

	public ItemBase(String name) {
		
		this.name = name;
		
		setRegistryName(StarExpansion.MODID, name);
		setCreativeTab(StarExpansion.INSTANCE.tab);
		
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
}
