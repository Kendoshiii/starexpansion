package de.se.common.blocks;

import javax.annotation.Nullable;

import cofh.api.block.IDismantleable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockTileEntity<TE extends TileEntity> extends BlockBase{

	public BlockTileEntity(String name) {
		super(name);
	}

	public abstract Class<TE> getTileEntityClass();

	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE) world.getTileEntity(pos);
	}

	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Nullable
	public abstract TE createTileEntity(World paramWorld, IBlockState paramIBlockState);

}
