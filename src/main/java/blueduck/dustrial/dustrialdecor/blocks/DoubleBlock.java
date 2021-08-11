package blueduck.dustrial.dustrialdecor.blocks;

import blueduck.dustrial.dustrialdecor.registry.DustrialBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class DoubleBlock extends Block {


    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    protected static final VoxelShape TOP_SHAPE = Block.makeCuboidShape(4.5D, 0.0D, 4.5D, 11.5D, 16.0D, 11.5D);
    protected static final VoxelShape BOTTOM_SHAPE = Block.makeCuboidShape(4.5D, 0.0D, 4.5D, 11.5D, 16.0D, 11.5D);


    public DoubleBlock(Properties properties) {
        super(properties);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        worldIn.setBlockState(pos.down(), state.with(HALF, DoubleBlockHalf.LOWER), 3);
    }
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        return state.get(HALF) == DoubleBlockHalf.UPPER ? blockstate.isSolidSide(worldIn, blockpos, Direction.DOWN) || blockstate.getBlock() instanceof LargeChain : blockstate.isIn(this);
    }

    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HALF);
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = stateIn.get(HALF);
        if (facing.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
            return facingState.isIn(this) && facingState.get(HALF) != doubleblockhalf ? stateIn : Blocks.AIR.getDefaultState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.UPPER && facing == Direction.UP && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return state.get(HALF) == DoubleBlockHalf.UPPER ? TOP_SHAPE : BOTTOM_SHAPE;
    }
}
