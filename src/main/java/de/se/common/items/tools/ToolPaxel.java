package de.se.common.items.tools;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import de.se.SEBlocks;
import de.se.StarExpansion;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToolPaxel extends ItemPickaxe {

	private static HashSet<Block> effectiveAgainst = Sets.newHashSet(new Block[] { Blocks.PLANKS, Blocks.BOOKSHELF,
			Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK,
			Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE,
			Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE,
			Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE,
			Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE,
			Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE,
			Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON,
			Blocks.STONE_PRESSURE_PLATE, Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL,
			Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH,
			SEBlocks.COPPER_ORE, SEBlocks.TIN_ORE, SEBlocks.SILVER_ORE, SEBlocks.LEAD_ORE, SEBlocks.RADIANT_ORE,
			SEBlocks.COPPER_BLOCK, SEBlocks.TIN_BLOCK, SEBlocks.BRONZE_BLOCK,
			SEBlocks.SILVER_BLOCK, SEBlocks.LEAD_BLOCK});

	private String name;
	
	public ToolPaxel(ToolMaterial material, String name) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setMaxStackSize(1);
	}

	@Override
	public String getUnlocalizedName(){
		return "item." + StarExpansion.MODID + ":" + name;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (getHasSubtypes()) {
			return getUnlocalizedName() + "." + stack.getItemDamage();
		}

		return getUnlocalizedName();
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		if(damage == -1 ){
			tooltip.add("Durability: " + "UNBREAKABLE");
		}else{
			tooltip.add("Durability: " + damage);
		}
		super.addInformation(stack, player, tooltip, advanced);
	}
		
	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "spade", "axe");
	}

	@Override
	public boolean canHarvestBlock(IBlockState blockIn) {
		return effectiveAgainst.contains(blockIn) ? true : super.canHarvestBlock(blockIn);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		if ((state.getMaterial() == Material.WOOD) || (state.getMaterial() == Material.VINE)
				|| (state.getMaterial() == Material.PLANTS) || (state.getMaterial() == Material.GROUND)
				|| (state.getMaterial() == Material.GRASS) || (state.getMaterial() == Material.SAND)) {
			return this.efficiencyOnProperMaterial;
		}
		return effectiveAgainst.contains(state) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(stack, state);
	}

}
