package jakojaannos.sgbswspmc.bloodmagic;

import WayofTime.bloodmagic.livingArmour.upgrade.LivingArmourUpgradeJump;
import WayofTime.bloodmagic.livingArmour.upgrade.LivingArmourUpgradeSpeed;
import jakojaannos.sgbswspmc.config.ModConfig;

class LivingArmorUpgradeTweaks {
    static void applyTweaks() {
        // Jump upgrade
        if (ModConfig.bloodMagic.livingArmor.jump.enabled) {
            System.arraycopy(ModConfig.bloodMagic.livingArmor.jump.upgradeCost, 0, LivingArmourUpgradeJump.costs, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.jump.jumpHeightModifiers, 0, LivingArmourUpgradeJump.jumpModifier, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.jump.fallModifiers, 0, LivingArmourUpgradeJump.fallModifier, 0, 10);
        }

        // Speed upgrade
        if (ModConfig.bloodMagic.livingArmor.speed.enabled) {
            System.arraycopy(ModConfig.bloodMagic.livingArmor.speed.upgradeCost, 0, LivingArmourUpgradeSpeed.costs, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.speed.speedModifier, 0, LivingArmourUpgradeSpeed.speedModifier, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.speed.sprintSpeedLevel, 0, LivingArmourUpgradeSpeed.sprintSpeedLevel, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.speed.sprintSpeedTime, 0, LivingArmourUpgradeSpeed.sprintSpeedTime, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.speed.healthModifier, 0, LivingArmourUpgradeSpeed.healthModifier, 0, 10);
            System.arraycopy(ModConfig.bloodMagic.livingArmor.speed.sprintRegenTime, 0, LivingArmourUpgradeSpeed.sprintRegenTime, 0, 10);

        }
    }
}
