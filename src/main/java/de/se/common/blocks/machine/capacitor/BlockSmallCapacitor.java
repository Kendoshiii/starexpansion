package de.se.common.blocks.machine.capacitor;

import de.se.common.blocks.BlockBase;
import de.se.common.tiles.capacitor.TileSmallCapacitor;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSmallCapacitor extends BlockBase implements ITileEntityProvider{

	public BlockSmallCapacitor(Material material, String name) {
		super(name);
		setHardness(5.0F);
		setResistance(10F);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		state = super.getActualState(state, world, pos);
		return state;
	}

	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileSmallCapacitor();
	}

		
	
}
