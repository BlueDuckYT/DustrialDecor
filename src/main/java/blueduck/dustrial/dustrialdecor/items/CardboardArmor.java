package blueduck.dustrial.dustrialdecor.items;

import blueduck.dustrial.dustrialdecor.DustrialDecorMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.util.SoundEvents;

public class CardboardArmor extends ArmorItem {
    public CardboardArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }
}
