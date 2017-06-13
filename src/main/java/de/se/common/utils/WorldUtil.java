package de.se.common.utils;

import java.util.List;

import de.se.common.utils.helper.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

/*
 * This class was created by Ellpeck and modified by Kendoshiii
 */

public class WorldUtil {

    public static void doEnergyInteraction(TileEntity tileFrom, TileEntity tileTo, EnumFacing sideTo, int maxTransfer){
        if(maxTransfer > 0){
            EnumFacing opp = sideTo == null ? null : sideTo.getOpposite();
            if(tileFrom.hasCapability(CapabilityEnergy.ENERGY, sideTo) && tileTo.hasCapability(CapabilityEnergy.ENERGY, opp)){
                IEnergyStorage handlerFrom = tileFrom.getCapability(CapabilityEnergy.ENERGY, sideTo);
                IEnergyStorage handlerTo = tileTo.getCapability(CapabilityEnergy.ENERGY, opp);

                if(handlerFrom != null && handlerTo != null){
                    int drain = handlerFrom.extractEnergy(maxTransfer, true);
                    if(drain > 0){
                        int filled = handlerTo.receiveEnergy(drain, false);
                        handlerFrom.extractEnergy(filled, false);
                        return;
                    }
                }
            }
        }
    }

    public static void doFluidInteraction(TileEntity tileFrom, TileEntity tileTo, EnumFacing sideTo, int maxTransfer){
        if(maxTransfer > 0){
            if(tileFrom.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, sideTo) && tileTo.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, sideTo.getOpposite())){
                IFluidHandler handlerFrom = tileFrom.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, sideTo);
                IFluidHandler handlerTo = tileTo.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, sideTo.getOpposite());
                FluidStack drain = handlerFrom.drain(maxTransfer, false);
                if(drain != null){
                    int filled = handlerTo.fill(drain.copy(), true);
                    handlerFrom.drain(filled, true);
                }
            }
        }
    }

}
