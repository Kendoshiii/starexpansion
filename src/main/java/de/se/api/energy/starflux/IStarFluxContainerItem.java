package de.se.api.energy.starflux;

import net.minecraft.item.ItemStack;

public interface IStarFluxContainerItem {

	/**
	 * Inserts energy into the Item. Returns the amount that was accepted.
	 * @param container	The ItemStack of the container item
	 * @param energy	Maximum amount of energy to be inserted.
	 * @param simulate	If TRUE, the process is simulated and will not increase the storage.
	 * @return			Amount of energy that was, or would have been, if simulated, accepted.
	 */
	int receiveEnergy(ItemStack container, int energy, boolean simulate);
	
	/**
	 * Extracts energy from the Item. Returns the amount that was extracted.
	 * @param container	The ItemStack of the container item
	 * @param energy	Maximum amount of energy to be extracted.
	 * @param simulate	If TRUE, the process is simulated and will not decrease the storage.
	 * @return			Amount of energy that was, or would have been, if simulated, extracted.
	 */
	int extractEnergy(ItemStack container, int energy, boolean simulate);

	/**
	 * @param container	The ItemStack of the container item
	 * @return			The amount of energy stored in the Tile.
	 */
	int getEnergyStored(ItemStack container);

	/**
	 * @param container	The ItemStack of the container item
	 * @return			The maximum amount of energy that can be stored in the Tile.
	 */
	int getMaxEnergyStored(ItemStack container);
	
}
