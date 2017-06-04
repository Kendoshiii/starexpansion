package de.se.common.items.accs;

import java.util.List;

import javax.annotation.Nonnull;

import de.se.common.items.ItemBase;
import de.se.common.utils.helper.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGrowthCrystal extends ItemBase{

	public ItemGrowthCrystal() {
		super("growth_crystal");
		this.setNoRepair();
		this.setMaxStackSize(1);	
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("se.grow.tooltip1"));
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) 
	{
		if (world.isRemote || par4 > 8 || !(entity instanceof EntityPlayer)) 
		{
			return;
		}
		
		super.onUpdate(stack, world, entity, par4, par5);
		
		EntityPlayer player = (EntityPlayer) entity;

		WorldHelper.growNearbyRandomly(false, world, new BlockPos(player), player);
		
	}
	
	private boolean useBoneMeal(World world, BlockPos pos)
	{
		boolean result = false;

		for (BlockPos currentPos : BlockPos.getAllInBoxMutable(pos.add(-15, 0, -15), pos.add(15, 0, 15)))
		{
			IBlockState state = world.getBlockState(currentPos);
			Block crop = state.getBlock();

			if (crop instanceof IGrowable)
			{
				IGrowable growable = (IGrowable) crop;

				if (growable.canUseBonemeal(world, world.rand, currentPos, state))
				{
					if (!result)
					{
						result = true;
					}

					growable.grow(world, world.rand, currentPos.toImmutable(), state);
				}
			}
		}
		return result;
	}
		
}
