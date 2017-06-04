package de.se;

import java.util.ArrayList;
import java.util.List;

import de.se.common.config.ConfigValues;
import de.se.common.handler.MaterialHandler;
import de.se.common.items.accs.ItemGrowthCrystal;
import de.se.common.items.accs.ItemLavaCrystal;
import de.se.common.items.accs.ItemWaterCrystal;
import de.se.common.items.accs.ItemWateringCrystal;
import de.se.common.items.armor.emerald.ItemEmeraldBoots;
import de.se.common.items.armor.emerald.ItemEmeraldChest;
import de.se.common.items.armor.emerald.ItemEmeraldHelmet;
import de.se.common.items.armor.emerald.ItemEmeraldLeggs;
import de.se.common.items.energy.capacitor.ItemEnergyCapacitor;
import de.se.common.items.material.ItemDust;
import de.se.common.items.material.ItemExperiencePearl;
import de.se.common.items.material.ItemIngot;
import de.se.common.items.material.ItemMaterial;
import de.se.common.items.material.ItemNugget;
import de.se.common.items.material.ItemPlate;
import de.se.common.items.tools.ToolAxe;
import de.se.common.items.tools.ToolForgeHammer;
import de.se.common.items.tools.ToolHoe;
import de.se.common.items.tools.ToolPaxel;
import de.se.common.items.tools.ToolPickaxe;
import de.se.common.items.tools.ToolShovel;
import de.se.common.items.tools.ToolSword;
import de.se.common.lib.Names;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SEItems {

	public static List<Item> ITEMS = new ArrayList();

	// Materials
	public static Item INGOT, NUGGET, PLATE, DUST, EXPERIENCE_PEARL;

	// Tools
	public static Item COPPER_AXE, BRONZE_AXE, EMERALD_AXE;

	public static Item COPPER_HOE, BRONZE_HOE, EMERALD_HOE;

	public static Item COPPER_PICKAXE, BRONZE_PICKAXE, EMERALD_PICKAXE;

	public static Item COPPER_SHOVEL, BRONZE_SHOVEL, EMERALD_SHOVEL;

	public static Item COPPER_SWORD, BRONZE_SWORD, EMERALD_SWORD;

	public static Item FORGE_HAMMER, GROWTH_CRYSTAL, LAVA_CRYSTAL, WATER_CRYSTAL, WATERING_CRYSTAL;

	public static Item WOODEN_PAXEL, STONE_PAXEL, IRON_PAXEL, GOLD_PAXEL, DIAMOND_PAXEL, COPPER_PAXEL, BRONZE_PAXEL,
			EMERALD_PAXEL;

	public static Item BATTERY, CAPACITOR4K, CAPACITOR8K, CAPACITOR16K, CAPACITOR32K, CAPACITOR64K, CAPACITOR128K, CAPACITOR512K, CAPACITOR1024K;

	// Armor
	public static Item EMERALD_BOOTS, EMERALD_CHEST, EMERALD_LEGGS, EMERALD_HELMET;

	// Supporter Items
	public static Item VASHOLINE, BUTTON;

	public static void init() {
		INGOT = new ItemIngot();
		NUGGET = new ItemNugget();
		PLATE = new ItemPlate();
		DUST = new ItemDust();
		EXPERIENCE_PEARL = new ItemExperiencePearl(Names.materialExperiencePearl);
		
		GROWTH_CRYSTAL = new ItemGrowthCrystal();
		LAVA_CRYSTAL = new ItemLavaCrystal();
		WATER_CRYSTAL = new ItemWaterCrystal();
		WATERING_CRYSTAL = new ItemWateringCrystal();

		COPPER_AXE = new ToolAxe(MaterialHandler.TOOLS.COPPER, Names.copper_axe);
		BRONZE_AXE = new ToolAxe(MaterialHandler.TOOLS.BRONZE, Names.bronze_axe);
		EMERALD_AXE = new ToolAxe(MaterialHandler.TOOLS.EMERALD, Names.emerald_axe);

		COPPER_HOE = new ToolHoe(MaterialHandler.TOOLS.COPPER, Names.copper_hoe);
		BRONZE_HOE = new ToolHoe(MaterialHandler.TOOLS.BRONZE, Names.bronze_hoe);
		EMERALD_HOE = new ToolHoe(MaterialHandler.TOOLS.EMERALD, Names.emerald_hoe);

		COPPER_PICKAXE = new ToolPickaxe(MaterialHandler.TOOLS.COPPER, Names.copper_pickaxe);
		BRONZE_PICKAXE = new ToolPickaxe(MaterialHandler.TOOLS.BRONZE, Names.bronze_pickaxe);
		EMERALD_PICKAXE = new ToolPickaxe(MaterialHandler.TOOLS.EMERALD, Names.emerald_pickaxe);

		COPPER_SHOVEL = new ToolShovel(MaterialHandler.TOOLS.COPPER, Names.copper_shovel);
		BRONZE_SHOVEL = new ToolShovel(MaterialHandler.TOOLS.BRONZE, Names.bronze_shovel);
		EMERALD_SHOVEL = new ToolShovel(MaterialHandler.TOOLS.EMERALD, Names.emerald_shovel);

		COPPER_SWORD = new ToolSword(MaterialHandler.TOOLS.COPPER, Names.copper_sword);
		BRONZE_SWORD = new ToolSword(MaterialHandler.TOOLS.BRONZE, Names.bronze_sword);
		EMERALD_SWORD = new ToolSword(MaterialHandler.TOOLS.EMERALD, Names.emerald_sword);

		FORGE_HAMMER = new ToolForgeHammer(256, Names.forge_hammer);

		WOODEN_PAXEL = new ToolPaxel(Item.ToolMaterial.WOOD, Names.wooden_paxel);
		STONE_PAXEL = new ToolPaxel(Item.ToolMaterial.STONE, Names.stone_paxel);
		IRON_PAXEL = new ToolPaxel(Item.ToolMaterial.IRON, Names.iron_paxel);
		GOLD_PAXEL = new ToolPaxel(Item.ToolMaterial.GOLD, Names.gold_paxel);
		DIAMOND_PAXEL = new ToolPaxel(Item.ToolMaterial.DIAMOND, Names.diamond_paxel);

		COPPER_PAXEL = new ToolPaxel(MaterialHandler.TOOLS.COPPER, Names.copper_paxel);
		BRONZE_PAXEL = new ToolPaxel(MaterialHandler.TOOLS.BRONZE, Names.bronze_paxel);
		EMERALD_PAXEL = new ToolPaxel(MaterialHandler.TOOLS.EMERALD, Names.emerald_paxel);

		EMERALD_BOOTS = new ItemEmeraldBoots("emerald_boots", MaterialHandler.ARMOR.EMERALD, 0, EntityEquipmentSlot.FEET);
		EMERALD_CHEST = new ItemEmeraldChest("emerald_chest", MaterialHandler.ARMOR.EMERALD, 0, EntityEquipmentSlot.CHEST);
		EMERALD_LEGGS = new ItemEmeraldLeggs("emerald_leggs", MaterialHandler.ARMOR.EMERALD, 0, EntityEquipmentSlot.LEGS);
		EMERALD_HELMET = new ItemEmeraldHelmet("emerald_helmet", MaterialHandler.ARMOR.EMERALD, 0, EntityEquipmentSlot.HEAD);

		BATTERY = new ItemEnergyCapacitor(2000, 50, "battery");
		CAPACITOR4K = new ItemEnergyCapacitor(4000, 100, Names.capacitor_4k);
		CAPACITOR8K = new ItemEnergyCapacitor(8000, 200, Names.capacitor_8k);
		CAPACITOR16K = new ItemEnergyCapacitor(16000, 400, Names.capacitor_16k);
		CAPACITOR32K = new ItemEnergyCapacitor(32000, 800, Names.capacitor_32k);
		CAPACITOR64K = new ItemEnergyCapacitor(64000, 1600, Names.capacitor_64k);
		CAPACITOR128K = new ItemEnergyCapacitor(128000, 3200, Names.capacitor_128k);
		CAPACITOR512K = new ItemEnergyCapacitor(512000, 6400, Names.capacitor_512k);
		CAPACITOR1024K = new ItemEnergyCapacitor(1024000, 12800, Names.capacitor_1024k);

		reg();

	}

	public static void reg() {

		ITEMS.add(INGOT);
		ITEMS.add(NUGGET);
		ITEMS.add(PLATE);
		ITEMS.add(DUST);
		ITEMS.add(EXPERIENCE_PEARL);

		ITEMS.add(BATTERY);
		
		ITEMS.add(GROWTH_CRYSTAL);
		ITEMS.add(LAVA_CRYSTAL);
		ITEMS.add(WATER_CRYSTAL);

		ITEMS.add(WATERING_CRYSTAL);

		ITEMS.add(FORGE_HAMMER);
		ITEMS.add(COPPER_AXE);
		ITEMS.add(COPPER_HOE);
		ITEMS.add(COPPER_PICKAXE);
		ITEMS.add(COPPER_SHOVEL);
		ITEMS.add(COPPER_SWORD);
		ITEMS.add(BRONZE_AXE);
		ITEMS.add(BRONZE_HOE);
		ITEMS.add(BRONZE_PICKAXE);
		ITEMS.add(BRONZE_SHOVEL);
		ITEMS.add(BRONZE_SWORD);
		ITEMS.add(EMERALD_AXE);
		ITEMS.add(EMERALD_HOE);
		ITEMS.add(EMERALD_PICKAXE);
		ITEMS.add(EMERALD_SHOVEL);
		ITEMS.add(EMERALD_SWORD);
		
		ITEMS.add(EMERALD_HELMET);
		ITEMS.add(EMERALD_CHEST);
		ITEMS.add(EMERALD_LEGGS);
		ITEMS.add(EMERALD_BOOTS);

		ITEMS.add(CAPACITOR4K);
		ITEMS.add(CAPACITOR8K);
		ITEMS.add(CAPACITOR16K);
		ITEMS.add(CAPACITOR32K);
		ITEMS.add(CAPACITOR64K);
		ITEMS.add(CAPACITOR128K);
		ITEMS.add(CAPACITOR512K);
		ITEMS.add(CAPACITOR1024K);

		for (Item item : ITEMS) {
			GameRegistry.register(item);
		}

	}

}
