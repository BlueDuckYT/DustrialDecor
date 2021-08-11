package blueduck.dustrial.dustrialdecor.blocks;

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

public class HookBlock extends Block {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(4.5D, 0.0D, 4.5D, 11.5D, 16.0D, 11.5D);


    public HookBlock(Properties properties) {
        super(properties);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
    }
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        return blockstate.isSolidSide(worldIn, blockpos, Direction.DOWN) || blockstate.getBlock() instanceof LargeChain;
    }


    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {

            return isValidPosition(stateIn, worldIn, currentPos) ? stateIn : Blocks.AIR.getDefaultState();

    }
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
