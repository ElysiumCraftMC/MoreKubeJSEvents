package net.brodino.morekubejsevents.events;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import net.minecraft.entity.player.PlayerEntity;

public class EffectApplicationEventJS extends PlayerEventJS {

    private final PlayerEntity player;
    private final String effectId;
    private final int amplifier;

    public EffectApplicationEventJS(PlayerEntity player, String effectId, int amplifier) {
        this.player = player;
        this.effectId = effectId;
        this.amplifier = amplifier;
    }

    @Override
    public PlayerEntity getEntity() {
        return this.player;
    }

    public String getEffectId() {
        return this.effectId;
    }

    public int getAmplifier() {
        return this.amplifier;
    }
}
