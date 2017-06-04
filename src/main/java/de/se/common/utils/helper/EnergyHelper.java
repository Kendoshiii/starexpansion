package de.se.common.utils.helper;

import java.util.HashMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyContainerItem;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import de.se.api.energy.starflux.IStarFluxConnection;
import de.se.api.energy.starflux.IStarFluxContainerItem;
import de.se.api.energy.starflux.IStarFluxProvider;
import de.se.api.energy.starflux.IStarFluxReceiver;
import de.se.api.energy.starflux.StarFluxStorage;
import de.se.common.utils.StackUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class EnergyHelper {

	public static boolean isEnergyItem(ItemStack stack) {

		if (stack == StackUtils.getNull() || stack.getItem() == null) {
			return false;
		}
		if (stack.getItem() instanceof IStarFluxContainerItem) {
			return true;
		}
		if (stack.getItem() instanceof IEnergyContainerItem) {
			return true;
		}

		return stack.hasCapability(CapabilityEnergy.ENERGY, null);

	}

	public static int getEnergyStored(ItemStack stack) {

		if (stack == StackUtils.getNull() || stack.getItem() == null) {
			return 0;
		}
		if (stack.getItem() instanceof IStarFluxContainerItem) {
			return ((IStarFluxContainerItem) stack.getItem()).getEnergyStored(stack);
		}
		if (stack.getItem() instanceof IEnergyContainerItem) {
			return ((IEnergyContainerItem) stack.getItem()).getEnergyStored(stack);
		}
		if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
			return stack.getCapability(CapabilityEnergy.ENERGY, null).getEnergyStored();
		}

		return 0;

	}

	public static int getMaxEnergyStored(ItemStack stack) {

		if (stack == StackUtils.getNull() || stack.getItem() == null) {
			return 0;
		}
		if (stack.getItem() instanceof IStarFluxContainerItem) {
			return ((IStarFluxContainerItem) stack.getItem()).getMaxEnergyStored(stack);
		}
		if (stack.getItem() instanceof IEnergyContainerItem) {
			return ((IEnergyContainerItem) stack.getItem()).getMaxEnergyStored(stack);
		}
		if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
			return stack.getCapability(CapabilityEnergy.ENERGY, null).getMaxEnergyStored();
		}

		return 0;

	}

	public static int insertEnergy(ItemStack stack, int energy, boolean simulate) {

		if (stack == StackUtils.getNull() || stack.getItem() == null) {
			return 0;
		}
		if (stack.getItem() instanceof IStarFluxContainerItem) {
			return ((IStarFluxContainerItem) stack.getItem()).receiveEnergy(stack, energy, simulate);
		}
		if (stack.getItem() instanceof IEnergyContainerItem) {
			return ((IEnergyContainerItem) stack.getItem()).receiveEnergy(stack, energy, simulate);
		}
		if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
			return stack.getCapability(CapabilityEnergy.ENERGY, null).receiveEnergy(energy, simulate);
		}

		return 0;

	}

	public static int extractEnergy(ItemStack stack, int energy, boolean simulate) {

		if (stack == StackUtils.getNull() || stack.getItem() == null) {
			return 0;
		}
		if (stack.getItem() instanceof IStarFluxContainerItem) {
			return ((IStarFluxContainerItem) stack.getItem()).extractEnergy(stack, energy, simulate);
		}
		if (stack.getItem() instanceof IEnergyContainerItem) {
			return ((IEnergyContainerItem) stack.getItem()).extractEnergy(stack, energy, simulate);
		}
		if (stack.hasCapability(CapabilityEnergy.ENERGY, null)) {
			return stack.getCapability(CapabilityEnergy.ENERGY, null).extractEnergy(energy, simulate);
		}

		return 0;

	}

	static HashMap<Item, Boolean> reverseInsertion = new HashMap<Item, Boolean>();

	public static int forceExtractEnergy(ItemStack stack, int energy, boolean simulate) {

		if (stack == StackUtils.getNull() || stack.getItem() == null) {
			return 0;
		}

		Boolean b = reverseInsertion.get(stack.getItem());

		if (b == Boolean.TRUE) {

			int stored = getEnergyStored(stack);
			insertEnergy(stack, -energy, simulate);
			return stored - getEnergyStored(stack);

		} else {
			int extracted = extractEnergy(stack, energy, simulate);
			if (b == null) {
				int stored = getEnergyStored(stack);
				insertEnergy(stack, -energy, simulate);
				extracted = stored - getEnergyStored(stack);
				reverseInsertion.put(stack.getItem(), extracted > 0 ? Boolean.TRUE : Boolean.FALSE);
			}

			return extracted;

		}
	}

	public static boolean isEnergyReceiver(TileEntity tile, EnumFacing face) {
		if (tile == null) {
			return false;
		}
		if (tile instanceof IStarFluxReceiver && ((IStarFluxReceiver) tile).canConnectEnergy(face)) {
			return true;
		}
		if (tile instanceof IEnergyReceiver && ((IEnergyReceiver) tile).canConnectEnergy(face)) {
			return true;
		}
		if (tile.hasCapability(CapabilityEnergy.ENERGY, face)) {
			return tile.getCapability(CapabilityEnergy.ENERGY, face).canReceive();
		}
		return false;
	}

	public static int insertEnergy(TileEntity tile, EnumFacing face, int energy, boolean simulate) {

		if (tile == null) {
			return 0;
		}
		if (tile instanceof IStarFluxReceiver && ((IStarFluxReceiver) tile).canConnectEnergy(face)) {
			return ((IStarFluxReceiver) tile).receiveEnergy(face, energy, simulate);
		}
		if (tile instanceof IEnergyReceiver && ((IEnergyReceiver) tile).canConnectEnergy(face)) {
			return ((IEnergyReceiver) tile).receiveEnergy(face, energy, simulate);
		}
		if (tile.hasCapability(CapabilityEnergy.ENERGY, face)) {
			return tile.getCapability(CapabilityEnergy.ENERGY, face).receiveEnergy(energy, simulate);
		}
		return 0;

	}
	
	public interface ISEInternalEnergyHandler extends ISEInternalEnergyConnector, IStarFluxReceiver, IEnergyReceiver, IStarFluxProvider, IEnergyProvider
	{
		
		@Nonnull StarFluxStorage getEnergyStorage();
		
		default void postEnergyTransferUpdate(int energy, boolean simulate){}
		
		@Override
		default int extractEnergy(EnumFacing from, int energy, boolean simulate) {
			
			if(((TileEntity) this).getWorld().isRemote){
				return 0;
			}
			int r = getEnergyStorage().extractEnergy(energy, simulate);
			postEnergyTransferUpdate(-r, simulate);
			return r;
			
		}
		
		@Override
		default int receiveEnergy(EnumFacing from, int energy, boolean simulate) {
			
			if(((TileEntity) this).getWorld().isRemote){
				return 0;
			}
			int r = getEnergyStorage().extractEnergy(energy, simulate);
			postEnergyTransferUpdate(r, simulate);
			return r;
			
		}
		
		@Override
		default int getEnergyStored(EnumFacing from) {
			
			return getEnergyStorage().getEnergyStored();
			
		}
		
		@Override
		default int getMaxEnergyStored(EnumFacing from) {
			
			return getEnergyStorage().getMaxEnergyStored();
			
		}
		
	}
	
	public interface ISEInternalEnergyConnector{

		SEForgeEnergyWrapper getCapabilityWrapper(EnumFacing facing);
		
	}
	
	public static class SEForgeEnergyWrapper implements IEnergyStorage{
		
		final ISEInternalEnergyConnector energyHandler;
		public final EnumFacing side;
		
		public SEForgeEnergyWrapper(ISEInternalEnergyConnector energyHandler, EnumFacing side) {
			
			this.energyHandler = energyHandler;
			this.side = side;
			
		}

		@Override
		public int receiveEnergy(int maxReceive, boolean simulate) {

			if(energyHandler instanceof ISEInternalEnergyHandler){
				return ((ISEInternalEnergyHandler) energyHandler).receiveEnergy(side, maxReceive, simulate);
			}
			return 0;
			
		}

		@Override
		public int extractEnergy(int maxExtract, boolean simulate) {

			if(energyHandler instanceof ISEInternalEnergyHandler){
				return ((ISEInternalEnergyHandler) energyHandler).extractEnergy(side, maxExtract, simulate);
			}
			return 0;
			
		}

		@Override
		public int getEnergyStored() {

			if(energyHandler instanceof ISEInternalEnergyHandler){
				return ((ISEInternalEnergyHandler) energyHandler).getEnergyStored(side);
			}
			return 0;
			
		}

		@Override
		public int getMaxEnergyStored() {
			
			if(energyHandler instanceof ISEInternalEnergyHandler){
				return ((ISEInternalEnergyHandler) energyHandler).getMaxEnergyStored(side);
			}
			return 0;
			
		}

		@Override
		public boolean canExtract() {

			if(energyHandler instanceof ISEInternalEnergyHandler){
				return ((ISEInternalEnergyHandler) energyHandler).getEnergyStorage().getMaxExtract() > 0;
			}
			return false;
			
		}

		@Override
		public boolean canReceive() {

			if(energyHandler instanceof ISEInternalEnergyHandler){
				return ((ISEInternalEnergyHandler) energyHandler).getEnergyStorage().getMaxReceive() > 0;
			}
			return false;
			
		}
		
		public static SEForgeEnergyWrapper[] getDefaultWrapperArray(ISEInternalEnergyConnector handler){
			
			return new SEForgeEnergyWrapper[]{
					new SEForgeEnergyWrapper(handler, EnumFacing.DOWN),
					new SEForgeEnergyWrapper(handler, EnumFacing.EAST),
					new SEForgeEnergyWrapper(handler, EnumFacing.NORTH),
					new SEForgeEnergyWrapper(handler, EnumFacing.SOUTH),
					new SEForgeEnergyWrapper(handler, EnumFacing.UP),
					new SEForgeEnergyWrapper(handler, EnumFacing.WEST)
			};
			
		}
		
	}

}