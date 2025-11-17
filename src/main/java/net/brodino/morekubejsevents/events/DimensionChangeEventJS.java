package net.brodino.morekubejsevents.events;

import dev.latvian.mods.kubejs.player.PlayerEventJS;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class DimensionChangeEventJS extends PlayerEventJS {

    private final PlayerEntity player;
    private final ServerWorld origin;
    private final ServerWorld destination;

    public DimensionChangeEventJS(PlayerEntity player, ServerWorld origin, ServerWorld destination) {
        this.player = player;
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public PlayerEntity getEntity() {
        return this.player;
    }

    public ServerWorld getOrigin() {
        return origin;
    }

    public ServerWorld getDestination() {
        return destination;
    }

}
