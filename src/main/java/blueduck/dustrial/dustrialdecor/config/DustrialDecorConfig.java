package blueduck.dustrial.dustrialdecor.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DustrialDecorConfig {


    public ConfigHelper.ConfigValueListener<Boolean> MOBS_SPAWN_WITH_CARDBOARD_ARMOR;
    public ConfigHelper.ConfigValueListener<Boolean> VILLAGE_HOUSES;
    public ConfigHelper.ConfigValueListener<Boolean> LOOT_TABLE_MODIFICATION;


    public DustrialDecorConfig(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber) {
        builder.push("General");

        this.MOBS_SPAWN_WITH_CARDBOARD_ARMOR= subscriber.subscribe(builder
                .comment("Should mobs spawn with cardboard armor?")
                .define("cardboard_armor_spawns", false, o -> o instanceof Boolean));
        this.VILLAGE_HOUSES= subscriber.subscribe(builder
                .comment("Should a few houses using this mod's blocks be added to the village pools?")
                .define("village_houses", false, o -> o instanceof Boolean));
        this.LOOT_TABLE_MODIFICATION= subscriber.subscribe(builder
                .comment("Add this mod's items to loot tables? (such as dungeon chests)")
                .define("loot_table_modification", true, o -> o instanceof Boolean));

        builder.pop();
    }

}
