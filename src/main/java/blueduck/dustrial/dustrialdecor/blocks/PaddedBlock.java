package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PaddedBlock extends Block {
    public PaddedBlock(Properties properties) {
        super(properties);
    }

    public void fallOn(Level worldIn, BlockState state, BlockPos pos, Entity entityIn, float fallDistance) {
        if (entityIn.isSuppressingBounce()) {
            super.fallOn(worldIn, state, pos, entityIn, fallDistance);
        }

    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void updateEntityAfterFallOn(BlockGetter worldIn, Entity entityIn) {
        if (entityIn.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(worldIn, entityIn);
        } else {
            this.bounceUp(entityIn);
        }

    }

    private void bounceUp(Entity p_226946_1_) {
        Vec3 vec3d = p_226946_1_.getDeltaMovement();
        if (vec3d.y < 0.0D) {
            double d0 = p_226946_1_ instanceof LivingEntity ? 0.5D : 0.8D;
            p_226946_1_.setDeltaMovement(vec3d.x, -vec3d.y * d0, vec3d.z);
        }

    }
}
