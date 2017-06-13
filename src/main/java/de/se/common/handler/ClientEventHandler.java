package de.se.common.handler;

import de.se.common.lib.Reference;
import gigaherz.guidebook.client.BookRegistryEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {
	
	@Mod.EventBusSubscriber
	public static class registerBook{
		
		@Optional.Method(modid="gbook")
		@SubscribeEvent
		public static void getBook(BookRegistryEvent event) {
		    event.register(new ResourceLocation(Reference.MODID + ":xml/book.xml"));
		}
		
	}
	
}
