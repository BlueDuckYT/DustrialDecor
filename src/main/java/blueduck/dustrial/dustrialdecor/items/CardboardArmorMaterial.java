package blueduck.dustrial.dustrialdecor.items;

import blueduck.dustrial.dustrialdecor.registry.DustrialBlocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CardboardArmorMaterial implements IArmorMaterial {

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * 10;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.BLOCK_BEEHIVE_ENTER;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(DustrialBlocks.CARDBOARD.get());
    }

    @OnlyIn(Dist.CLIENT)
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
