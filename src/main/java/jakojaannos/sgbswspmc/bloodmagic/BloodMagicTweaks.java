package jakojaannos.sgbswspmc.bloodmagic;

import jakojaannos.sgbswspmc.config.ModConfig;

public class BloodMagicTweaks {
    public static void applyTweaks() {
        if (!ModConfig.bloodMagic.enabled) {
            return;
        }

        if (ModConfig.bloodMagic.livingArmor.enabled) LivingArmorUpgradeTweaks.applyTweaks();
    }
}
