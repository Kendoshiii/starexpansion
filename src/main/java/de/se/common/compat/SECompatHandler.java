package de.se.common.compat;

import de.se.common.compat.top.TOPCompatibility;
import net.minecraftforge.fml.common.Loader;

public class SECompatHandler {

	public static void registerCompat(){
		
		if(Loader.isModLoaded("theoneprobe")) TOPCompatibility.register();
		
	}
	
}
