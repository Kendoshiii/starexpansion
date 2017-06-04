package de.se.api.energy.starflux;

import javax.annotation.Nullable;

import net.minecraft.util.EnumFacing;

public interface IStarFluxConnection {

	/**
	 * @param from		The direction the check is performed from, null for unknown.
	 * @return			If the TileEntity can connect.
	 */
	boolean canConnectEnergy(@Nullable EnumFacing from);

}
