package de.se.common.items.accs;

import java.util.List;

import javax.annotation.Nonnull;

import de.se.common.items.ItemBase;
import de.se.common.utils.helper.FluidHelper;
import de.se.common.utils.helper.PlayerHelper;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class ItemWaterCrystal extends ItemBase{

	public ItemWaterCrystal() {
		super("water_crystal");
		this.setNoRepair();
		this.setMaxStackSize(1);	
		this.setMaxDamage(6);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("se.water.tooltip1"));
		tooltip.add(I18n.format("se.water.tooltip2"));
	}
	
	@Nonnull
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing sideHit, float f1, float f2, float f3)
	{
		ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote && PlayerHelper.hasEditPermission(((EntityPlayerMP) player), pos)) {
			TileEntity tile = world.getTileEntity(pos);

			if (tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, sideHit)) {
				FluidHelper.tryFillTank(tile, FluidRegistry.WATER, sideHit, Fluid.BUCKET_VOLUME);
			} else {
				IBlockState state = world.getBlockState(pos);
				if (state.getBlock() == Blocks.CAULDRON) {
					int waterLevel = state.getValue(BlockCauldron.LEVEL);
					if (waterLevel < 3) {
						((BlockCauldron) state.getBlock()).setWaterLevel(world, pos, state, waterLevel + 1);
						stack.damageItem(1, player);
					}
				} else {
					placeWater(world, player, pos.offset(sideHit));
					stack.damageItem(1, player);
				}
			}
		}

		return EnumActionResult.SUCCESS;
	}

	private void placeWater(World world, EntityPlayer player, BlockPos pos)
	{
		Material material = world.getBlockState(pos).getMaterial();

		if (world.provider.doesWaterVaporize())
		{
			world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

			for (int l = 0; l < 8; ++l)
			{
				world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX() + Math.random(), pos.getY() + Math.random(), pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
			}
		}
		else
		{
			if (!world.isRemote && !material.isSolid() && !material.isLiquid())
			{
				world.destroyBlock(pos, true);
			}
			world.setBlockState(pos, Blocks.FLOWING_WATER.getDefaultState());
			PlayerHelper.checkedPlaceBlock(((EntityPlayerMP) player), pos, Blocks.FLOWING_WATER.getDefaultState());
		}

	}
	
}
