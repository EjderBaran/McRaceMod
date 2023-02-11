package net.mcreator.mcmonsters.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.mcmonsters.network.McMonstersModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level);
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		McMonstersModVariables.MapVariables.get(world).qcooldown = false;
		McMonstersModVariables.MapVariables.get(world).syncData(world);
	}
}
