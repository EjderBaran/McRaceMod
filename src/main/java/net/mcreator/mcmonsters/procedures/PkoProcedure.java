package net.mcreator.mcmonsters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.mcreator.mcmonsters.network.McMonstersModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PkoProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (McMonstersModVariables.MapVariables.get(world).Dragon == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 60, 1, (false), (false)));
		}
		if (McMonstersModVariables.MapVariables.get(world).Cat == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 60, 2, (false), (false)));
			if (entity.isInWater()) {
				entity.hurt(DamageSource.DROWN, 1);
			}
		}
		if (McMonstersModVariables.MapVariables.get(world).Ghost == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60, 2, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, (false), (false)));
		}
		if (McMonstersModVariables.MapVariables.get(world).Shadow == true) {
			if (world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) == 15) {
				if (world.dayTime() <= 12250 || world.dayTime() >= 23500) {
					entity.setSecondsOnFire(15);
				}
			}
		}
	}
}
