package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Direction.AxisDirection;
import net.minecraft.util.StringRepresentable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class VerticalSlabBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    public static final BooleanProperty WATERLOGGED;

    public VerticalSlabBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(TYPE, VerticalSlabType.NORTH)).setValue(WATERLOGGED, false));
    }

    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TYPE, WATERLOGGED});
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return ((VerticalSlabType)state.getValue(TYPE)).shape;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        return blockstate.getBlock() == this ? ((BlockState)blockstate.setValue(TYPE, VerticalSlabType.DOUBLE)).setValue(WATERLOGGED, false) : (BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, context.getLevel().getFluidState(blockpos).getType() == Fluids.WATER)).setValue(TYPE, VerticalSlabType.fromDirection(this.getDirectionForPlacement(context)));
    }

    private Direction getDirectionForPlacement(BlockPlaceContext context) {
        Direction face = context.getClickedFace();
        if (face.getAxis() != Axis.Y) {
            return face;
        } else {
            Vec3 difference = context.getClickLocation().subtract(Vec3.atLowerCornerOf(context.getClickedPos())).subtract(0.5D, 0.0D, 0.5D);
            return Direction.fromYRot(-Math.toDegrees(Math.atan2(difference.x(), difference.z()))).getOpposite();
        }
    }

    public boolean canBeReplaced(BlockState state, @Nonnull BlockPlaceContext context) {
        VerticalSlabType slabtype = (VerticalSlabType)state.getValue(TYPE);
        return slabtype != VerticalSlabType.DOUBLE && context.getItemInHand().getItem() == this.asItem() && context.replacingClickedOnBlock() && context.getClickedFace() == slabtype.direction && this.getDirectionForPlacement(context) == slabtype.direction;
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    public boolean placeLiquid(LevelAccessor worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    public boolean canPlaceLiquid(BlockGetter worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return state;
    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return type == PathComputationType.WATER && worldIn.getFluidState(pos).is(Fluids.WATER);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }

    public static enum VerticalSlabType implements StringRepresentable {
        NORTH(Direction.NORTH),
        SOUTH(Direction.SOUTH),
        WEST(Direction.WEST),
        EAST(Direction.EAST),
        DOUBLE((Direction)null);

        private final String name;
        @Nullable
        public final Direction direction;
        public final VoxelShape shape;

        private VerticalSlabType(@Nullable Direction direction) {
            this.direction = direction;
            this.name = direction == null ? "double" : direction.getSerializedName();
            if (direction == null) {
                this.shape = Shapes.block();
            } else {
                boolean isNegativeAxis = direction.getAxisDirection() == AxisDirection.NEGATIVE;
                double min = isNegativeAxis ? 8.0D : 0.0D;
                double max = isNegativeAxis ? 16.0D : 8.0D;
                this.shape = direction.getAxis() == Axis.X ? Block.box(min, 0.0D, 0.0D, max, 16.0D, 16.0D) : Block.box(0.0D, 0.0D, min, 16.0D, 16.0D, max);
            }

        }

        public static VerticalSlabType fromDirection(Direction direction) {
            VerticalSlabType[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                VerticalSlabType type = var1[var3];
                if (type.direction != null && direction == type.direction) {
                    return type;
                }
            }

            return null;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}