package net.brodino.morekubejsevents.events;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;

public interface Events {
    EventGroup GROUP = EventGroup.of("MoreKubeJSEvents");

    EventHandler DIMENSION_CHANGE = GROUP.server("onPlayerDimensionChange", () -> DimensionChangeEventJS.class);
    EventHandler EFFECT_APPLICATION = GROUP.server("onPlayerEffectApplication", () -> EffectApplicationEventJS.class);
    EventHandler EFFECT_REMOVAL = GROUP.server("onPlayerEffectRemoval", () -> EffectApplicationEventJS.class);
}
