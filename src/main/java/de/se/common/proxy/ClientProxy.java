package de.se.common.proxy;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.StarExpansion;
import de.se.common.items.material.ItemDust;
import de.se.common.items.material.ItemIngot;
import de.se.common.items.material.ItemNugget;
import de.se.common.items.material.ItemPlate;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
		ModelBakery.registerItemVariants(SEItems.INGOT, 
				new ResourceLocation(StarExpansion.MODID + ":ingot_copper"),
				new ResourceLocation(StarExpansion.MODID + ":ingot_tin"),
				new ResourceLocation(StarExpansion.MODID + ":ingot_bronze"),
				new ResourceLocation(StarExpansion.MODID + ":ingot_silver"),
				new ResourceLocation(StarExpansion.MODID + ":ingot_lead"),
				new ResourceLocation(StarExpansion.MODID + ":ingot_steel")
		
		);
		
		ModelBakery.registerItemVariants(SEItems.NUGGET, 
				new ResourceLocation(StarExpansion.MODID + ":nugget_copper"),
				new ResourceLocation(StarExpansion.MODID + ":nugget_tin"),
				new ResourceLocation(StarExpansion.MODID + ":nugget_bronze"),
				new ResourceLocation(StarExpansion.MODID + ":nugget_silver"),
				new ResourceLocation(StarExpansion.MODID + ":nugget_lead"),
				new ResourceLocation(StarExpansion.MODID + ":nugget_steel")
		
		);
		
		ModelBakery.registerItemVariants(SEItems.PLATE, 
				new ResourceLocation(StarExpansion.MODID + ":plate_copper"),
				new ResourceLocation(StarExpansion.MODID + ":plate_tin"),
				new ResourceLocation(StarExpansion.MODID + ":plate_bronze"),
				new ResourceLocation(StarExpansion.MODID + ":plate_silver"),
				new ResourceLocation(StarExpansion.MODID + ":plate_lead"),
				new ResourceLocation(StarExpansion.MODID + ":plate_steel")
		
		);
		
		ModelBakery.registerItemVariants(SEItems.DUST, 
				new ResourceLocation(StarExpansion.MODID + ":dust_copper"),
				new ResourceLocation(StarExpansion.MODID + ":dust_tin"),
				new ResourceLocation(StarExpansion.MODID + ":dust_bronze"),
				new ResourceLocation(StarExpansion.MODID + ":dust_silver"),
				new ResourceLocation(StarExpansion.MODID + ":dust_lead"),
				new ResourceLocation(StarExpansion.MODID + ":dust_carbon"),
				new ResourceLocation(StarExpansion.MODID + ":dust_steel")
		
		);
		
		
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_COPPER, new ModelResourceLocation(StarExpansion.MODID + ":ingot_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_TIN, new ModelResourceLocation(StarExpansion.MODID + ":ingot_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_BRONZE, new ModelResourceLocation(StarExpansion.MODID + ":ingot_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_SILVER, new ModelResourceLocation(StarExpansion.MODID + ":ingot_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_LEAD, new ModelResourceLocation(StarExpansion.MODID + ":ingot_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_STEEL, new ModelResourceLocation(StarExpansion.MODID + ":ingot_steel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_CARBON_IRON, new ModelResourceLocation(StarExpansion.MODID + ":ingot_carbon_iron", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.INGOT, ItemIngot.INGOT_RADIANT_STAR, new ModelResourceLocation(StarExpansion.MODID + ":ingot_radiant_star", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_COPPER, new ModelResourceLocation(StarExpansion.MODID + ":plate_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_TIN, new ModelResourceLocation(StarExpansion.MODID + ":plate_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_BRONZE, new ModelResourceLocation(StarExpansion.MODID + ":plate_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_SILVER, new ModelResourceLocation(StarExpansion.MODID + ":plate_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_LEAD, new ModelResourceLocation(StarExpansion.MODID + ":plate_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.PLATE, ItemPlate.PLATE_STEEL, new ModelResourceLocation(StarExpansion.MODID + ":plate_steel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_COPPER, new ModelResourceLocation(StarExpansion.MODID + ":dust_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_TIN, new ModelResourceLocation(StarExpansion.MODID + ":dust_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_BRONZE, new ModelResourceLocation(StarExpansion.MODID + ":dust_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_SILVER, new ModelResourceLocation(StarExpansion.MODID + ":dust_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_LEAD, new ModelResourceLocation(StarExpansion.MODID + ":dust_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_CARBON, new ModelResourceLocation(StarExpansion.MODID + ":dust_carbon", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.DUST, ItemDust.DUST_STEEL, new ModelResourceLocation(StarExpansion.MODID + ":dust_steel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_COPPER, new ModelResourceLocation(StarExpansion.MODID + ":nugget_copper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_TIN, new ModelResourceLocation(StarExpansion.MODID + ":nugget_tin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_BRONZE, new ModelResourceLocation(StarExpansion.MODID + ":nugget_bronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_SILVER, new ModelResourceLocation(StarExpansion.MODID + ":nugget_silver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_LEAD, new ModelResourceLocation(StarExpansion.MODID + ":nugget_lead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.NUGGET, ItemNugget.NUGGET_STEEL, new ModelResourceLocation(StarExpansion.MODID + ":nugget_steel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.BATTERY, 0, new ModelResourceLocation(StarExpansion.MODID + ":battery", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.EXPERIENCE_PEARL, 0, new ModelResourceLocation(StarExpansion.MODID + ":experience_pearl", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.GROWTH_CRYSTAL, 0, new ModelResourceLocation(StarExpansion.MODID + ":growth_crystal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.LAVA_CRYSTAL, 0, new ModelResourceLocation(StarExpansion.MODID + ":lava_crystal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.WATER_CRYSTAL, 0, new ModelResourceLocation(StarExpansion.MODID + ":water_crystal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.WATERING_CRYSTAL, 0, new ModelResourceLocation(StarExpansion.MODID + ":water_crystal", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_AXE, 0, new ModelResourceLocation(StarExpansion.MODID + ":copper_axe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_AXE, 0, new ModelResourceLocation(StarExpansion.MODID + ":bronze_axe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_AXE, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_axe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_HOE, 0, new ModelResourceLocation(StarExpansion.MODID + ":copper_hoe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_HOE, 0, new ModelResourceLocation(StarExpansion.MODID + ":bronze_hoe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_HOE, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_hoe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_PICKAXE, 0, new ModelResourceLocation(StarExpansion.MODID + ":copper_pickaxe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_PICKAXE, 0, new ModelResourceLocation(StarExpansion.MODID + ":bronze_pickaxe", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_PICKAXE, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_pickaxe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_SHOVEL, 0, new ModelResourceLocation(StarExpansion.MODID + ":copper_shovel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_SHOVEL, 0, new ModelResourceLocation(StarExpansion.MODID + ":bronze_shovel", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_SHOVEL, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_shovel", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.COPPER_SWORD, 0, new ModelResourceLocation(StarExpansion.MODID + ":copper_sword", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.BRONZE_SWORD, 0, new ModelResourceLocation(StarExpansion.MODID + ":bronze_sword", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_SWORD, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_sword", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.FORGE_HAMMER, 0, new ModelResourceLocation(StarExpansion.MODID + ":forge_hammer", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR4K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR8K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR16K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR32K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR64K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR128K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR512K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.CAPACITOR1024K, 0, new ModelResourceLocation(StarExpansion.MODID + ":capacitor", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.COPPER_ORE), 0, new ModelResourceLocation(StarExpansion.MODID + ":orecopper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.TIN_ORE), 0, new ModelResourceLocation(StarExpansion.MODID + ":oretin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.SILVER_ORE), 0, new ModelResourceLocation(StarExpansion.MODID + ":oresilver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.LEAD_ORE), 0, new ModelResourceLocation(StarExpansion.MODID + ":orelead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.RADIANT_ORE), 0, new ModelResourceLocation(StarExpansion.MODID + ":oreradiant", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.COPPER_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockcopper", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.TIN_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blocktin", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.BRONZE_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockbronze", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.SILVER_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blocksilver", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.LEAD_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blocklead", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.RADIANT_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockradiant", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.METEORIE_BLOCK), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockmeteorite", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.MACHINE_FRAME), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockmachineframe", "inventory"));
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.STEEL_CASE), 0, new ModelResourceLocation(StarExpansion.MODID + ":blocksteelcase", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.RADIANT_GLASS), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockatreactorglass", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.ATREACTOR_CONTROLLER), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockatreactorcontroller", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SEBlocks.ATREACTOR_POWER_CONNECTOR), 0, new ModelResourceLocation(StarExpansion.MODID + ":blockatreactorpowerconnector", "inventory"));

		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_HELMET, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_helmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_CHEST, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_chest", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_LEGGS, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_leggs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(SEItems.EMERALD_BOOTS, 0, new ModelResourceLocation(StarExpansion.MODID + ":emerald_boots", "inventory"));
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
