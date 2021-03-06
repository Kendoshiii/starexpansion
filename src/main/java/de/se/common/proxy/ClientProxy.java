package de.se.common.proxy;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.common.items.material.ItemDust;
import de.se.common.items.material.ItemIngot;
import de.se.common.items.material.ItemNugget;
import de.se.common.items.material.ItemPlate;
import de.se.common.lib.Reference;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
		ModelBakery.registerItemVariants(SEItems.INGOT, 
				new ResourceLocation(Reference.MODID + ":ingot_copper"),
				new ResourceLocation(Reference.MODID + ":ingot_tin"),
				new ResourceLocation(Reference.MODID + ":ingot_bronze"),
				new ResourceLocation(Reference.MODID + ":ingot_silver"),
				new ResourceLocation(Reference.MODID + ":ingot_lead"),
				new ResourceLocation(Reference.MODID + ":ingot_steel")
		
		);
		
		ModelBakery.registerItemVariants(SEItems.NUGGET, 
				new ResourceLocation(Reference.MODID + ":nugget_copper"),
				new ResourceLocation(Reference.MODID + ":nugget_tin"),
				new ResourceLocation(Reference.MODID + ":nugget_bronze"),
				new ResourceLocation(Reference.MODID + ":nugget_silver"),
				new ResourceLocation(Reference.MODID + ":nugget_lead"),
				new ResourceLocation(Reference.MODID + ":nugget_steel")
		
		);
		
		ModelBakery.registerItemVariants(SEItems.PLATE, 
				new ResourceLocation(Reference.MODID + ":plate_copper"),
				new ResourceLocation(Reference.MODID + ":plate_tin"),
				new ResourceLocation(Reference.MODID + ":plate_bronze"),
				new ResourceLocation(Reference.MODID + ":plate_silver"),
				new ResourceLocation(Reference.MODID + ":plate_lead"),
				new ResourceLocation(Reference.MODID + ":plate_steel"),
				new ResourceLocation(Reference.MODID + ":plate_iron"),
				new ResourceLocation(Reference.MODID + ":plate_gold")
		
		);
		
		ModelBakery.registerItemVariants(SEItems.DUST, 
				new ResourceLocation(Reference.MODID + ":dust_copper"),
				new ResourceLocation(Reference.MODID + ":dust_tin"),
				new ResourceLocation(Reference.MODID + ":dust_bronze"),
				new ResourceLocation(Reference.MODID + ":dust_silver"),
				new ResourceLocation(Reference.MODID + ":dust_lead"),
				new ResourceLocation(Reference.MODID + ":dust_carbon"),
				new ResourceLocation(Reference.MODID + ":dust_steel"),
				new ResourceLocation(Reference.MODID + ":dust_iron"),
				new ResourceLocation(Reference.MODID + ":dust_gold")
		
		);
		
		
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_COPPER, new ModelResourceLocation(Reference.MODID + ":ingot_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_TIN, new ModelResourceLocation(Reference.MODID + ":ingot_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_BRONZE, new ModelResourceLocation(Reference.MODID + ":ingot_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_SILVER, new ModelResourceLocation(Reference.MODID + ":ingot_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_LEAD, new ModelResourceLocation(Reference.MODID + ":ingot_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_STEEL, new ModelResourceLocation(Reference.MODID + ":ingot_steel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_CARBON_IRON, new ModelResourceLocation(Reference.MODID + ":ingot_carbon_iron", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_RADIANT_STAR, new ModelResourceLocation(Reference.MODID + ":ingot_radiant_star", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_COPPER, new ModelResourceLocation(Reference.MODID + ":plate_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_TIN, new ModelResourceLocation(Reference.MODID + ":plate_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_BRONZE, new ModelResourceLocation(Reference.MODID + ":plate_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_SILVER, new ModelResourceLocation(Reference.MODID + ":plate_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_LEAD, new ModelResourceLocation(Reference.MODID + ":plate_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_STEEL, new ModelResourceLocation(Reference.MODID + ":plate_steel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_IRON, new ModelResourceLocation(Reference.MODID + ":plate_iron", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_GOLD, new ModelResourceLocation(Reference.MODID + ":plate_gold", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_COPPER, new ModelResourceLocation(Reference.MODID + ":dust_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_TIN, new ModelResourceLocation(Reference.MODID + ":dust_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_BRONZE, new ModelResourceLocation(Reference.MODID + ":dust_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_SILVER, new ModelResourceLocation(Reference.MODID + ":dust_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_LEAD, new ModelResourceLocation(Reference.MODID + ":dust_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_CARBON, new ModelResourceLocation(Reference.MODID + ":dust_carbon", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_STEEL, new ModelResourceLocation(Reference.MODID + ":dust_steel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_IRON, new ModelResourceLocation(Reference.MODID + ":dust_iron", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_GOLD, new ModelResourceLocation(Reference.MODID + ":dust_gold", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_COPPER, new ModelResourceLocation(Reference.MODID + ":nugget_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_TIN, new ModelResourceLocation(Reference.MODID + ":nugget_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_BRONZE, new ModelResourceLocation(Reference.MODID + ":nugget_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_SILVER, new ModelResourceLocation(Reference.MODID + ":nugget_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_LEAD, new ModelResourceLocation(Reference.MODID + ":nugget_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_STEEL, new ModelResourceLocation(Reference.MODID + ":nugget_steel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.BATTERY, 0, new ModelResourceLocation(Reference.MODID + ":battery", "inventory"));

		ModelLoader.setCustomModelResourceLocation(SEItems.GROWTH_CRYSTAL, 0, new ModelResourceLocation(Reference.MODID + ":growth_crystal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.LAVA_CRYSTAL, 0, new ModelResourceLocation(Reference.MODID + ":lava_crystal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.WATER_CRYSTAL, 0, new ModelResourceLocation(Reference.MODID + ":water_crystal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.WATERING_CRYSTAL, 0, new ModelResourceLocation(Reference.MODID + ":water_crystal", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_AXE, 0, new ModelResourceLocation(Reference.MODID + ":copper_axe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_AXE, 0, new ModelResourceLocation(Reference.MODID + ":bronze_axe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_AXE, 0, new ModelResourceLocation(Reference.MODID + ":emerald_axe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_HOE, 0, new ModelResourceLocation(Reference.MODID + ":copper_hoe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_HOE, 0, new ModelResourceLocation(Reference.MODID + ":bronze_hoe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_HOE, 0, new ModelResourceLocation(Reference.MODID + ":emerald_hoe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_PICKAXE, 0, new ModelResourceLocation(Reference.MODID + ":copper_pickaxe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_PICKAXE, 0, new ModelResourceLocation(Reference.MODID + ":bronze_pickaxe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_PICKAXE, 0, new ModelResourceLocation(Reference.MODID + ":emerald_pickaxe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_SHOVEL, 0, new ModelResourceLocation(Reference.MODID + ":copper_shovel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_SHOVEL, 0, new ModelResourceLocation(Reference.MODID + ":bronze_shovel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_SHOVEL, 0, new ModelResourceLocation(Reference.MODID + ":emerald_shovel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_SWORD, 0, new ModelResourceLocation(Reference.MODID + ":copper_sword", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_SWORD, 0, new ModelResourceLocation(Reference.MODID + ":bronze_sword", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_SWORD, 0, new ModelResourceLocation(Reference.MODID + ":emerald_sword", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.WOODEN_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":wooden_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.STONE_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":stone_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.IRON_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":iron_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.GOLD_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":golden_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DIAMOND_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":diamond_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":copper_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":bronze_paxel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_PAXEL, 0, new ModelResourceLocation(Reference.MODID + ":emerald_paxel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.FORGE_HAMMER, 0, new ModelResourceLocation(Reference.MODID + ":forge_hammer", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR4K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR8K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR16K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR32K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR64K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR128K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR512K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR1024K, 0, new ModelResourceLocation(Reference.MODID + ":capacitor", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.COPPER_ORE), 0, new ModelResourceLocation(Reference.MODID + ":orecopper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.TIN_ORE), 0, new ModelResourceLocation(Reference.MODID + ":oretin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.SILVER_ORE), 0, new ModelResourceLocation(Reference.MODID + ":oresilver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.LEAD_ORE), 0, new ModelResourceLocation(Reference.MODID + ":orelead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.RADIANT_ORE), 0, new ModelResourceLocation(Reference.MODID + ":oreradiant", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.COPPER_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blockcopper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.TIN_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blocktin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.BRONZE_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blockbronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.SILVER_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blocksilver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.LEAD_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blocklead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.RADIANT_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blockradiant", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.METEORIE_BLOCK), 0, new ModelResourceLocation(Reference.MODID + ":blockmeteorite", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.MACHINE_FRAME), 0, new ModelResourceLocation(Reference.MODID + ":blockmachineframe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.REPAIRER), 0, new ModelResourceLocation(Reference.MODID + ":blockfluxrepairer", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.STEEL_CASE), 0, new ModelResourceLocation(Reference.MODID + ":blocksteelcase", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.RADIANT_GLASS), 0, new ModelResourceLocation(Reference.MODID + ":blockatreactorglass", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.ATREACTOR_CONTROLLER), 0, new ModelResourceLocation(Reference.MODID + ":blockatreactorcontroller", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.ATREACTOR_POWER_CONNECTOR), 0, new ModelResourceLocation(Reference.MODID + ":blockatreactorpowerconnector", "inventory"));

		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_HELMET, 0, new ModelResourceLocation(Reference.MODID + ":emerald_helmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_CHEST, 0, new ModelResourceLocation(Reference.MODID + ":emerald_chest", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_LEGGS, 0, new ModelResourceLocation(Reference.MODID + ":emerald_leggs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_BOOTS, 0, new ModelResourceLocation(Reference.MODID + ":emerald_boots", "inventory"));
	
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.init(e);
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}
	
}
