package blueduck.dustrial.dustrialdecor.blocks;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DustrialDoor extends DoorBlock {

    public DustrialDoor(Properties properties) {
            super(properties.notSolid());
        }
    public DustrialDoor(Material material, float hardness, float resist, SoundType sound, int harvestlvl, ToolType tool) {
        super(Properties.create(material)
                .hardnessAndResistance(hardness,resist)
                .sound(sound)
                .harvestLevel(harvestlvl)
                .harvestTool(tool).notSolid()
        );
    }




}
