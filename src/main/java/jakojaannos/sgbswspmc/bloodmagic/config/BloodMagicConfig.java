package jakojaannos.sgbswspmc.bloodmagic.config;

import net.minecraftforge.common.config.Config.Comment;

public class BloodMagicConfig {
    @Comment("Enable/Disable all tweaks")
    public boolean enabled = true;

    public LivingArmorConfig livingArmor = new LivingArmorConfig();
}
