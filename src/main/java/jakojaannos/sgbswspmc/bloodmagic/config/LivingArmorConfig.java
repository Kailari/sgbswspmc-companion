package jakojaannos.sgbswspmc.bloodmagic.config;

import net.minecraftforge.common.config.Config.Comment;

public class LivingArmorConfig {
    @Comment("Enable/Disable living armor upgrade tweaks")
    public boolean enabled = true;

    @Comment("Jump upgrade")
    public Jump jump = new Jump();

    @Comment("Speed upgrade")
    public Speed speed = new Speed();

    public static class Jump {
        public boolean enabled = true;
        public int[] upgradeCost = new int[]{3, 6, 11, 23, 37, 50, 70, 100, 140, 200};
        public double[] jumpHeightModifiers = new double[]{0.05, 0.1, 0.15, 0.2, 0.25, 0.35, 0.45, 0.55, 0.65, 0.75};
        public double[] fallModifiers = new double[]{0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.75, 0.8, 0.85};
    }

    public static class Speed {
        public boolean enabled;
        public int[] upgradeCost = new int[]{3, 7, 13, 26, 42, 60, 90, 130, 180, 250};
        public double[] speedModifier = new double[]{0.05, 0.1, 0.15, 0.2, 0.25, 0.35, 0.45, 0.55, 0.65, 0.75};
        public int[] sprintSpeedLevel = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] sprintSpeedTime = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] healthModifier = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        public int[] sprintRegenTime = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
