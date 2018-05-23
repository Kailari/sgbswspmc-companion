package jakojaannos.sgbswspmc.config;

import jakojaannos.sgbswspmc.ModInfo;
import jakojaannos.sgbswspmc.bloodmagic.BloodMagicTweaks;
import jakojaannos.sgbswspmc.bloodmagic.config.BloodMagicConfig;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Config(modid = ModInfo.MODID, name = ModInfo.MODID + "/" + ModInfo.MODID)
@EventBusSubscriber
public class ModConfig {
    @Comment("Configure tweaks applied to Blood Magic")
    public static BloodMagicConfig bloodMagic = new BloodMagicConfig();

    public static void sync() {
        ConfigManager.sync(ModInfo.MODID, Config.Type.INSTANCE);
        BloodMagicTweaks.applyTweaks();
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ModInfo.MODID)) {
            ModConfig.sync();
        }
    }
}
