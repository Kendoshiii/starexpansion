package de.se.common.handler;

import de.se.StarExpansion;
import de.se.common.config.ConfigValues;
import de.se.common.lib.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialHandler {

	public static final class TOOLS{
		
		public static final ToolMaterial COPPER = EnumHelper.addToolMaterial("Copper", 1, ConfigValues.copperToolsDurability, 3.8F, 1.2F, 6);
		public static final ToolMaterial BRONZE = EnumHelper.addToolMaterial("Bronze", 2, ConfigValues.bronzeToolsDurability, 6F, 2.0F, 6);
		public static final ToolMaterial EMERALD = EnumHelper.addToolMaterial("Emerald", 3, ConfigValues.emeraldToolsDurability, 10F, 4F, 6);
		
	}
	
	public static final class ARMOR{
		
		public static final ArmorMaterial EMERALD = EnumHelper.addArmorMaterial("Emerald", Reference.MODID + ":emerald", ConfigValues.emeraldArmorDurability, new int[]{6, 8, 10, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3F);
	
	}
	
	public static final class PAXEL{
		
		public static final ToolMaterial WOODEN = EnumHelper.addToolMaterial("Wooden", 0, 177, 2.0F, 0.0F, 15);
		public static final ToolMaterial STONE = EnumHelper.addToolMaterial("Stone", 1, 393, 4.0F, 1.0F, 5);
		public static final ToolMaterial IRON = EnumHelper.addToolMaterial("Iron", 2, 750, 6.0F, 2.0F, 14);
		public static final ToolMaterial GOLDEN = EnumHelper.addToolMaterial("Golden", 0, 96, 12.0F, 0.0F, 22);
		public static final ToolMaterial DIAMOND = EnumHelper.addToolMaterial("Diamond", 3, 4683, 8.0F, 3.0F, 10);
		public static final ToolMaterial COPPER = EnumHelper.addToolMaterial("Copper", 1, ConfigValues.copperToolsDurability * 3, 3.8F, 1.2F, 6);
		public static final ToolMaterial BRONZE = EnumHelper.addToolMaterial("Bronze", 2, ConfigValues.bronzeToolsDurability * 3, 6F, 2F, 6);
		public static final ToolMaterial EMERALD = EnumHelper.addToolMaterial("Emerald", 3, ConfigValues.emeraldToolsDurability * 3, 10F, 4F, 10);
		
	}
	
}
