package de.se.common.items.accs;

import java.util.List;
import java.util.Random;

import de.se.common.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWateringCrystal extends ItemBase {

	int accelerated_growth = 200;
	private static BlockPos posBlockWatering = null;
	private static EntityPlayer playerWatering = null;

	public ItemWateringCrystal() {
		super("watering_crystal");
		if (this.accelerated_growth < 10) {
			this.accelerated_growth = 10;
		}
		if (this.accelerated_growth > 200) {
			this.accelerated_growth = 200;
		}
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("se.watering.tooltip1"));
	}
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		doWater(stack, world, player, pos);

		return EnumActionResult.PASS;
	}

	public void doWater(ItemStack stack, World world, EntityPlayer player, BlockPos pos) {
		Random rand = new Random();
		for (int a = -3; a <= 3; a++) {
			for (int b = -3; b <= 3; b++) {
				double d0 = pos.add(a, 0, b).getX() + rand.nextFloat();
				double d1 = pos.add(a, 0, b).getY() + 1.0D;
				double d2 = pos.add(a, 0, b).getZ() + rand.nextFloat();

				IBlockState checkSolidState = world.getBlockState(pos);
				Block checkSolid = world.getBlockState(pos).getBlock();
				if ((checkSolid.isFullCube(checkSolidState)) || ((checkSolid instanceof BlockFarmland))) {
					d1 += 1.0D;
				}
				world.spawnParticle(EnumParticleTypes.WATER_DROP, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[5]);
			}
		}
		if (!world.isRemote) {
			int chance = randInt(1, 200);
			if (chance <= this.accelerated_growth) {
				for (int xAxis = -1; xAxis <= 1; xAxis++) {
					for (int zAxis = -1; zAxis <= 1; zAxis++) {
						for (int yAxis = -1; yAxis <= 1; yAxis++) {
							Block checkBlock = world.getBlockState(pos.add(xAxis, yAxis, zAxis)).getBlock();
							world.scheduleBlockUpdate(pos.add(xAxis, yAxis, zAxis), checkBlock, 0, 1);
						}
					}
				}
			}
		}
	}

	public int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt(max - min + 1) + min;

		return randomNum;
	}

}
