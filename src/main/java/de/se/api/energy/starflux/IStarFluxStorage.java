package de.se.api.energy.starflux;

public interface IStarFluxStorage {

	/**
	 * Inserts energy into the storage. Returns the amount that was accepted.
	 * @param energy	Maximum amount of energy to be inserted.
	 * @param simulate	If TRUE, the process is simulated and will not increase the storage.
	 * @return			Amount of energy that was, or would have been, if simulated, accepted.
	 */
	int receiveEnergy(int energy, boolean simulate);

	/**
	 * Extracts energy from the storage. Returns the amount that was extracted.
	 * @param energy	Maximum amount of energy to be extracted.
	 * @param simulate	If TRUE, the process is simulated and will not decrease the storage.
	 * @return			Amount of energy that was, or would have been, if simulated, extracted.
	 */
	int extractEnergy(int energy, boolean simulate);

	/**
	 * @return			The amount of energy stored.
	 */
	int getEnergyStored();

	/**
	 * @return			The maximum amount of energy that can be stored.
	 */
	int getMaxEnergyStored();
	
}
