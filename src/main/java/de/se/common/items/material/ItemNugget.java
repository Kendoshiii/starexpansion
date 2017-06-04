package de.se.common.items.material;

import java.util.List;

import de.se.common.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemNugget extends ItemBase{

	public static final int NUGGET_COPPER = 0;
	public static final int NUGGET_TIN = 1;
	public static final int NUGGET_BRONZE = 2;
	public static final int NUGGET_SILVER = 3;
	public static final int NUGGET_LEAD = 4;
	public static final int NUGGET_STEEL = 5;
	
	public ItemNugget() {
		super("nugget");
		
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i<=5; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
}
