package net.brodino.morekubejsevents.mixin;

import net.brodino.morekubejsevents.MoreKubeJSEvents;
import net.brodino.morekubejsevents.events.EffectApplicationEventJS;
import net.brodino.morekubejsevents.events.EffectRemovalEventJS;
import net.brodino.morekubejsevents.events.Events;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class Effects {

    @Inject(method = "onStatusEffectApplied", at = @At("HEAD"), cancellable = false)
    public void onStatusEffectApplied(StatusEffectInstance effect, Entity source, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!(entity instanceof PlayerEntity player)) {
            return;
        }

        Identifier effectId = Registry.STATUS_EFFECT.getId(effect.getEffectType());
        if (effectId == null) {
            return;
        }

        int effectAmplifier = effect.getAmplifier();

        if (MoreKubeJSEvents.CONFIG.getEnableLogs()) {
            MoreKubeJSEvents.LOGGER.info("Added effect {} level {} to player: {}", effectId, effectAmplifier, player.getDisplayName());
        }

        Events.EFFECT_APPLICATION.post(new EffectApplicationEventJS(player, effectId.toString(), effectAmplifier));
    }

    @Inject(method = "onStatusEffectRemoved", at = @At("HEAD"), cancellable = false)
    public void onStatusEffectRemoved(StatusEffectInstance effect, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (!(entity instanceof PlayerEntity player)) {
            return;
        }

        Identifier effectId = Registry.STATUS_EFFECT.getId(effect.getEffectType());
        if (effectId == null) {
            return;
        }

        int effectAmplifier = effect.getAmplifier();

        if (MoreKubeJSEvents.CONFIG.getEnableLogs()) {
            MoreKubeJSEvents.LOGGER.info("Removed effect {} level {} from player: {}", effectId, effectAmplifier, player.getDisplayName());
        }

        Events.EFFECT_REMOVAL.post(new EffectRemovalEventJS(player, effectId.toString(), effect.getAmplifier()));
    }
}
