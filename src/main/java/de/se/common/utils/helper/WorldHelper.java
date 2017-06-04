package de.se.common.utils.helper;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;

public class WorldHelper {

	public static void growNearbyRandomly(boolean harvest, World world, BlockPos pos, EntityPlayer player)
	{
		int chance = harvest ? 16 : 32;

		for (BlockPos currentPos : BlockPos.getAllInBox(pos.add(-5, -3, -5), pos.add(5, 3, 5)))
		{
			IBlockState state = world.getBlockState(currentPos);
			Block crop = state.getBlock();

			// Vines, leaves, tallgrass, deadbush, doubleplants
			if (crop instanceof IShearable)
			{
				if (harvest)
				{
					world.destroyBlock(currentPos, true);
				}
			}
			// Carrot, cocoa, wheat, grass (creates flowers and tall grass in vicinity),
			// Mushroom, potato, sapling, stems, tallgrass
			else if (crop instanceof IGrowable)
			{
				IGrowable growable = ((IGrowable) crop);
				if (!growable.canGrow(world, currentPos, state, false))
				{
					if (harvest
							&& crop != Blocks.MELON_STEM && crop != Blocks.PUMPKIN_STEM
							&& (player == null || PlayerHelper.hasBreakPermission(((EntityPlayerMP) player), currentPos)))
					{
						world.destroyBlock(currentPos, true);
					}
				}
				else if (world.rand.nextInt(chance) == 0)
				{
					if (!crop.getUnlocalizedName().toLowerCase(Locale.ROOT).contains("grass"))
					{
						growable.grow(world, world.rand, currentPos, state);
					}
				}
			}
			// All modded
			// Cactus, Reeds, Netherwart, Flower
			else if (crop instanceof IPlantable)
			{
				if (world.rand.nextInt(chance / 4) == 0)
				{
					for (int i = 0; i < (harvest ? 8 : 4); i++)
					{
						crop.updateTick(world, currentPos, state, world.rand);
					}
				}

				if (harvest)
				{
					if (crop instanceof BlockFlower)
					{
						if (player == null || PlayerHelper.hasBreakPermission(((EntityPlayerMP) player), pos))
						{
							world.destroyBlock(currentPos, true);
						}
					}
					if (crop == Blocks.REEDS || crop == Blocks.CACTUS)
					{
						boolean shouldHarvest = true;

						for (int i = 1; i < 3; i++)
						{
							if (world.getBlockState(currentPos.up(i)).getBlock() != crop)
							{
								shouldHarvest = false;
								break;
							}
						}

						if (shouldHarvest)
						{
							for (int i = crop == Blocks.REEDS ? 1 : 0; i < 3; i++)
							{
								if (player != null && PlayerHelper.hasBreakPermission(((EntityPlayerMP) player), currentPos.up(i)))
								{
									world.destroyBlock(currentPos.up(i), true);
								} else if (player == null)
								{
									world.destroyBlock(currentPos.up(i), true);
								}
							}
						}
					}
					if (crop == Blocks.NETHER_WART)
					{
						int age = state.getValue(BlockNetherWart.AGE);
						if (age == 3)
						{
							if (player == null || player != null && PlayerHelper.hasBreakPermission(((EntityPlayerMP) player), currentPos))
							{
								world.destroyBlock(currentPos, true);
							}
						}
					}
				}

			}
		}
	}
	
}
