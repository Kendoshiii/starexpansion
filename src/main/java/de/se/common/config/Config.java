package de.se.common.config;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

import de.se.common.lib.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config {
	
	public static Configuration cfg;
	public static final String categorySettings = "settings";
	public static final String categoryDurability = "durability";
	public static final String categoryCompat = "compat";
	public static final String categoryEnergy = "energy";
	public static final String categoryOreGen = "oreGen";
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent e){
		
		if(e.getModID().equalsIgnoreCase(Reference.MODID)){
			initialize();
		}
		
	}
	  
	
	public static void init(File file){
		File directory = file;
		cfg = new Configuration(new File(directory.getPath(), "starexpansion.cfg"));

		initialize();
	}
	
	private static void initialize() {
		
		cfg.addCustomCategoryComment(categorySettings, "Settings for all things in Improved Metals");
		ConfigValues.copperTools = cfg.getBoolean("Copper Tools", categorySettings, ConfigValues.copperTools, "Enable/Disable Copper Tools");
		ConfigValues.bronzeTools = cfg.getBoolean("Bronze Tools", categorySettings, ConfigValues.bronzeTools, "Enable/Disable Bronze Tools");
		ConfigValues.emeraldTools = cfg.getBoolean("Emerald Tools", categorySettings, ConfigValues.emeraldTools, "Enable/Disable Emerald Tools");
		ConfigValues.flatBedrockGen = cfg.getBoolean("Flat Bedrock Generation", categorySettings, ConfigValues.flatBedrockGen, "Enable/Disable the flat generation of Bedrock");
		
		cfg.addCustomCategoryComment(categoryDurability, "Set the Durability of Items, Tools and Armor");
		ConfigValues.copperToolsDurability = cfg.getInt("Durability Copper Tools", categoryDurability, ConfigValues.copperToolsDurability, 1, Integer.MAX_VALUE, "Set the durability Copper Tools should have!");
		ConfigValues.bronzeToolsDurability = cfg.getInt("Durability Bronze Tools", categoryDurability, ConfigValues.bronzeToolsDurability, 1, Integer.MAX_VALUE, "Set the durability Bronze Tools should have!");
		ConfigValues.emeraldToolsDurability = cfg.getInt("Durability Emerald Tools", categoryDurability, ConfigValues.emeraldToolsDurability, 1, Integer.MAX_VALUE, "Set the durability Emerald Tools should have!");
		ConfigValues.emeraldArmorDurability = cfg.getInt("Durability Emerald Armor", categoryDurability, ConfigValues.emeraldArmorDurability, 1, Integer.MAX_VALUE, "Set the durability Emerald Armor should have!");
				
		cfg.addCustomCategoryComment(categoryCompat, "Enable or Disable compatibility between mods");
		ConfigValues.compatTOP = cfg.getBoolean("Compatibility The One Probe", categoryCompat, ConfigValues.compatTOP, "Enable/Disable compatibility with The One Probe");
		
		energyConfig();
		oreGenConfig();
		
		if(cfg.hasChanged()){
			cfg.save();
		}
		
	}

	private static void energyConfig(){
		
		cfg.addCustomCategoryComment(categoryEnergy, "Enable/Disable the Generation and Storage of Energy(SF)");
		ConfigValues.reactorGeneration = cfg.getInt("Reactor Generation", categoryEnergy, ConfigValues.reactorGeneration, 1, 1024, "The amount of SF the reactor generates!");
		
		ConfigValues.smallSFCapacitorCapacity = cfg.getInt("Small Star-Flux Capacitor Capacity", categoryEnergy, ConfigValues.smallSFCapacitorCapacity, 1, Integer.MAX_VALUE, "");
		ConfigValues.smallSFCapacitorIn = cfg.getInt("Small Star-Flux Capacitor Input", categoryEnergy, ConfigValues.smallSFCapacitorIn, 1, Integer.MAX_VALUE, "");
		ConfigValues.smallSFCapacitorOut = cfg.getInt("Small Star-Flux Capacitor Output", categoryEnergy, ConfigValues.smallSFCapacitorOut, 1, Integer.MAX_VALUE, "");

		ConfigValues.mediumSFCapacitorCapacity = cfg.getInt("Medium Star-Flux Capacitor Capacity", categoryEnergy, ConfigValues.mediumSFCapacitorCapacity, 1, Integer.MAX_VALUE, "");
		ConfigValues.mediumSFCapacitorIn = cfg.getInt("Medium Star-Flux Capacitor Input", categoryEnergy, ConfigValues.mediumSFCapacitorIn, 1, Integer.MAX_VALUE, "");
		ConfigValues.mediumSFCapacitorOut = cfg.getInt("Medium Star-Flux Capacitor Output", categoryEnergy, ConfigValues.mediumSFCapacitorOut, 1, Integer.MAX_VALUE, "");

		ConfigValues.largeSFCapacitorCapacity = cfg.getInt("Large Star-Flux Capacitor Capacity", categoryEnergy, ConfigValues.largeSFCapacitorCapacity, 1, Integer.MAX_VALUE, "");
		ConfigValues.largeSFCapacitorIn = cfg.getInt("Large Star-Flux Capacitor Input", categoryEnergy, ConfigValues.largeSFCapacitorIn, 1, Integer.MAX_VALUE, "");
		ConfigValues.largeSFCapacitorOut = cfg.getInt("Large Star-Flux Capacitor Output", categoryEnergy, ConfigValues.largeSFCapacitorOut, 1, Integer.MAX_VALUE, "");

		ConfigValues.restrictRepairs = cfg.get(categoryEnergy, "Restricted", false, "If true, will only repair things that extend the tool, armor, sword and bow classes.").getBoolean(false);
		ConfigValues.blProperty = cfg.get(categoryEnergy, "Blacklist", new String[0], "Item classes that appear in this list will not be repaired by the Reconstructor.");
		ConfigValues.repairerBlacklist = new HashSet<String>(Arrays.asList(ConfigValues.blProperty.getStringList()));
		
		if(cfg.hasChanged()){
			cfg.save();
		}
		
	}
	
	private static void oreGenConfig(){
		
		cfg.addCustomCategoryComment(categoryOreGen, "Enable/Disable Ore Generation and the Vein Size");
		ConfigValues.oreGenCopper = cfg.getBoolean("Generation Copper Ore", categoryOreGen, ConfigValues.oreGenCopper, "Enable/Disable the generation of Copper Ore");
		ConfigValues.oreGenCopperMinVeinSize = cfg.getInt("Copper Ore Minimum Vein Size", categoryOreGen, ConfigValues.oreGenCopperMinVeinSize, 1, 3, "Set the min vein size of Copper Ore");
		ConfigValues.oreGenCopperMaxVeinSize = cfg.getInt("Copper Ore Maximum Vein Size", categoryOreGen, ConfigValues.oreGenCopperMaxVeinSize, 4, 8, "Set the max vein size of Copper Ore");
		ConfigValues.oreGenCopperMinY = cfg.getInt("Copper Ore Minimum Y", categoryOreGen, ConfigValues.oreGenCopperMinY, 1, 256, "Set the minY-Level for Copper Ore to generate");
		ConfigValues.oreGenCopperMaxY = cfg.getInt("Copper Ore Maximum Y", categoryOreGen, ConfigValues.oreGenCopperMaxY, 1, 256, "Set the maxY-Level for Copper Ore to generate");
		
		ConfigValues.oreGenTin = cfg.getBoolean("Generation Tin Ore", categoryOreGen, ConfigValues.oreGenTin, "Enable/Disable the generation of Tin Ore");
		ConfigValues.oreGenTinMinVeinSize = cfg.getInt("Tin Ore Minimum Vein Size", categoryOreGen, ConfigValues.oreGenTinMinVeinSize, 1, 3, "Set the min vein size of Tin Ore");
		ConfigValues.oreGenTinMaxVeinSize = cfg.getInt("Tin Ore Maximum Vein Size", categoryOreGen, ConfigValues.oreGenTinMaxVeinSize, 4, 8, "Set the max vein size of Tin Ore");
		ConfigValues.oreGenTinMinY = cfg.getInt("Tin Ore Minimum Y", categoryOreGen, ConfigValues.oreGenTinMinY, 1, 256, "Set the minY-Level for Tin Ore to generate");
		ConfigValues.oreGenTinMaxY = cfg.getInt("Tin Ore Maximum Y", categoryOreGen, ConfigValues.oreGenTinMaxY, 1, 256, "Set the maxY-Level for Tin Ore to generate");
		
		ConfigValues.oreGenSilver = cfg.getBoolean("Generation Silver Ore", categoryOreGen, ConfigValues.oreGenSilver, "Enable/Disable the generation of Silver Ore");
		ConfigValues.oreGenSilverMinVeinSize = cfg.getInt("Silver Ore Minimum Vein Size", categoryOreGen, ConfigValues.oreGenSilverMinVeinSize, 1, 2, "Set the min vein size of Silver Ore");
		ConfigValues.oreGenSilverMaxVeinSize = cfg.getInt("Silver Ore Maximum", categoryOreGen, ConfigValues.oreGenSilverMaxVeinSize, 3, 4, "Set the max vein size of Silver Ore");
		ConfigValues.oreGenSilverMinY = cfg.getInt("Silver Ore Minimum Y", categoryOreGen, ConfigValues.oreGenSilverMinY, 1, 256, "Set the minY-Level for Silver Ore to generate");
		ConfigValues.oreGenSilverMaxY = cfg.getInt("Silver Ore Maximum Y", categoryOreGen, ConfigValues.oreGenSilverMaxY, 1, 256, "Set the maxY-Level for Silver Ore to generate");
		
		ConfigValues.oreGenLead = cfg.getBoolean("Generation Lead Ore", categoryOreGen, ConfigValues.oreGenLead, "Enable/Disable the generation of Lead Ore");
		ConfigValues.oreGenLeadMinVeinSize = cfg.getInt("Lead Ore Min Minimum Size", categoryOreGen, ConfigValues.oreGenLeadMinVeinSize, 1, 2, "Set the min vein size of Lead Ore");
		ConfigValues.oreGenLeadMaxVeinSize = cfg.getInt("Lead Ore Maximum Vein Size", categoryOreGen, ConfigValues.oreGenLeadMaxVeinSize, 3, 4, "Set the max vein size of Lead Ore");
		ConfigValues.oreGenLeadMinY = cfg.getInt("Lead Ore Minimum Y", categoryOreGen, ConfigValues.oreGenLeadMinY, 1, 256, "Set the minY-Level for Lead Ore to generate");
		ConfigValues.oreGenLeadMaxY = cfg.getInt("Lead Ore Maximum Y", categoryOreGen, ConfigValues.oreGenLeadMaxY, 1, 256, "Set the maxY-Level for Lead Ore to generate");
		
		ConfigValues.flatBedrockGen = cfg.getBoolean("Generation flat bedrock", categoryOreGen, ConfigValues.flatBedrockGen, "Enable or Disable flat bedrock");
		
		if(cfg.hasChanged()){
			cfg.save();
		}
		
	}
		
}
