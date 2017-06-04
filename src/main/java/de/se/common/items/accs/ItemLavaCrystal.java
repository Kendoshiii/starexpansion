package de.se.common.items.accs;

import java.util.List;

import javax.annotation.Nonnull;

import de.se.common.items.ItemBase;
import de.se.common.utils.helper.FluidHelper;
import de.se.common.utils.helper.PlayerHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class ItemLavaCrystal extends ItemBase{

	public ItemLavaCrystal() {
		super("lava_crystal");
		this.setNoRepair();
		this.setMaxStackSize(1);
		this.setMaxDamage(6);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.format("se.lava.tooltip1"));
		tooltip.add(I18n.format("se.lava.tooltip2"));
	}
	
	@Nonnull
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing sideHit, float f1, float f2, float f3)
	{
		ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote && PlayerHelper.hasEditPermission(((EntityPlayerMP) player), pos)) {
			TileEntity tile = world.getTileEntity(pos);

			if (tile != null && tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, sideHit)) {
				FluidHelper.tryFillTank(tile, FluidRegistry.LAVA, sideHit, Fluid.BUCKET_VOLUME);
				stack.damageItem(1, player);

			} else {
				placeLava(world, player, pos.offset(sideHit));
				stack.damageItem(1, player);
			}
		}

		return EnumActionResult.SUCCESS;
	}

	private void placeLava(World world, EntityPlayer player, BlockPos pos)
	{
		PlayerHelper.checkedPlaceBlock(((EntityPlayerMP) player), pos, Blocks.FLOWING_LAVA.getDefaultState());
	}
	
}
