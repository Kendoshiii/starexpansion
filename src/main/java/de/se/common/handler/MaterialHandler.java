package de.se.common.handler;

import de.se.StarExpansion;
import de.se.common.config.ConfigValues;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {

	public static final class TOOLS{
		
		public static final ToolMaterial COPPER = EnumHelper.addToolMaterial("Copper", 0, ConfigValues.copperToolsDurability, 3.8F, 1.2F, 6);
		public static final ToolMaterial BRONZE = EnumHelper.addToolMaterial("Bronze", 2, ConfigValues.bronzeToolsDurability, 6F, 2.0F, 6);
		public static final ToolMaterial EMERALD = EnumHelper.addToolMaterial("Emerald", 3, ConfigValues.emeraldToolsDurability, 10F, 4F, 6);
		
	}
	
	public static final class ARMOR{
		
		public static final ArmorMaterial EMERALD = EnumHelper.addArmorMaterial("Emerald", StarExpansion.MODID + ":emerald", ConfigValues.emeraldArmorDurability, new int[]{6, 8, 10, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3F);
	
	}
	
}
