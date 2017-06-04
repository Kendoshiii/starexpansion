package de.se.common.items.material;

import java.util.List;

import de.se.common.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemIngot extends ItemBase{

	public static final int INGOT_COPPER = 0;
	public static final int INGOT_TIN = 1;
	public static final int INGOT_BRONZE = 2;
	public static final int INGOT_SILVER = 3;
	public static final int INGOT_LEAD = 4;
	public static final int INGOT_STEEL = 5;
	public static final int INGOT_CARBON_IRON = 6;
	public static final int INGOT_RADIANT_STAR = 7;
	
	public ItemIngot() {
		super("ingot");
		
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i<=7; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
}
