package de.se.common.config;

import java.util.Set;

import net.minecraftforge.common.config.Property;

public class ConfigValues {

	public static int smallSFCapacitorCapacity = 1000000;	
	public static int smallSFCapacitorIn = 1000;	
	public static int smallSFCapacitorOut = 1000;			
	public static int mediumSFCapacitorCapacity = 2500000;	
	public static int mediumSFCapacitorIn = 2500;	
	public static int mediumSFCapacitorOut = 2500;	
	public static int largeSFCapacitorCapacity = 4000000;	
	public static int largeSFCapacitorIn = 4000;	
	public static int largeSFCapacitorOut = 4000;	
	public static boolean enableCreativeSFCapacitor = true;	
	public static int reactorGeneration = 480;
	public static int repairerEnergyPerPoint = 1000;
	public static boolean restrictRepairs;
	public static Set<String> repairerBlacklist;
	public static Property blProperty;
	public static boolean oreGenCopper = true;
	public static boolean oreGenTin = true;	
	public static boolean oreGenSilver = true;
	public static boolean oreGenLead = true;
	public static boolean oreGenRadiant = true;
	public static boolean genMeteorites = true;
	public static boolean flatBedrockGen = true;
	public static int oreGenCopperMinVeinSize = 2;
	public static int oreGenTinMinVeinSize = 2;
	public static int oreGenSilverMinVeinSize = 2;
	public static int oreGenLeadMinVeinSize = 2;
	public static int oreGenCopperMaxVeinSize = 5;
	public static int oreGenTinMaxVeinSize = 5;
	public static int oreGenSilverMaxVeinSize = 5;
	public static int oreGenLeadMaxVeinSize = 5;
	public static int oreGenCopperMinY = 2;
	public static int oreGenTinMinY = 2;
	public static int oreGenSilverMinY = 2;
	public static int oreGenLeadMinY = 2;
	public static int oreGenCopperMaxY = 80;
	public static int oreGenTinMaxY = 80;
	public static int oreGenSilverMaxY = 44;
	public static int oreGenLeadMaxY = 44;
	public static boolean copperTools = true;
	public static boolean bronzeTools = true;
	public static boolean emeraldTools = true;
	public static int copperToolsDurability = 128;
	public static int bronzeToolsDurability = 324;
	public static int emeraldToolsDurability = 1863;
	public static int forgeHammerDurability = 150;	
	public static int emeraldArmorDurability = 25;
	public static int modGuiIndex = 0;
	public static int repairerGUI = modGuiIndex++;
	public static boolean compatTOP = true;

	public static boolean allowFlight = true;
		
}
