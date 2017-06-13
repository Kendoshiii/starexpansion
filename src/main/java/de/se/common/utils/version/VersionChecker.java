package de.se.common.utils.version;

import de.se.common.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

/*
 * 
 * Handles any updates required using a custom JSON file hosted on a webserver
 * @author and written by Vazkii
 * 
 */

public final class VersionChecker {

	private VersionChecker() {}
	
	private static int demandMessages = 2;
	
	public static boolean doneChecking = false;
	public static String onlineVersion = "";
	private static boolean triedToWarnPlayer = false;

	public static void init(){
		
		new ThreadVersionChecker();
		MinecraftForge.EVENT_BUS.register(VersionChecker.class);
		
	}
	
	@SubscribeEvent
	public static void onTick(ClientTickEvent e){
		
		if(doneChecking && e.phase == Phase.END && Minecraft.getMinecraft().player != null && !triedToWarnPlayer) {
			if(!onlineVersion.isEmpty()) {
				EntityPlayer player = Minecraft.getMinecraft().player;
				int onlineBuild = Integer.parseInt(onlineVersion.split("-")[1]);
				int clientBuild = Reference.BUILD.contains("BUILD") ? Integer.MAX_VALUE : Integer.parseInt(Reference.BUILD);
				if(onlineBuild > clientBuild){
					player.sendMessage(new TextComponentTranslation("se.version.demand." + player.world.rand.nextInt(demandMessages)).setStyle(new Style().setColor(TextFormatting.RED)));
					player.sendMessage(new TextComponentTranslation("se.version.outdated", clientBuild, onlineBuild));
					
					ITextComponent component = ITextComponent.Serializer.fromJsonLenient(I18n.translateToLocal("se.version.updateMessage").replaceAll("%version%", onlineVersion));
					player.sendMessage(component);
				}
			}
			triedToWarnPlayer = true;
		}
		
	}
	
}
