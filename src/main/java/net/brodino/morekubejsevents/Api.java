package net.brodino.morekubejsevents;

import net.brodino.morekubejsevents.events.DimensionChangeEventJS;
import net.brodino.morekubejsevents.events.Events;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class Api {
    public static void initialize() {
        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((ServerPlayerEntity player, ServerWorld from, ServerWorld to) -> {
            if (MoreKubeJSEvents.CONFIG.getEnableLogs()) {
                MoreKubeJSEvents.LOGGER.info("Player: {} changed dimension and went from {} to {}",
                        player.getName().getString(), from.getRegistryKey().getValue(), to.getRegistryKey().getValue()
                );
            }
            Events.DIMENSION_CHANGE.post(new DimensionChangeEventJS(player, from, to));
        });
    }
}
