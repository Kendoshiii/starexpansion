package de.se.common.compat.top;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Level;

import com.google.common.base.Function;

import de.se.StarExpansion;
import de.se.api.energy.starflux.IStarFluxProvider;
import de.se.api.energy.starflux.IStarFluxReceiver;
import de.se.common.utils.helper.LogHelper;
import mcjty.theoneprobe.api.IProbeConfig;
import mcjty.theoneprobe.api.IProbeConfigProvider;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeHitEntityData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.IProbeInfoProvider;
import mcjty.theoneprobe.api.ITheOneProbe;
import mcjty.theoneprobe.api.NumberFormat;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class CompatHelperTOP{

	private static boolean registered;

    public static void register() {
        if (registered)
            return;
        registered = true;
		FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", "de.se.common.compat.CompatHelperTOP§getTheOneProbe");
    }

	public static class getTheOneProbe implements Function<ITheOneProbe, Void>{
		
		@Nullable
		@Override
		public Void apply(ITheOneProbe input) {
			
			LogHelper.log(Level.INFO, "Enabled support for The One Probe");
			EnergyInfoProvider energyInfo = new EnergyInfoProvider();
			input.registerProvider(energyInfo);
			input.registerProbeConfigProvider(energyInfo);
			return null;
		}
		
	}
	
	public static class EnergyInfoProvider implements IProbeInfoProvider, IProbeConfigProvider{
		
		@Override
		public String getID()
		{
			return StarExpansion.MODID+":"+"EnergyInfo";
		}

		@Override
		public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data)
		{
			TileEntity te = world.getTileEntity(data.getPos());
			int cur = 0;
			int max = 0;
			if(te instanceof IStarFluxReceiver)
			{
				cur = ((IStarFluxReceiver)te).getEnergyStored(null);
				max = ((IStarFluxReceiver)te).getMaxEnergyStored(null);
			}
			else if(te instanceof IStarFluxProvider)
			{
				cur = ((IStarFluxProvider)te).getEnergyStored(null);
				max = ((IStarFluxProvider)te).getMaxEnergyStored(null);
			}
			if(max>0)
			{
				probeInfo.progress(cur, max,
						probeInfo.defaultProgressStyle()
								.suffix("SF")
								.filledColor(0x0066cc)
								.alternateFilledColor(0xff994f20)
								.borderColor(0x002851)
								.numberFormat(NumberFormat.COMPACT));
			}
		}

		@Override
		public void getProbeConfig(IProbeConfig config, EntityPlayer player, World world, Entity entity, IProbeHitEntityData data)
		{
		}
		@Override
		public void getProbeConfig(IProbeConfig config, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data)
		{
			TileEntity te = world.getTileEntity(data.getPos());
			if(te instanceof IStarFluxReceiver || te instanceof IStarFluxProvider)
				config.setRFMode(0);
		}
		
	}
	
}
