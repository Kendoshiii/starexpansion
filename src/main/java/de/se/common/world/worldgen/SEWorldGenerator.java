package de.se.common.world.worldgen;

import java.util.Random;

import de.se.SEBlocks;
import de.se.common.config.Config;
import de.se.common.config.ConfigValues;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class SEWorldGenerator implements IWorldGenerator{

	public SEWorldGenerator() {}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch (world.provider.getDimension()) {
		case 0:
			
			addOreSpawn(SEBlocks.COPPER_ORE.getDefaultState(), Blocks.STONE.getDefaultState(), world, random, chunkX * 16 , chunkZ * 16, 2, 5, 20, 2, 160);
			addOreSpawn(SEBlocks.TIN_ORE.getDefaultState(), Blocks.STONE.getDefaultState(), world, random, chunkX * 16 , chunkZ * 16, 2, 5, 20, 2, 160);	
			addOreSpawn(SEBlocks.SILVER_ORE.getDefaultState(), Blocks.STONE.getDefaultState(), world, random, chunkX * 16 , chunkZ * 16, 2, 4, 20, 2, 44);
			addOreSpawn(SEBlocks.LEAD_ORE.getDefaultState(), Blocks.STONE.getDefaultState(), world, random, chunkX * 16 , chunkZ * 16, 2, 4, 20, 2, 44);

			int actualX = chunkX * 16;
			int actualZ = chunkZ * 16;
			int x1 = actualX + random.nextInt(8);
			int y = 20 + random.nextInt(20);
			int z1 = actualZ + random.nextInt(8);
			if (Math.sqrt(actualX*actualX + actualZ*actualZ) > 30 && random.nextInt(Math.max(1, 500)) == 0){ 
				new SEMeteoriteGen().generate(world, random, new BlockPos(x1, y , z1));
			}
			
		break;
		
		case 1:
			//
		break;
		
		case -1:
			//
		break;
		}		
	}

	public void addOreSpawn(IBlockState block, IBlockState baseBlock, World world, Random random, int chunkXPos, int chunkZPos, int minVainSize, int maxVainSize, int chancesToSpawn, int minY, int maxY) {
		for (int i = 0; i < chancesToSpawn; i++) {
			int posX = chunkXPos + random.nextInt(16);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = chunkZPos + random.nextInt(16);

			new WorldGenMinable(block, (minVainSize + random.nextInt(maxVainSize - minVainSize)), BlockMatcher.forBlock(baseBlock.getBlock())).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	
}