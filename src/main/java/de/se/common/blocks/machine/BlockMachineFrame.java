package de.se.common.blocks.machine;

import de.se.common.blocks.BlockBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMachineFrame extends BlockBase{

	public BlockMachineFrame(String name) {
		super(name);
	}
	
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return false;
    }

}
