package de.se.common.world.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class SEFlatBedrock implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		for (int blockX = 0; blockX < 16; blockX++) {
			for (int blockZ = 0; blockZ < 16; blockZ++) {
				if (world.provider.getDimension() == -1) {
					for (int blockY = 126; blockY > 121; blockY--) {
						if (world.getBlockState(
								new BlockPos(chunkX * 16 + blockX, blockY, chunkZ * 16 + blockZ)) == Blocks.BEDROCK
										.getDefaultState()) {
							world.setBlockState(new BlockPos(chunkX * 16 + blockX, blockY, chunkZ * 16 + blockZ),
									Blocks.NETHERRACK.getDefaultState(), 0);
						}
					}
				}
				for (int blockY = 5; blockY > 0; blockY--) {
					if (world.getBlockState(
							new BlockPos(chunkX * 16 + blockX, blockY, chunkZ * 16 + blockZ)) == Blocks.BEDROCK
									.getDefaultState()) {
						if (world.provider.getDimension() == -1) {
							world.setBlockState(new BlockPos(chunkX * 16 + blockX, blockY, chunkZ * 16 + blockZ),
									Blocks.NETHERRACK.getDefaultState(), 0);
						} else {
							world.setBlockState(new BlockPos(chunkX * 16 + blockX, blockY, chunkZ * 16 + blockZ),
									Blocks.STONE.getDefaultState(), 0);
						}
					}
				}
			}
		}
	}
}
