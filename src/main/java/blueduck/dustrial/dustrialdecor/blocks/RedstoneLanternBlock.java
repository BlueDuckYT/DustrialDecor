package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class RedstoneLanternBlock extends LanternBlock {

    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public RedstoneLanternBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HANGING, Boolean.valueOf(false)).with(WATERLOGGED, Boolean.valueOf(false)).with(LIT, Boolean.valueOf(false)));
    }

    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HANGING, WATERLOGGED, LIT);
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            worldIn.setBlockState(pos, state.with(LIT, !state.get(LIT)));
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.CONSUME;
    }

    }
