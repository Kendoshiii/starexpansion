package de.se.common.crafting;

import de.se.SEBlocks;
import de.se.SEItems;
import de.se.common.items.material.ItemDust;
import de.se.common.items.material.ItemIngot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SESmelting {

	public static void init(){
		
		GameRegistry.addSmelting(SEBlocks.COPPER_ORE, new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 0.1F);
		GameRegistry.addSmelting(SEBlocks.TIN_ORE, new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), 0.1F);
		GameRegistry.addSmelting(SEBlocks.SILVER_ORE, new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), 0.1F);
		GameRegistry.addSmelting(SEBlocks.LEAD_ORE, new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), 0.1F);
		GameRegistry.addSmelting(SEBlocks.RADIANT_ORE, new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_RADIANT_STAR), 0.4F);
		
		GameRegistry.addSmelting(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_COPPER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_COPPER), 0.1F);
		GameRegistry.addSmelting(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_TIN), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_TIN), 0.1F);
		GameRegistry.addSmelting(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_BRONZE), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_BRONZE), 0.1F);
		GameRegistry.addSmelting(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_LEAD), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_LEAD), 0.1F);
		GameRegistry.addSmelting(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_SILVER), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_SILVER), 0.1F);
		GameRegistry.addSmelting(new ItemStack(SEItems.DUST, 1, ItemDust.DUST_STEEL), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), 0.1F);
		GameRegistry.addSmelting(new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_CARBON_IRON), new ItemStack(SEItems.INGOT, 1, ItemIngot.INGOT_STEEL), 0.1F);
		
	}
	
}
