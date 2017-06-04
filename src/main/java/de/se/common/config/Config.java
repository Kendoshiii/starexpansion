package de.se.common.config;

import java.io.File;

import de.se.StarExpansion;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {
	
	public static Configuration settings;
	public static Configuration oreGen;
	public static Configuration energy;
	public static final String categorySettings = "settings";
	public static final String categoryDurability = "durability";
	public static final String categoryCompat = "compat";
	public static final String categoryEnergy = "energy";
	public static final String categoryOreGen = "oreGen";
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e){
		
		if(e.getModID().equals(StarExpansion.MODID)){
			settings();
			energyConfig();
			oreGenConfig();
		}
		
	}
	  
	
	public static void init(File file){
		File directory = file;
		settings = new Configuration(new File(directory.getPath(), "starexpansion.cfg"));
		oreGen = new Configuration(new File(directory.getPath(), "oreGen.cfg"));
		energy = new Configuration(new File(directory.getPath(), "energy.cfg"));

		settings();
		energyConfig();
		oreGenConfig();
	}
	
	private static void settings() {
		
		settings.addCustomCategoryComment(categorySettings, "Settings for all things in Improved Metals");
		ConfigValues.copperTools = settings.getBoolean("Copper Tools", categorySettings, ConfigValues.copperTools, "Enable/Disable Copper Tools");
		ConfigValues.bronzeTools = settings.getBoolean("Bronze Tools", categorySettings, ConfigValues.bronzeTools, "Enable/Disable Bronze Tools");
		ConfigValues.emeraldTools = settings.getBoolean("Emerald Tools", categorySettings, ConfigValues.emeraldTools, "Enable/Disable Emerald Tools");
		ConfigValues.flatBedrockGen = settings.getBoolean("Flat Bedrock Generation", categorySettings, ConfigValues.flatBedrockGen, "Enable/Disable the flat generation of Bedrock");
		
		settings.addCustomCategoryComment(categoryDurability, "Set the Durability of Items, Tools and Armor");
		ConfigValues.copperToolsDurability = settings.getInt("Durability Copper Tools", categoryDurability, ConfigValues.copperToolsDurability, 1, Integer.MAX_VALUE, "Set the durability Copper Tools should have!");
		ConfigValues.bronzeToolsDurability = settings.getInt("Durability Bronze Tools", categoryDurability, ConfigValues.bronzeToolsDurability, 1, Integer.MAX_VALUE, "Set the durability Bronze Tools should have!");
		ConfigValues.emeraldToolsDurability = settings.getInt("Durability Emerald Tools", categoryDurability, ConfigValues.emeraldToolsDurability, 1, Integer.MAX_VALUE, "Set the durability Emerald Tools should have!");
		ConfigValues.emeraldArmorDurability = settings.getInt("Durability Emerald Armor", categoryDurability, ConfigValues.emeraldArmorDurability, 1, Integer.MAX_VALUE, "Set the durability Emerald Armor should have!");
				
		settings.addCustomCategoryComment(categoryCompat, "Enable or Disable compatibility between mods");
		ConfigValues.compatTOP = settings.getBoolean("Compatibility The One Probe", categoryCompat, ConfigValues.compatTOP, "Enable/Disable compatibility with The One Probe");
		if(settings.hasChanged()){
			settings.save();
		}
		
	}

	private static void energyConfig(){
		
		energy.addCustomCategoryComment(categoryEnergy, "Enable/Disable the Generation and Storage of Energy(SF)");
		ConfigValues.reactorGeneration = energy.getInt("Reactor Generation", categoryEnergy, ConfigValues.reactorGeneration, 1, 1024, "The amount of SF the reactor generates!");
		
		ConfigValues.smallSFCapacitorCapacity = energy.getInt("Small Star-Flux Capacitor Capacity", categoryEnergy, ConfigValues.smallSFCapacitorCapacity, 1, Integer.MAX_VALUE, "");
		ConfigValues.smallSFCapacitorIn = energy.getInt("Small Star-Flux Capacitor Input", categoryEnergy, ConfigValues.smallSFCapacitorIn, 1, Integer.MAX_VALUE, "");
		ConfigValues.smallSFCapacitorOut = energy.getInt("Small Star-Flux Capacitor Output", categoryEnergy, ConfigValues.smallSFCapacitorOut, 1, Integer.MAX_VALUE, "");

		ConfigValues.mediumSFCapacitorCapacity = energy.getInt("Medium Star-Flux Capacitor Capacity", categoryEnergy, ConfigValues.mediumSFCapacitorCapacity, 1, Integer.MAX_VALUE, "");
		ConfigValues.mediumSFCapacitorIn = energy.getInt("Medium Star-Flux Capacitor Input", categoryEnergy, ConfigValues.mediumSFCapacitorIn, 1, Integer.MAX_VALUE, "");
		ConfigValues.mediumSFCapacitorOut = energy.getInt("Medium Star-Flux Capacitor Output", categoryEnergy, ConfigValues.mediumSFCapacitorOut, 1, Integer.MAX_VALUE, "");

		ConfigValues.largeSFCapacitorCapacity = energy.getInt("Large Star-Flux Capacitor Capacity", categoryEnergy, ConfigValues.largeSFCapacitorCapacity, 1, Integer.MAX_VALUE, "");
		ConfigValues.largeSFCapacitorIn = energy.getInt("Large Star-Flux Capacitor Input", categoryEnergy, ConfigValues.largeSFCapacitorIn, 1, Integer.MAX_VALUE, "");
		ConfigValues.largeSFCapacitorOut = energy.getInt("Large Star-Flux Capacitor Output", categoryEnergy, ConfigValues.largeSFCapacitorOut, 1, Integer.MAX_VALUE, "");

		if(energy.hasChanged()){
			energy.save();
		}
		
	}
	
	private static void oreGenConfig(){
		
		oreGen.addCustomCategoryComment(categoryOreGen, "Enable/Disable Ore Generation and the Vein Size");
		ConfigValues.oreGenCopper = oreGen.getBoolean("Generation Copper Ore", categoryOreGen, ConfigValues.oreGenCopper, "Enable/Disable the generation of Copper Ore");
		ConfigValues.oreGenCopperMinVeinSize = oreGen.getInt("Copper Ore Minimum Vein Size", categoryOreGen, ConfigValues.oreGenCopperMinVeinSize, 1, 3, "Set the min vein size of Copper Ore");
		ConfigValues.oreGenCopperMaxVeinSize = oreGen.getInt("Copper Ore Maximum Vein Size", categoryOreGen, ConfigValues.oreGenCopperMaxVeinSize, 4, 8, "Set the max vein size of Copper Ore");
		ConfigValues.oreGenCopperMinY = oreGen.getInt("Copper Ore Minimum Y", categoryOreGen, ConfigValues.oreGenCopperMinY, 1, 256, "Set the minY-Level for Copper Ore to generate");
		ConfigValues.oreGenCopperMaxY = oreGen.getInt("Copper Ore Maximum Y", categoryOreGen, ConfigValues.oreGenCopperMaxY, 1, 256, "Set the maxY-Level for Copper Ore to generate");
		
		ConfigValues.oreGenTin = oreGen.getBoolean("Generation Tin Ore", categoryOreGen, ConfigValues.oreGenTin, "Enable/Disable the generation of Tin Ore");
		ConfigValues.oreGenTinMinVeinSize = oreGen.getInt("Tin Ore Minimum Vein Size", categoryOreGen, ConfigValues.oreGenTinMinVeinSize, 1, 3, "Set the min vein size of Tin Ore");
		ConfigValues.oreGenTinMaxVeinSize = oreGen.getInt("Tin Ore Maximum Vein Size", categoryOreGen, ConfigValues.oreGenTinMaxVeinSize, 4, 8, "Set the max vein size of Tin Ore");
		ConfigValues.oreGenTinMinY = oreGen.getInt("Tin Ore Minimum Y", categoryOreGen, ConfigValues.oreGenTinMinY, 1, 256, "Set the minY-Level for Tin Ore to generate");
		ConfigValues.oreGenTinMaxY = oreGen.getInt("Tin Ore Maximum Y", categoryOreGen, ConfigValues.oreGenTinMaxY, 1, 256, "Set the maxY-Level for Tin Ore to generate");
		
		ConfigValues.oreGenSilver = oreGen.getBoolean("Generation Silver Ore", categoryOreGen, ConfigValues.oreGenSilver, "Enable/Disable the generation of Silver Ore");
		ConfigValues.oreGenSilverMinVeinSize = oreGen.getInt("Silver Ore Minimum Vein Size", categoryOreGen, ConfigValues.oreGenSilverMinVeinSize, 1, 2, "Set the min vein size of Silver Ore");
		ConfigValues.oreGenSilverMaxVeinSize = oreGen.getInt("Silver Ore Maximum", categoryOreGen, ConfigValues.oreGenSilverMaxVeinSize, 3, 4, "Set the max vein size of Silver Ore");
		ConfigValues.oreGenSilverMinY = oreGen.getInt("Silver Ore Minimum Y", categoryOreGen, ConfigValues.oreGenSilverMinY, 1, 256, "Set the minY-Level for Silver Ore to generate");
		ConfigValues.oreGenSilverMaxY = oreGen.getInt("Silver Ore Maximum Y", categoryOreGen, ConfigValues.oreGenSilverMaxY, 1, 256, "Set the maxY-Level for Silver Ore to generate");
		
		ConfigValues.oreGenLead = oreGen.getBoolean("Generation Lead Ore", categoryOreGen, ConfigValues.oreGenLead, "Enable/Disable the generation of Lead Ore");
		ConfigValues.oreGenLeadMinVeinSize = oreGen.getInt("Lead Ore Min Minimum Size", categoryOreGen, ConfigValues.oreGenLeadMinVeinSize, 1, 2, "Set the min vein size of Lead Ore");
		ConfigValues.oreGenLeadMaxVeinSize = oreGen.getInt("Lead Ore Maximum Vein Size", categoryOreGen, ConfigValues.oreGenLeadMaxVeinSize, 3, 4, "Set the max vein size of Lead Ore");
		ConfigValues.oreGenLeadMinY = oreGen.getInt("Lead Ore Minimum Y", categoryOreGen, ConfigValues.oreGenLeadMinY, 1, 256, "Set the minY-Level for Lead Ore to generate");
		ConfigValues.oreGenLeadMaxY = oreGen.getInt("Lead Ore Maximum Y", categoryOreGen, ConfigValues.oreGenLeadMaxY, 1, 256, "Set the maxY-Level for Lead Ore to generate");
		
		ConfigValues.flatBedrockGen = oreGen.getBoolean("Generation flat bedrock", categoryOreGen, ConfigValues.flatBedrockGen, "Enable or Disable flat bedrock");
		
		if(oreGen.hasChanged()){
			oreGen.save();
		}
		
	}
	
}
