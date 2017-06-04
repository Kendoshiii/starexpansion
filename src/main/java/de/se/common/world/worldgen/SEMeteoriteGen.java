package de.se.common.world.worldgen;

import java.util.Random;

import de.se.SEBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SEMeteoriteGen extends WorldGenerator{

	private int spawnX;
	private int spawnY;
	private int spawnZ;
	private int size;

	private void initialize(Random rand, int x, int y, int z) {
		spawnX = x;
		spawnY = y;
		spawnZ = z;
		size = 2 + rand.nextInt(2);
	}
	
	@Override
	public boolean generate(World world, Random random, BlockPos pos) {

		initialize(random, pos.getX(), pos.getY(), pos.getZ());

		generateCore(world, random, size);

		return true;
		
	}

	private void generateCore(World world, Random rand, int r) {
		for( int x = spawnX-r ; x <= spawnX + r; x++){
			for( int z = spawnZ-r ; z <= spawnZ + r; z++) {
				for (int y = spawnY-r; y <= spawnY + r; y++) {
					if ((int) (getDistance(x, y, z, spawnX, spawnY, spawnZ)) <= r) {
						float genP = rand.nextFloat();
						BlockPos pos = new BlockPos(x, y, z);
						if (0.1F > genP){
							world.setBlockState(pos, SEBlocks.RADIANT_ORE.getDefaultState());
						}else if (0.4F > genP){
							world.setBlockState(pos, SEBlocks.METEORIE_BLOCK.getDefaultState());
						}else {
							world.setBlockState(pos, SEBlocks.METEORIE_BLOCK.getDefaultState());
						}
					}
				}
			}
		}
	}

	public static double getDistance(int x1, int y1, int z1, int x2, int y2, int z2){
		int dx = x1-x2;
		int dy = y1-y2;
		int dz = z1-z2;
		return Math.sqrt( (dx*dx + dy*dy + dz*dz ) );
	}
	
}
