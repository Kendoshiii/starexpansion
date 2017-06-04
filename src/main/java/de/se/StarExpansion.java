package de.se;

import java.io.File;

import codechicken.lib.CodeChickenLib;
import de.se.common.config.Config;
import de.se.common.items.material.ItemIngot;
import de.se.common.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = StarExpansion.MODID, name = StarExpansion.Name, version = StarExpansion.VersionFull, acceptedMinecraftVersions = "[1,11,2]", dependencies = StarExpansion.Dependencies)
public class StarExpansion {

	public static final String MODID = "se";
	public static final String Version = "0.0.2";
	public static final String Name = "StarExpansion";
	public static final String MIN_FORGE_VER = "12.18.1.2079";
	public static final String SnapshotVersion = "snapshot_1a";
	public static final String VersionFull = Version + "_alpha_" + SnapshotVersion;
	public static final String MCVersion = "1.10.2";
	public static final String Dependencies = "after:CodeChickenLib@[" + CodeChickenLib.MOD_VERSION + ",);";

	public static SimpleNetworkWrapper channel;

	
	@SidedProxy(clientSide = "de.se.common.proxy.ClientProxy", serverSide = "de.se.common.proxy.ServerProxy")
	public static CommonProxy PROXY;
	
	@Mod.Instance(MODID)
	public static StarExpansion INSTANCE;

	public final CreativeTabs tab = new CreativeTabs(MODID) {

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

		Config.init(e.getSuggestedConfigurationFile());
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
	
}
