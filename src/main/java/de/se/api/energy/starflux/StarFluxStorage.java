package de.se.api.energy.starflux;

import net.minecraft.nbt.NBTTagCompound;

public class StarFluxStorage implements IStarFluxStorage{

	protected int capacity;
	protected int energy;
	protected int maxReceive;
	protected int maxExtract;
		
	public StarFluxStorage(int capacity) {
		this(capacity, capacity, capacity);
	}

	public StarFluxStorage(int capacity, int maxReceive) {
		this(capacity, maxReceive, maxReceive);
	}

	public StarFluxStorage(int capacity, int maxReceive, int maxExtract) {
		this.capacity = capacity;
		this.maxReceive = maxReceive;
		this.maxExtract = maxExtract;
	}

	public StarFluxStorage readFromNBT(NBTTagCompound tag){
		
		this.energy = tag.getInteger("star-flux");
		if(energy > capacity){
			energy = capacity;
		}
		
		return this;
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound tag){
		if(energy < 0){
			energy = 0;
		}
		tag.setInteger("star-flux", energy);
		return tag;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
		if(energy > capacity){
			energy = capacity;
		}
	}
	
	public void setMaxTransfer(int maxTransfer){
		setMaxReceive(maxTransfer);
		setMaxExtract(maxTransfer);
	}
	
	
	public void setMaxExtract(int maxReceive) {

		this.maxReceive = maxReceive;
		
	}

	public void setMaxReceive(int maxExtract) {

		this.maxExtract = maxExtract;
		
	}

	public int getMaxReceive(){
		
		return maxReceive;
		
	}
	
	public int getMaxExtract(){
		
		return maxExtract;
		
	}
	
	public void setEnergy(int energy){
		
		this.energy = energy;
		
		if(this.energy > capacity){
			
			this.energy = capacity;
			
		}else if(this.energy < 0){
			
			this.energy = 0;
			
		}
		
	}
	
	public void changeStoredEnergy(int energy){
		
		this.energy += energy;
		
		if(this.energy > capacity){
			
			this.energy = capacity;
			
		}else if(this.energy < 0){
			
			this.energy = 0;
			
		}
		
	}
	
	@Override
	public int receiveEnergy(int energy, boolean simulate) {

		int received = Math.min(capacity - this.energy, Math.min(this.maxReceive, energy));
		if(!simulate){
			this.energy += received;
		}
		return received;
	}

	@Override
	public int extractEnergy(int energy, boolean simulate) {
		
		int extracted = Math.min(this.energy, Math.min(this.maxExtract, energy));
		if(!simulate){
			this.energy += extracted;
		}
		return extracted;
		
	}

	@Override
	public int getEnergyStored() {

		return energy;
		
	}

	@Override
	public int getMaxEnergyStored() {
		
		return capacity;
		
	}

}
