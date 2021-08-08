package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class LargeChain extends ChainBlock {

    protected static final VoxelShape Y_AXIS_SHAPE = Block.makeCuboidShape(4.5D, 0.0D, 4.5D, 11.5D, 16.0D, 11.5D);
    protected static final VoxelShape Z_AXIS_SHAPE = Block.makeCuboidShape(4.5D, 4.5D, 0.0D, 11.5D, 11.5D, 16.0D);
    protected static final VoxelShape X_AXIS_SHAPE = Block.makeCuboidShape(0.0D, 4.5D, 4.5D, 16.0D, 11.5D, 11.5D);


    public LargeChain(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return false;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch((Direction.Axis)state.get(AXIS)) {
            case X:
            default:
                return X_AXIS_SHAPE;
            case Z:
                return Z_AXIS_SHAPE;
            case Y:
                return Y_AXIS_SHAPE;
        }
    }
}
