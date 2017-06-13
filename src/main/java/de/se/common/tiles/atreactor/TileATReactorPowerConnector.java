package de.se.common.tiles.atreactor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import de.se.SEBlocks;
import de.se.common.config.ConfigValues;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.IEnergyStorage;

public class TileATReactorPowerConnector extends TileEntity implements ITickable, IEnergyStorage
{
	public int energy = 0;
	public int capacity = 1000000;
    public int maxReceive = 0;
    public int maxExtract = 1000;
    public int generation = 0;
	    
    private TileATReactorController controller;
    
	public TileATReactorPowerConnector()
	{
		;
	}
	
	protected void setController(TileATReactorController c)
	{
		this.controller = c;
	}
	
	@Override
	public void update()
	{
		
		if(!world.isRemote){
			
			
		}
		
		if(controller != null && controller.getIsReactor()){
		
			if(controller.getGeneratorBlocks().contains(SEBlocks.RADIANT_BLOCK)){
				generation = controller.getGeneratorBlockCount() * ConfigValues.reactorGeneration;
			} else{
				generation = 0;
			}
			
		}
				
		int reactorYield = generation;
		
		if (this.energy < this.capacity)
			this.energy += reactorYield;
		
		if (controller != null && controller.getPos() != null)
		{
			if (this.world.getBlockState(controller.getPos()).getBlock() != SEBlocks.ATREACTOR_CONTROLLER)
			{
				this.energy = 0;
			}
		}
		
		for (EnumFacing facing : EnumFacing.VALUES)
		{
			TileEntity te = this.world.getTileEntity(this.getPos().offset(facing));
			if (te != null && !(te instanceof TileATReactorController))
			{
				try {
					Method m = te.getClass().getMethod("receiveEnergy", new Class[] {EnumFacing.class, int.class, boolean.class});
					
					if (m != null)
					{
						try {
							Object o = m.invoke(te, facing.getOpposite(), this.extractEnergy(reactorYield, false), false);
							if (o instanceof Integer)
							{
								reactorYield -= (int)o;
								this.energy += reactorYield;
							}
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, net.minecraft.util.EnumFacing facing)
	{
		if (capability != null && capability.getName() == "net.minecraftforge.energy.IEnergyStorage")
		{
			return true;
		}
		
		return super.hasCapability(capability, facing);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing)
	{
		if (capability != null && capability.getName() == "net.minecraftforge.energy.IEnergyStorage")
		{
			return (T) this;
		}
		
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		if (compound.hasKey("SE_EnergyStored"))
			this.energy = compound.getInteger("SE_EnergyStored");
		
		super.readFromNBT(compound);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		NBTTagCompound tag = super.writeToNBT(compound);
		
		tag.setInteger("SE_EnergyStored", this.energy);
		
		return tag;
	}
	
	@Override
	public int extractEnergy(int extract, boolean simulate)
	{
		int amount = (extract <= this.energy)?  extract : this.energy;
		
		this.energy -= amount;
		
		if (this.energy < 0)
			this.energy = 0;
		
		return amount;
	}
	
	@Override
	public int getEnergyStored()
	{
		return this.energy;
	}
	
	@Override
	public int getMaxEnergyStored()
	{
		return this.capacity;
	}
	
	@Override
	public int receiveEnergy(int receive, boolean sumulate)
	{
		return 0;
	}

	@Override
	public boolean canExtract() {
		return true;
	}

	@Override
	public boolean canReceive() {
		return false;
	}

}
