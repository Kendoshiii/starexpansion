package de.se.common.utils.helper;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public final class FluidHelper {

	public static void tryFillTank(TileEntity tile, Fluid fluid, EnumFacing side, int quantity)
	{
		if (tile.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side))
		{
			IFluidHandler handler = tile.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, side);
			handler.fill(new FluidStack(fluid, quantity), true);
		}
	}
	
}
