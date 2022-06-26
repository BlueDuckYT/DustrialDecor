package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class LargeChain extends ChainBlock {

    protected static final VoxelShape Y_AXIS_SHAPE = Block.box(4.5D, 0.0D, 4.5D, 11.5D, 16.0D, 11.5D);
    protected static final VoxelShape Z_AXIS_SHAPE = Block.box(4.5D, 4.5D, 0.0D, 11.5D, 11.5D, 16.0D);
    protected static final VoxelShape X_AXIS_SHAPE = Block.box(0.0D, 4.5D, 4.5D, 16.0D, 11.5D, 11.5D);


    public LargeChain(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.level.LevelReader world, BlockPos pos, net.minecraft.world.entity.LivingEntity entity) {
        return state.getValue(AXIS).equals(Direction.Axis.Y);
    }


    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch((Direction.Axis)state.getValue(AXIS)) {
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
