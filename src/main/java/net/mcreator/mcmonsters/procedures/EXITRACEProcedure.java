package net.mcreator.mcmonsters.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.mcmonsters.network.McMonstersModVariables;
import net.mcreator.mcmonsters.McMonstersMod;

public class EXITRACEProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		McMonstersModVariables.MapVariables.get(world).Secim = false;
		McMonstersModVariables.MapVariables.get(world).syncData(world);
		McMonstersModVariables.MapVariables.get(world).qcooldown = true;
		McMonstersModVariables.MapVariables.get(world).syncData(world);
		McMonstersMod.queueServerWork(500, () -> {
			McMonstersModVariables.MapVariables.get(world).qcooldown = false;
			McMonstersModVariables.MapVariables.get(world).syncData(world);
		});
	}
}
