package blueduck.dustrial.dustrialdecor.blocks;

import blueduck.dustrial.dustrialdecor.registry.DustrialBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.ScaffoldingBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class MetalScaffolding extends ScaffoldingBlock {

    //public static final IntegerProperty field_220118_a = IntegerProperty.create("distance", 0, 128);

    public World world = null;

    public MetalScaffolding(Properties properties) {
        super(properties);
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        int i = func_220117_a(worldIn, pos);
        BlockState blockstate = state.with(field_220118_a, Integer.valueOf(i)).with(field_220120_c, Boolean.valueOf(this.func_220116_a(worldIn, pos, i)));
        if ((!worldIn.getBlockState(pos.east()).isSolid()&& worldIn.getBlockState(pos.east()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!worldIn.getBlockState(pos.west()).isSolid() && worldIn.getBlockState(pos.west()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!worldIn.getBlockState(pos.north()).isSolid() && worldIn.getBlockState(pos.north()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!worldIn.getBlockState(pos.south()).isSolid() && worldIn.getBlockState(pos.south()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!worldIn.getBlockState(pos.down()).isSolid() && worldIn.getBlockState(pos.down()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState())) {
            worldIn.destroyBlock(pos, true);
            state.updateNeighbors(worldIn, pos, 0);
        }
        if (state != blockstate) {
            worldIn.setBlockState(pos, blockstate, 3);
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
        world = worldIn;
    }

    @Override
    public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
        if ((!world.getBlockState(pos.east()).isSolid()&& world.getBlockState(pos.east()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!world.getBlockState(pos.west()).isSolid() && world.getBlockState(pos.west()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!world.getBlockState(pos.north()).isSolid() && world.getBlockState(pos.north()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!world.getBlockState(pos.south()).isSolid() && world.getBlockState(pos.south()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState()) && (!world.getBlockState(pos.down()).isSolid() && world.getBlockState(pos.down()) != DustrialBlocks.METAL_SCAFFOLDING.get().getDefaultState())) {
            this.world.destroyBlock(pos, true);
        }
    }

    private boolean func_220116_a(IBlockReader p_220116_1_, BlockPos p_220116_2_, int p_220116_3_) {
        return p_220116_3_ > 0 && p_220116_1_.getBlockState(p_220116_2_.down()).getBlock() != this;
    }
}
