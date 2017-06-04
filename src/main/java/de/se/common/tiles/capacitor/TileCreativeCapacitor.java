package de.se.common.tiles.capacitor;

import javax.annotation.Nonnull;

import de.se.api.energy.starflux.StarFluxStorage;
import de.se.common.tiles.TileSEBase;
import de.se.common.utils.helper.EnergyHelper;
import de.se.common.utils.helper.EnergyHelper.ISEInternalEnergyHandler;
import de.se.common.utils.helper.EnergyHelper.SEForgeEnergyWrapper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileCreativeCapacitor extends TileSmallCapacitor{
	
	@Override
	public int receiveEnergy(EnumFacing from, int energy, boolean simulate) {

		if(world.isRemote){
			return 0;
		}
		
		return energy;
	}
	
	@Override
	public int extractEnergy(EnumFacing from, int energy, boolean simulate) {
		
		if(world.isRemote){
			return 0;
		}
		
		return energy;
	}
	
	@Override
	public int getEnergyStored(EnumFacing from) {
		return Integer.MAX_VALUE;
	}
	
	@Override
	public int getMaxEnergyStored(EnumFacing from) {
		return Integer.MAX_VALUE;
	}
	
	@Override
	protected void transferEnergy(int side) {

		EnumFacing to = EnumFacing.getFront(side);
		if (world.isBlockLoaded(pos.offset(to)));
		{
			TileEntity te = world.getTileEntity(pos.offset(to));
			EnergyHelper.insertEnergy(te, to.getOpposite(), Integer.MAX_VALUE, false);
		}
		
	}
	
}