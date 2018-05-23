package jakojaannos.sgbswspmc;

import jakojaannos.sgbswspmc.advancements.ModCriteriaTriggers;
import jakojaannos.sgbswspmc.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = ModInfo.DEPENDENCIES)
public class SgbswspMcMod {
    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModConfig.sync();
    }

    @EventHandler
    public void init(FMLPostInitializationEvent event) {
        new ModCriteriaTriggers(); // Dummy call to ensure static initializers getting called
    }
}
