package de.se.common.proxy;

import de.se.common.container.repairer.ContainerRepairer;
import de.se.common.gui.repairer.GUIRepairer;
import de.se.common.tiles.repairer.TileRepairer;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		BlockPos pos = new BlockPos(x, y, z);
		Block block = world.getBlockState(pos).getBlock();

		TileEntity tile = world.getTileEntity(pos);
			
		switch (ID) {
		case 0:
				
			if (!(tile instanceof TileRepairer))
				return null;
			return new ContainerRepairer(player.inventory, (TileRepairer) tile);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		BlockPos pos = new BlockPos(x, y, z);
		Block block = world.getBlockState(pos).getBlock();
		
		TileEntity tile = world.getTileEntity(pos);
			
		switch (ID) {
		case 0:
			
			if (!(tile instanceof TileRepairer))
				return null;
			return new GUIRepairer(player.inventory, world, (TileRepairer) tile);
			
		default:
			return null;
		}
	}
}
