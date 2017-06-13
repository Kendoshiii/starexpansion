package de.se.common.proxy;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.SERecipes;
import de.se.StarExpansion;
import de.se.common.compat.SECompatHandler;
import de.se.common.config.Config;
import de.se.common.handler.ClientEventHandler;
import de.se.common.tiles.atreactor.TileATReactorController;
import de.se.common.tiles.atreactor.TileATReactorPowerConnector;
import de.se.common.tiles.repairer.TileRepairer;
import de.se.common.utils.helper.OreDictHelper;
import de.se.common.utils.helper.SupportHelper;
import de.se.common.utils.version.VersionChecker;
import de.se.common.world.worldgen.SEWorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e){
		Config.init(e.getSuggestedConfigurationFile());
		SEBlocks.init();
		SEItems.init();
		OreDictHelper.init();
		
		MinecraftForge.EVENT_BUS.register(new SupportHelper());
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
		GameRegistry.registerTileEntity(TileATReactorPowerConnector.class, "tileATReactorPowerConnector");
		GameRegistry.registerTileEntity(TileATReactorController.class, "tileATReactorController");
		GameRegistry.registerTileEntity(TileRepairer.class, "tileRepairer");
		SECompatHandler.registerCompat();
	}
	
	public void init(FMLInitializationEvent e){
		
		NetworkRegistry.INSTANCE.registerGuiHandler(StarExpansion.INSTANCE, new GuiProxy());
		
		registerWorldGen(new SEWorldGenerator(), 0);
		
		/*if(ConfigValues.flatBedrockGen){
			
		registerWorldGen(new SEFlatBedrock(), 1);
		
		}*/
		
		VersionChecker.init();
		
	}

	public void postInit(FMLPostInitializationEvent e){
	
		SERecipes.init();
		
	}

	private void registerWorldGen(IWorldGenerator gen, int weight){
		GameRegistry.registerWorldGenerator(gen, weight);
	}

}
