package jakojaannos.sgbswspmc.bloodmagic;

import WayofTime.bloodmagic.event.SacrificeKnifeUsedEvent;
import WayofTime.bloodmagic.util.helper.IncenseHelper;
import jakojaannos.sgbswspmc.advancements.ModCriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class BloodMagicEventHandler {
    @SubscribeEvent
    public static void onSacrificeKnifeUsed(SacrificeKnifeUsedEvent event) {
        if (event.player.world.isRemote)
            return;

        if (event.player instanceof EntityPlayerMP) {
            ModCriteriaTriggers.BLOODMAGIC_SELF_SACRIFICE.trigger((EntityPlayerMP) event.player, IncenseHelper.getCurrentIncense(event.player), event.healthDrained);
        }
    }
}
