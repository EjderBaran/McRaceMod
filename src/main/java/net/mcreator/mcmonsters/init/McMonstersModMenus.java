
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.mcmonsters.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.mcmonsters.world.inventory.SelectraceMenu;
import net.mcreator.mcmonsters.McMonstersMod;

public class McMonstersModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, McMonstersMod.MODID);
	public static final RegistryObject<MenuType<SelectraceMenu>> SELECTRACE = REGISTRY.register("selectrace",
			() -> IForgeMenuType.create(SelectraceMenu::new));
}
