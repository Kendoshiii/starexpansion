package de.se.common.tiles.capacitor;

import javax.annotation.Nonnull;

import de.se.api.energy.starflux.StarFluxStorage;
import de.se.common.config.ConfigValues;
import de.se.common.tiles.TileSEBase;
import de.se.common.utils.helper.EnergyHelper;
import de.se.common.utils.helper.EnergyHelper.ISEInternalEnergyHandler;
import de.se.common.utils.helper.EnergyHelper.SEForgeEnergyWrapper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileLargeCapacitor extends TileMediumCapacitor {

	@Override
	public int getMaxStorage() {
		return ConfigValues.largeSFCapacitorCapacity;
	}

	@Override
	public int getMaxExtract() {
		return ConfigValues.largeSFCapacitorIn;
	}

	@Override
	public int getMaxReceive() {
		return ConfigValues.largeSFCapacitorOut;
	}

}
