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

public class TileSmallCapacitor extends TileSEBase implements ITickable, ISEInternalEnergyHandler{

	StarFluxStorage storage = new StarFluxStorage(getMaxStorage(), getMaxReceive(), getMaxExtract());
	public int comparatorOutput = 0;
	
	@Override
	public void update() {

		if(!world.isRemote){
			
			for(int i = 0; i < 6; i++){
				this.transferEnergy(i);
			}
			if(world.getTotalWorldTime()%32 == ((getPos().getX()^getPos().getZ())&31))
			{
				
				int i = scaleStoredEnergyTo(15);
				if(i != this.comparatorOutput){
					
					this.comparatorOutput = i;
					world.updateComparatorOutputLevel(getPos(), getBlockType());
					
				}
				
			}
			
		}
		
	}

	public int scaleStoredEnergyTo(int i) {
		return (int)(i*(storage.getEnergyStored()/(float)storage.getMaxEnergyStored()));
	}
	
	protected void transferEnergy(int i){
		
		EnumFacing fd = EnumFacing.getFront(i);
		TileEntity tile = world.getTileEntity(getPos().offset(fd));
		int out = Math.min(getMaxExtract(), this.storage.getEnergyStored());
		this.storage.changeStoredEnergy(-EnergyHelper.insertEnergy(tile, fd.getOpposite(), out, false));
		
	}
	
	public int getMaxStorage(){
		return ConfigValues.smallSFCapacitorCapacity;
		
	}
	
	public int getMaxExtract(){
		return ConfigValues.smallSFCapacitorIn;
		
	}
	
	public int getMaxReceive(){
		return ConfigValues.smallSFCapacitorOut;
		
	}

	SEForgeEnergyWrapper[] wrapper = SEForgeEnergyWrapper.getDefaultWrapperArray(this);
	
	@Nonnull
	@Override
	public StarFluxStorage getEnergyStorage(){
		
		return this.storage;
		
	}
	
	@Override
	public SEForgeEnergyWrapper getCapabilityWrapper(EnumFacing facing) {

		if(facing == null){
			return null;
		}
		
		return wrapper[facing.ordinal()];
		
	}

	@Override
	public boolean canConnectEnergy(EnumFacing from) {
		return false;
	}

	@Override
	public void readCustomNBT(NBTTagCompound nbt, boolean descPacket) {
		
		storage.writeToNBT(nbt);
		
	}

	@Override
	public void writeCustomNBT(NBTTagCompound nbt, boolean descPacket) {
		
		storage.readFromNBT(nbt);
		
	}

}
