package de.se.common.tiles;

import javax.annotation.Nullable;

import de.se.common.utils.helper.EnergyHelper.ISEInternalEnergyConnector;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

public abstract class TileSEBase extends TileEntity{

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.readCustomNBT(nbt, false);
	}
	public abstract void readCustomNBT(NBTTagCompound nbt, boolean descPacket);
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		this.writeCustomNBT(nbt, false);
		return nbt;
	}
	public abstract void writeCustomNBT(NBTTagCompound nbt, boolean descPacket);

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		this.writeCustomNBT(nbttagcompound, true);
		return new SPacketUpdateTileEntity(this.pos, 3, nbttagcompound);
	}
	@Override
	public NBTTagCompound getUpdateTag()
	{
		NBTTagCompound nbt = super.writeToNBT(new NBTTagCompound());
		writeCustomNBT(nbt, true);
		return nbt;
	}
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		this.readCustomNBT(pkt.getNbtCompound(), true);
	}

	public void receiveMessageFromClient(NBTTagCompound message)
	{
	}
	public void receiveMessageFromServer(NBTTagCompound message)
	{
	}

	public void onEntityCollision(World world, Entity entity)
	{
	}

	public void markContainingBlockForUpdate(IBlockState newState)
	{
		markBlockForUpdate(getPos(), newState);
	}
	public void markBlockForUpdate(BlockPos pos, IBlockState newState)
	{
		IBlockState state = world.getBlockState(getPos());
		if(newState==null)
			newState = state;
		world.notifyBlockUpdate(pos,state,newState,3);
		world.notifyNeighborsOfStateChange(pos, newState.getBlock(), false);
	}


	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
	{
		if(capability==CapabilityEnergy.ENERGY && this instanceof ISEInternalEnergyConnector)
			return ((ISEInternalEnergyConnector)this).getCapabilityWrapper(facing)!=null;
		return super.hasCapability(capability, facing);
	}
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
	{
		if(capability==CapabilityEnergy.ENERGY && this instanceof ISEInternalEnergyConnector)
			return (T)((ISEInternalEnergyConnector)this).getCapabilityWrapper(facing);
		return super.getCapability(capability, facing);
	}
	
}
