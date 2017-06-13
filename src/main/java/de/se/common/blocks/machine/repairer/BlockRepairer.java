package de.se.common.blocks.machine.repairer;

import de.se.StarExpansion;
import de.se.common.lib.Reference;
import de.se.common.tiles.repairer.TileRepairer;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRepairer extends BlockContainer{

	public static final PropertyDirection FACING;

	static {FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);}

	private Item itemBlock; 
	
	public BlockRepairer(String name) {
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(Reference.MODID, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setHardness(10F);
		setResistance(10F);
		setSoundType(SoundType.METAL);

	}

	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState blockState, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(world, pos, blockState, placer, stack);
		world.setBlockState(pos, blockState.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
		TileEntity tile = world.getTileEntity(pos);
		if (tile instanceof TileRepairer) {
			((TileRepairer) tile).setOrientation(world.getBlockState(pos).getValue(FACING));
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileRepairer();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileRepairer tile = (TileRepairer) world.getTileEntity(pos);
		
		if (player.isSneaking())
			return false;
		
		if (tile != null) {
			if (!world.isRemote) {
				player.openGui(StarExpansion.INSTANCE, 0, world, pos.getX(), pos.getY(), pos.getZ());
			}
			return true;
		}
		return false;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumFacing = EnumFacing.getFront(meta);
		if(enumFacing.getAxis() == EnumFacing.Axis.Y) {
			enumFacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumFacing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	
}
