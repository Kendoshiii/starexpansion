package de.se.common.crafting;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.common.items.material.ItemDust;
import de.se.common.items.material.ItemIngot;
import de.se.common.items.material.ItemNugget;
import de.se.common.items.material.ItemPlate;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SECrafting {

	public static void init(){
		
		ItemStack copper_axe = new ItemStack(SEItems.COPPER_AXE);
		GameRegistry.addRecipe(copper_axe, "SS ", "SD ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 'D', Items.STICK);
		ItemStack bronze_axe = new ItemStack(SEItems.BRONZE_AXE);
		GameRegistry.addRecipe(bronze_axe, "SS ", "SD ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), 'D', Items.STICK);
		ItemStack emerald_axe = new ItemStack(SEItems.EMERALD_AXE);
		GameRegistry.addRecipe(emerald_axe, "SS ", "SD ", " D ", 'S', Items.EMERALD, 'D', Items.STICK);
		
		ItemStack copper_hoe = new ItemStack(SEItems.COPPER_HOE);
		GameRegistry.addRecipe(copper_hoe, "SS ", " D ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 'D', Items.STICK);
		ItemStack bronze_hoe = new ItemStack(SEItems.BRONZE_HOE);
		GameRegistry.addRecipe(bronze_hoe, "SS ", " D ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), 'D', Items.STICK);
		ItemStack emerald_hoe = new ItemStack(SEItems.EMERALD_HOE);
		GameRegistry.addRecipe(emerald_hoe, "SS ", " D ", " D ", 'S', Items.EMERALD, 'D', Items.STICK);
		
		ItemStack copper_pickaxe = new ItemStack(SEItems.COPPER_PICKAXE);
		GameRegistry.addRecipe(copper_pickaxe, "SSS", " D ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 'D', Items.STICK);
		ItemStack bronze_pickaxe = new ItemStack(SEItems.BRONZE_PICKAXE);
		GameRegistry.addRecipe(bronze_pickaxe, "SSS", " D ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), 'D', Items.STICK);
		ItemStack emerald_pickaxe = new ItemStack(SEItems.EMERALD_PICKAXE);
		GameRegistry.addRecipe(emerald_pickaxe, "SSS", " D ", " D ", 'S', Items.EMERALD, 'D', Items.STICK);
		
		ItemStack copper_shovel = new ItemStack(SEItems.COPPER_SHOVEL);
		GameRegistry.addRecipe(copper_shovel, " S ", " D ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 'D', Items.STICK);
		ItemStack bronze_shovel = new ItemStack(SEItems.BRONZE_SHOVEL);
		GameRegistry.addRecipe(bronze_shovel, " S ", " D ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), 'D', Items.STICK);
		ItemStack emerald_shovel = new ItemStack(SEItems.EMERALD_SHOVEL);
		GameRegistry.addRecipe(emerald_shovel, " S ", " D ", " D ", 'S', Items.EMERALD, 'D', Items.STICK);
		
		ItemStack copper_sword = new ItemStack(SEItems.COPPER_SWORD);
		GameRegistry.addRecipe(copper_sword, " S ", " S ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 'D', Items.STICK);
		ItemStack bronze_sword = new ItemStack(SEItems.BRONZE_SWORD);
		GameRegistry.addRecipe(bronze_sword, " S ", " S ", " D ", 'S', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), 'D', Items.STICK);
		ItemStack emerald_sword = new ItemStack(SEItems.EMERALD_SWORD);
		GameRegistry.addRecipe(emerald_sword, " S ", " S ", " D ", 'S', Items.EMERALD, 'D', Items.STICK);

		ItemStack forge_hammer = new ItemStack(SEItems.FORGE_HAMMER);
		GameRegistry.addRecipe(forge_hammer, " I ", " SI", "S  ", 'I', Items.IRON_INGOT, 'S', Items.STICK, 'T', Items.STRING);
		
		GameRegistry.addRecipe(new ItemStack(SEItems.WOODEN_PAXEL), "APS", "   ", "   ", 'A', Items.WOODEN_AXE, 'P', Items.WOODEN_PICKAXE, 'S', Items.WOODEN_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.STONE_PAXEL), "APS", "   ", "   ", 'A', Items.STONE_AXE, 'P', Items.STONE_PICKAXE, 'S', Items.STONE_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.IRON_PAXEL), "APS", "   ", "   ", 'A', Items.IRON_AXE, 'P', Items.IRON_PICKAXE, 'S', Items.IRON_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.GOLD_PAXEL), "APS", "   ", "   ", 'A', Items.GOLDEN_AXE, 'P', Items.GOLDEN_PICKAXE, 'S', Items.GOLDEN_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.DIAMOND_PAXEL), "APS", "   ", "   ", 'A', Items.DIAMOND_AXE, 'P', Items.DIAMOND_PICKAXE, 'S', Items.DIAMOND_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.COPPER_PAXEL), "APS", "   ", "   ", 'A', SEItems.COPPER_AXE, 'P', SEItems.COPPER_PICKAXE, 'S', SEItems.COPPER_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.BRONZE_PAXEL), "APS", "   ", "   ", 'A', SEItems.BRONZE_AXE, 'P', SEItems.BRONZE_PICKAXE, 'S', SEItems.BRONZE_SHOVEL);
		GameRegistry.addRecipe(new ItemStack(SEItems.EMERALD_PAXEL), "APS", "   ", "   ", 'A', SEItems.EMERALD_AXE, 'P', SEItems.EMERALD_PICKAXE, 'S', SEItems.EMERALD_SHOVEL);
		
		GameRegistry.addRecipe(new ItemStack(SEItems.BATTERY), " I ", "PRP", "PRP", 'I', Items.IRON_INGOT, 'P', new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_TIN), 'R', Items.REDSTONE);
		
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR4K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.BATTERY), 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD));
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR8K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR4K), 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN));
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR16K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR8K), 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER));
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR32K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR16K), 'I', Items.IRON_INGOT);
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR64K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR32K), 'I', Items.GOLD_INGOT);
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR128K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR64K), 'I', Items.DIAMOND);
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR512K), "BRB", "IRI", "BRB", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR128K), 'I', Items.EMERALD);
		GameRegistry.addRecipe(new ItemStack(SEItems.CAPACITOR1024K), "IRI", "BRB", "IRI", 'R', Items.REDSTONE, 'B', new ItemStack(SEItems.CAPACITOR512K), 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR));
		
		GameRegistry.addRecipe(new ItemStack(SEItems.EMERALD_HELMET), "XXX", "XHX", "   ", 'X', Items.EMERALD, 'H', Items.DIAMOND_HELMET);
		GameRegistry.addRecipe(new ItemStack(SEItems.EMERALD_CHEST), "X X", "XCX", "XXX", 'X', Items.EMERALD, 'C', Items.DIAMOND_CHESTPLATE);
		GameRegistry.addRecipe(new ItemStack(SEItems.EMERALD_LEGGS), "XXX", "XLX", "X X", 'X', Items.EMERALD, 'L', Items.DIAMOND_LEGGINGS);
		GameRegistry.addRecipe(new ItemStack(SEItems.EMERALD_BOOTS), "X X", "XBX", "   ", 'X', Items.EMERALD, 'B', Items.DIAMOND_BOOTS);
		
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.INGOT, 9, ItemIngot.INGOT_COPPER), new ItemStack(SEBlocks.COPPER_BLOCK));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.INGOT, 9, ItemIngot.INGOT_TIN), new ItemStack(SEBlocks.TIN_BLOCK));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.INGOT, 9, ItemIngot.INGOT_BRONZE), new ItemStack(SEBlocks.BRONZE_BLOCK));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.INGOT, 9, ItemIngot.INGOT_SILVER), new ItemStack(SEBlocks.SILVER_BLOCK));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.INGOT, 9, ItemIngot.INGOT_LEAD), new ItemStack(SEBlocks.LEAD_BLOCK));
		
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_IRON), Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_GOLD), Items.GOLD_INGOT, Items.GOLD_INGOT, Items.GOLD_INGOT, Items.GOLD_INGOT, new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.NUGGET, 9, ItemNugget.NUGGET_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.NUGGET, 9, ItemNugget.NUGGET_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.NUGGET, 9, ItemNugget.NUGGET_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.NUGGET, 9, ItemNugget.NUGGET_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.NUGGET, 9, ItemNugget.NUGGET_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.NUGGET, 9, ItemNugget.NUGGET_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL));
		
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_COPPER), new ItemStack(SEBlocks.COPPER_ORE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_TIN), new ItemStack(SEBlocks.TIN_ORE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_BRONZE), new ItemStack(SEItems.DUST, 1, ItemDust.DUST_TIN), new ItemStack(SEItems.DUST, 1, ItemDust.DUST_COPPER), new ItemStack(SEItems.DUST, 1, ItemDust.DUST_COPPER), new ItemStack(SEItems.DUST, 1, ItemDust.DUST_COPPER));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_SILVER), new ItemStack(SEBlocks.SILVER_ORE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_LEAD), new ItemStack(SEBlocks.LEAD_ORE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_IRON), new ItemStack(Blocks.IRON_ORE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 2, ItemDust.DUST_GOLD), new ItemStack(Blocks.GOLD_ORE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		//GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_RADIANT), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_CARBON), Items.COAL, new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_IRON), Items.IRON_INGOT, new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_GOLD), Items.GOLD_INGOT, new ItemStack(SEItems.FORGE_HAMMER, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.NUGGET, 1, ItemNugget.NUGGET_COPPER));
		GameRegistry.addRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.NUGGET, 1, ItemNugget.NUGGET_TIN));
		GameRegistry.addRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.NUGGET, 1, ItemNugget.NUGGET_BRONZE));
		GameRegistry.addRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.NUGGET, 1, ItemNugget.NUGGET_SILVER));
		GameRegistry.addRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.NUGGET, 1, ItemNugget.NUGGET_LEAD));
		GameRegistry.addRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.NUGGET, 1, ItemNugget.NUGGET_STEEL));
		
		GameRegistry.addRecipe(new ItemStack(SEBlocks.COPPER_BLOCK), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.TIN_BLOCK), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.BRONZE_BLOCK), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.SILVER_BLOCK), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.LEAD_BLOCK), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.STEEL_CASE), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.RADIANT_BLOCK), "XXX", "XXX", "XXX", 'X', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR));
		
		GameRegistry.addShapelessRecipe(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_CARBON_IRON), Items.IRON_INGOT, new ItemStack(SEItems.DUST, 1, ItemDust.DUST_CARBON));
		
		GameRegistry.addRecipe(new ItemStack(SEBlocks.ATREACTOR_CONTROLLER), "XRX", "RCR", "XRX", 'X', new ItemStack(SEBlocks.STEEL_CASE), 'R', Items.REDSTONE, 'C', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR));
		GameRegistry.addRecipe(new ItemStack(SEBlocks.ATREACTOR_POWER_CONNECTOR), "XRX", "RPR", "XRX", 'X', new ItemStack(SEBlocks.STEEL_CASE), 'R', Items.REDSTONE, 'P', SEBlocks.ATREACTOR_CONTROLLER);
		
		GameRegistry.addRecipe(new ItemStack(SEBlocks.MACHINE_FRAME), "GIG", "L L", "GIG", 'G', Items.GOLD_INGOT, 'I', new ItemStack(SEItems.PLATE, 1, ItemPlate.PLATE_IRON), 'L', new ItemStack(Items.DYE, 1, 4));

		GameRegistry.addRecipe(new ItemStack(SEBlocks.REPAIRER), "IAI", "IFI", "GCG", 'I', Items.IRON_INGOT, 'A', Blocks.ANVIL, 'F', SEBlocks.MACHINE_FRAME, 'G', Items.GOLD_INGOT, 'C', Items.REDSTONE);
	
		GameRegistry.addRecipe(new ItemStack(SEItems.GROWTH_CRYSTAL), "SIS", "IDI", "SIS", 'S', Blocks.SAPLING, 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR), 'D', Items.DIAMOND);
		GameRegistry.addRecipe(new ItemStack(SEItems.WATER_CRYSTAL), "SIS", "IDI", "SIS", 'S', Items.WATER_BUCKET, 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR), 'D', Items.DIAMOND);
		GameRegistry.addRecipe(new ItemStack(SEItems.LAVA_CRYSTAL), "SIS", "IDI", "SIS", 'S', Items.LAVA_BUCKET, 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR), 'D', Items.DIAMOND);
		GameRegistry.addRecipe(new ItemStack(SEItems.WATERING_CRYSTAL), "I  ", "IWI", " I ", 'I', new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR), 'W', SEItems.WATER_CRYSTAL);
	
		
	}
	
}
