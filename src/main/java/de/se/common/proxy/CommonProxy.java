package de.se.common.proxy;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.SERecipes;
import de.se.StarExpansion;
import de.se.common.compat.SECompatHandler;
import de.se.common.config.ConfigValues;
import de.se.common.tiles.atreactor.TileATReactorController;
import de.se.common.tiles.atreactor.TileATReactorPowerConnector;
import de.se.common.tiles.capacitor.TileCreativeCapacitor;
import de.se.common.tiles.capacitor.TileLargeCapacitor;
import de.se.common.tiles.capacitor.TileMediumCapacitor;
import de.se.common.tiles.capacitor.TileSmallCapacitor;
import de.se.common.utils.helper.OreDictHelper;
import de.se.common.utils.helper.SupportHelper;
import de.se.common.world.worldgen.SEFlatBedrock;
import de.se.common.world.worldgen.SEWorldGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e){
		SEBlocks.init();
		SEItems.init();
		OreDictHelper.init();
		
		MinecraftForge.EVENT_BUS.register(new SupportHelper());
		GameRegistry.registerTileEntity(TileATReactorPowerConnector.class, "tileATReactorPowerConnector");
		GameRegistry.registerTileEntity(TileATReactorController.class, "tileATReactorController");
		GameRegistry.registerTileEntity(TileSmallCapacitor.class, "tileSmallCapacitor");
		GameRegistry.registerTileEntity(TileMediumCapacitor.class, "tileMediumCapacitor");
		GameRegistry.registerTileEntity(TileLargeCapacitor.class, "tileLargeCapacitor");
		GameRegistry.registerTileEntity(TileCreativeCapacitor.class, "tileCreativeCapacitor");
		SECompatHandler.registerCompat();
	}
	
	public void init(FMLInitializationEvent e){
		
		NetworkRegistry.INSTANCE.registerGuiHandler(StarExpansion.INSTANCE, new GuiProxy());
		
		registerWorldGen(new SEWorldGenerator(), 0);
		
		if(ConfigValues.flatBedrockGen){
			
		registerWorldGen(new SEFlatBedrock(), 1);
		
		}
		
	}

	public void postInit(FMLPostInitializationEvent e){
	
		SERecipes.init();
		
	}

	private void registerWorldGen(IWorldGenerator gen, int weight){
		GameRegistry.registerWorldGenerator(gen, weight);
	}

	public boolean isDedicatedServer() {
        return true;
    }

    public MinecraftServer getMCServer() {
        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

    public World getClientWorld() {
        return null;
    }

    public boolean isOp(String paramString) {
        MinecraftServer localMinecraftServer = FMLCommonHandler.instance().getMinecraftServerInstance();
        paramString = paramString.trim();
        for (String str : localMinecraftServer.getPlayerList().getOppedPlayerNames()) {
            if (paramString.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isJumpKeyDown() {
        return false;
    }

    public boolean isSprintKeyDown() {
        return false;
    }

    public boolean isSneakKeyDown() {
        return false;
    }

    public EntityPlayer getClientPlayer() {
        return null;
    }

    public void setChatAtIndex(ITextComponent chat, int index) {

    }
	
}
