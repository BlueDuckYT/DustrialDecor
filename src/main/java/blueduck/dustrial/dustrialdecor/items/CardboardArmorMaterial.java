package blueduck.dustrial.dustrialdecor.items;

import blueduck.dustrial.dustrialdecor.registry.DustrialBlocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CardboardArmorMaterial implements ArmorMaterial {

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * 10;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return 2;
    }

    @Override
    public int getEnchantmentValue() {
        return 5;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BEEHIVE_ENTER;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(DustrialBlocks.CARDBOARD.get());
    }

    @Override
    public String getName() {
        return "dustrial_decor:cardboard";
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
