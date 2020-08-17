package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DustrialPane extends PaneBlock {

    public static final DamageSource BARBED = (new DamageSource("barb")).setDamageBypassesArmor();


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
    public boolean isLadder(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        return isClimbable;
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (isBarbed && worldIn.getRandom().nextInt(10) < 1) {
            entityIn.attackEntityFrom(BARBED, 1);
        }
    }
}
