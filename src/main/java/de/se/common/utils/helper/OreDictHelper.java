package de.se.common.utils.helper;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.common.items.material.ItemDust;
import de.se.common.items.material.ItemIngot;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHelper {

	public static void init(){
		
		registerItemOreDict();
		registerBlockOreDict();
		
	}
	
	private static void registerItemOreDict(){
		
		OreDictionary.registerOre("ingotCopper", new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER));
		OreDictionary.registerOre("ingotTin", new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN));
		OreDictionary.registerOre("ingotBronze", new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE));
		OreDictionary.registerOre("ingotSilver", new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER));
		OreDictionary.registerOre("ingotLead", new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD));
		OreDictionary.registerOre("ingotSteel", new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL));
		
		OreDictionary.registerOre("materialCoal", Items.COAL);

		OreDictionary.registerOre("dustGlowstone", Items.GLOWSTONE_DUST);
		OreDictionary.registerOre("dustCopper", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_COPPER));
		OreDictionary.registerOre("dustTin", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_TIN));
		OreDictionary.registerOre("dustBronze", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_BRONZE));
		OreDictionary.registerOre("dustSilver", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_SILVER));
		OreDictionary.registerOre("dustLead", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_LEAD));
		OreDictionary.registerOre("dustSteel", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_STEEL));
		OreDictionary.registerOre("dustCarbon", new ItemStack(SEItems.DUST, 1, ItemDust.DUST_CARBON));
		
	}
	
	private static void registerBlockOreDict(){
		
		OreDictionary.registerOre("oreCopper", SEBlocks.COPPER_ORE);
		OreDictionary.registerOre("oreTin", SEBlocks.TIN_ORE);
		OreDictionary.registerOre("oreSilver", SEBlocks.SILVER_ORE);
		OreDictionary.registerOre("oreLead", SEBlocks.LEAD_ORE);
		OreDictionary.registerOre("oreRadiant", SEBlocks.RADIANT_ORE);
		
		OreDictionary.registerOre("blockObsidian", Blocks.OBSIDIAN);
		
		OreDictionary.registerOre("blockMetalCopper", SEBlocks.COPPER_BLOCK);
		OreDictionary.registerOre("blockMetalTin", SEBlocks.TIN_BLOCK);
		OreDictionary.registerOre("blockMetalBronze", SEBlocks.BRONZE_BLOCK);
		OreDictionary.registerOre("blockMetalSilver", SEBlocks.SILVER_BLOCK);
		OreDictionary.registerOre("blockMetalLead", SEBlocks.LEAD_BLOCK);
		
	}
	
}
