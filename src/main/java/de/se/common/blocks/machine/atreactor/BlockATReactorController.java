
package de.se.common.blocks.machine.atreactor;

import de.se.common.blocks.BlockBase;
import de.se.common.tiles.atreactor.TileATReactorController;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockATReactorController extends BlockBase implements ITileEntityProvider{

	public BlockATReactorController(String name) {
		super(name);
		setHardness(3.0F);
		setResistance(2000F);
		setSoundType(SoundType.METAL);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileATReactorController();
	}
	
	

}
