
package net.mcreator.mcmonsters.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.mcmonsters.world.inventory.SelectraceMenu;
import net.mcreator.mcmonsters.procedures.SshadowProcedure;
import net.mcreator.mcmonsters.procedures.SghostProcedure;
import net.mcreator.mcmonsters.procedures.SdragonProcedure;
import net.mcreator.mcmonsters.procedures.ScatProcedure;
import net.mcreator.mcmonsters.procedures.EXITRACEProcedure;
import net.mcreator.mcmonsters.McMonstersMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SelectraceButtonMessage {
	private final int buttonID, x, y, z;

	public SelectraceButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SelectraceButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SelectraceButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SelectraceButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = SelectraceMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SdragonProcedure.execute(world);
		}
		if (buttonID == 1) {

			ScatProcedure.execute(world);
		}
		if (buttonID == 2) {

			SghostProcedure.execute(world);
		}
		if (buttonID == 3) {

			EXITRACEProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			SshadowProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		McMonstersMod.addNetworkMessage(SelectraceButtonMessage.class, SelectraceButtonMessage::buffer, SelectraceButtonMessage::new,
				SelectraceButtonMessage::handler);
	}
}
