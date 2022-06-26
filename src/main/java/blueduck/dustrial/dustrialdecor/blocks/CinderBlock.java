package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import java.util.Random;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CinderBlock extends RotatedPillarBlock {
    public CinderBlock(Properties properties) {
        super(properties);
    }


    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        worldIn.scheduleTick(pos, this, this.tickRate(worldIn));
    }

    /**
     * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
     * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
     * returns its solidified counterpart.
     * Note that this method should ideally consider only the specific face passed in.
     */
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        worldIn.scheduleTick(currentPos, this, this.tickRate(worldIn));
        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public void tick(BlockState p_53216_, ServerLevel p_53217_, BlockPos p_53218_, Random p_53219_) {
        if (isFree(p_53217_.getBlockState(p_53218_.below())) && p_53218_.getY() >= p_53217_.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.m_201971_(p_53217_, p_53218_, p_53216_);
            this.falling(fallingblockentity);
        }
    }

    protected void falling(FallingBlockEntity p_53206_) {
    }

    public static boolean isFree(BlockState p_53242_) {
        Material material = p_53242_.getMaterial();
        return p_53242_.isAir() || p_53242_.m_204336_(BlockTags.FIRE) || material.isLiquid() || material.isReplaceable();
    }

    protected void onStartFalling(FallingBlockEntity fallingEntity) {
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(LevelReader worldIn) {
        return 2;
    }

    public static boolean canFallThrough(BlockState state) {
        Block block = state.getBlock();
        Material material = state.getMaterial();
        return state.isAir() || block == Blocks.FIRE || material.isLiquid() || material.isReplaceable();
    }
}
