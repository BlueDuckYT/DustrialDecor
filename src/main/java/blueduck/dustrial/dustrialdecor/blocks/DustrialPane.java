package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DustrialPane extends IronBarsBlock {

    public static final DamageSource BARBED = (new DamageSource("barb")).bypassArmor();


    public boolean isClimbable;
    public boolean isBarbed;
    public DustrialPane(Properties builder) {
        super(builder);
        isClimbable = false;
        isBarbed = false;
    }
    public DustrialPane(Properties builder, boolean isClimbable, boolean isBarbed) {
        super(builder);
        this.isClimbable = isClimbable;
        this.isBarbed = isBarbed;
    }

    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.level.LevelReader world, BlockPos pos, net.minecraft.world.entity.LivingEntity entity) {
        return isClimbable;
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (isBarbed && worldIn.getRandom().nextInt(10) < 1) {
            entityIn.hurt(BARBED, 1);
        }
    }
}
