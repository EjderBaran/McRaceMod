package net.mcreator.mcmonsters.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.mcmonsters.network.McMonstersModVariables;

public class SshadowProcedure {
	public static void execute(LevelAccessor world) {
		if (McMonstersModVariables.MapVariables.get(world).Secim == false) {
			McMonstersModVariables.MapVariables.get(world).Shadow = true;
			McMonstersModVariables.MapVariables.get(world).syncData(world);
			McMonstersModVariables.MapVariables.get(world).Secim = true;
			McMonstersModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
