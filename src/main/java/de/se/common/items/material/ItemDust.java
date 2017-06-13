package de.se.common.items.material;

import de.se.common.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemDust extends ItemBase{

	public static final int DUST_COPPER = 0;
	public static final int DUST_TIN = 1;
	public static final int DUST_BRONZE = 2;
	public static final int DUST_SILVER = 3;
	public static final int DUST_LEAD = 4;
	public static final int DUST_STEEL = 5;
	public static final int DUST_CARBON = 6;
	public static final int DUST_IRON = 7;
	public static final int DUST_GOLD = 8;
	public static final int DUST_DIAMOND = 9;
	public static final int DUST_EMERALD = 10;
	
	public ItemDust() {
		super("dust");
		
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i<=10; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
}
