package red.jad.nojumpscare;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
	@Redirect( method = "onGameStateChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V"))
	private void removeJumpscare(ClientWorld clientWorld, ParticleEffect parameters, double x, double y, double z, double velocityX, double velocityY, double velocityZ){ }
	@Redirect( method = "onGameStateChange", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V", ordinal = 2))
	private void removeJumpscareSound(ClientWorld clientWorld, PlayerEntity player, double x, double y, double z, SoundEvent sound, SoundCategory category, float volume, float pitch){}
}
