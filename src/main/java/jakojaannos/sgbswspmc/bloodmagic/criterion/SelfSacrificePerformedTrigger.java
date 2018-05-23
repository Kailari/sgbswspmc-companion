package jakojaannos.sgbswspmc.bloodmagic.criterion;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import jakojaannos.sgbswspmc.ModInfo;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SelfSacrificePerformedTrigger implements ICriterionTrigger<SelfSacrificePerformedTrigger.Instance> {
    private static final ResourceLocation ID = new ResourceLocation(ModInfo.MODID, "bloodmagic_sacrifice_self");
    private final Map<PlayerAdvancements, Listeners> triggerListeners = Maps.newHashMap();

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void addListener(PlayerAdvancements playerAdvancements, Listener<Instance> listener) {
        if (!triggerListeners.containsKey(playerAdvancements)) {
            triggerListeners.put(playerAdvancements, new Listeners());
        }

        triggerListeners.get(playerAdvancements).add(listener);
    }

    @Override
    public void removeListener(PlayerAdvancements playerAdvancements, Listener<Instance> listener) {
        Listeners listeners = triggerListeners.get(playerAdvancements);
        if (listeners != null) {
            listeners.remove(listener);

            if (listeners.isEmpty()) {
                triggerListeners.remove(playerAdvancements);
            }
        }
    }

    @Override
    public void removeAllListeners(PlayerAdvancements playerAdvancements) {
        triggerListeners.remove(playerAdvancements);
    }

    @Override
    public Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
        MinMaxBounds incense = MinMaxBounds.deserialize(json.get("incense"));
        MinMaxBounds hpdrain = MinMaxBounds.deserialize(json.get("hpdrain"));
        return new SelfSacrificePerformedTrigger.Instance(incense, hpdrain);
    }

    public void trigger(EntityPlayerMP player, double incense, int hpdrain) {
        if (triggerListeners.containsKey(player.getAdvancements())) {
            triggerListeners.get(player.getAdvancements()).trigger(player.getAdvancements(), incense, hpdrain);
        }
    }

    static class Instance extends AbstractCriterionInstance {
        private final MinMaxBounds incense;
        private final MinMaxBounds hpdrain;

        Instance(MinMaxBounds incense, MinMaxBounds hpdrain) {
            super(ID);
            this.incense = incense;
            this.hpdrain = hpdrain;
        }

        boolean test(double incense, int hpdrain) {
            return this.incense.test((float) incense) && this.hpdrain.test(hpdrain);
        }
    }

    static class Listeners {
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        boolean isEmpty() {
            return listeners.isEmpty();
        }

        void add(Listener<Instance> listener) {
            listeners.add(listener);
        }

        void remove(Listener<Instance> listener) {
            listeners.remove(listener);
        }

        public void trigger(PlayerAdvancements playerAdvancements, double incense, int hpdrain) {
            List<Listener<Instance>> relevantListeners = listeners.stream()
                    .filter(listener -> listener.getCriterionInstance().test(incense, hpdrain))
                    .collect(Collectors.toList());

            if (!relevantListeners.isEmpty()) {
                relevantListeners.forEach(listener -> listener.grantCriterion(playerAdvancements));
            }
        }
    }
}
