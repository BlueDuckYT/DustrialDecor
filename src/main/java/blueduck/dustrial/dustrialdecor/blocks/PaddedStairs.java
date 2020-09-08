package blueduck.dustrial.dustrialdecor.blocks;

import blueduck.dustrial.dustrialdecor.registry.DustrialBlocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PaddedStairs extends StairsBlock {
    public PaddedStairs(Properties properties) {
        super(DustrialBlocks.MINI_PADDED_BLOCK.get().getDefaultState(), properties);
    }


    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (entityIn.isSuppressingBounce()) {
            super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
        } else {
            entityIn.onLivingFall(fallDistance, 0.0F);
        }

    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.onLanded(worldIn, entityIn);
        } else {
            this.func_226946_a_(entityIn);
        }

    }

    private void func_226946_a_(Entity p_226946_1_) {
        Vector3d vec3d = p_226946_1_.getMotion();
        if (vec3d.y < 0.0D) {
            double d0 = p_226946_1_ instanceof LivingEntity ? 0.5D : 0.8D;
            p_226946_1_.setMotion(vec3d.x, -vec3d.y * d0, vec3d.z);
        }

    }
}
