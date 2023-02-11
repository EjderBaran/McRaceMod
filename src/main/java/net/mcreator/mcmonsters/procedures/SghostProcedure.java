package net.mcreator.mcmonsters.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.mcmonsters.network.McMonstersModVariables;

public class SghostProcedure {
	public static void execute(LevelAccessor world) {
		if (McMonstersModVariables.MapVariables.get(world).Secim == false) {
			McMonstersModVariables.MapVariables.get(world).Ghost = true;
			McMonstersModVariables.MapVariables.get(world).syncData(world);
			McMonstersModVariables.MapVariables.get(world).Secim = true;
			McMonstersModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
