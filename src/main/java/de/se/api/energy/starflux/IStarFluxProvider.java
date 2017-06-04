package de.se.api.energy.starflux;

import javax.annotation.Nullable;

import net.minecraft.util.EnumFacing;

public interface IStarFluxProvider extends IStarFluxConnection{

	/**
	 * Extracts energy from the TileEntity. Returns the amount that was extracted.
	 * @param from		The direction the energy is inserted from, null for unknown. Unknown directions should ALWAYS work.
	 * @param energy	Maximum amount of energy to be extracted.
	 * @param simulate	If TRUE, the process is simulated and will not decrease the storage.
	 * @return			Amount of energy that was, or would have been, if simulated, extracted.
	 */
	int extractEnergy(@Nullable EnumFacing from, int energy, boolean simulate);

	/**
	 * @param from		The direction the check is performed from, null for unknown.
	 * @return			The amount of energy stored in the Tile.
	 */
	int getEnergyStored(@Nullable EnumFacing from);

	/**
	 * @param from		The direction the check is performed from, null for unknown.
	 * @return			The maximum amount of energy that can be stored in the Tile.
	 */
	int getMaxEnergyStored(@Nullable EnumFacing from);
	
}
