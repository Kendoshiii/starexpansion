package de.se.common.compat;

import de.se.common.compat.top.CompatHelperTOP;
import net.minecraftforge.fml.common.Loader;

public class SECompatHandler {

	public static void registerCompat(){
		
		if(Loader.isModLoaded("theoneprobe")) CompatHelperTOP.register();
		
	}
	
}
