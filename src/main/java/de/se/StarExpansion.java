package de.se;

import de.se.common.handler.commands.BlackListCommand;
import de.se.common.items.material.ItemIngot;
import de.se.common.lib.Reference;
import de.se.common.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Reference.MODID, name = Reference.Name, version = Reference.VERSION, acceptedMinecraftVersions = "[1.11.2]")
public class StarExpansion {

	public static SimpleNetworkWrapper channel;

	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy PROXY;
	
	@Mod.Instance(Reference.MODID)
	public static StarExpansion INSTANCE;

	public final CreativeTabs tab = new CreativeTabs(Reference.MODID) {

		@Override
		public ItemStack getIconItemStack() {
			return new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR);
		}

		@Override
		public ItemStack getTabIconItem() {
			return null;
		}

	};
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e){

		PROXY.preInit(e);
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e){		
		
		PROXY.init(e);

	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
		PROXY.postInit(e);
		
	}
	
	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent e){
		
		e.registerServerCommand(new BlackListCommand());
		
	}
	
}
