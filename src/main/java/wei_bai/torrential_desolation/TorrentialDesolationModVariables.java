package wei_bai.torrential_desolation;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class TorrentialDesolationModVariables {
	public TorrentialDesolationModVariables(TorrentialDesolationModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("torrential_desolation", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("power", instance.power);
			nbt.putString("health", instance.health);
			nbt.putString("maxhealth", instance.maxhealth);
			nbt.putString("self_cultivation", instance.self_cultivation);
			nbt.putDouble("healths", instance.healths);
			nbt.putDouble("maxhealths", instance.maxhealths);
			nbt.putDouble("mathxyz0", instance.mathxyz0);
			nbt.putString("tao", instance.tao);
			nbt.putBoolean("tao_if", instance.tao_if);
			nbt.putDouble("fabaolan", instance.fabaolan);
			nbt.putString("jinjie", instance.jinjie);
			nbt.putDouble("linqiizhi", instance.linqiizhi);
			nbt.putDouble("linqiizhimax", instance.linqiizhimax);
			nbt.putString("powertext", instance.powertext);
			nbt.putString("linqiizhimaxsc", instance.linqiizhimaxsc);
			nbt.putDouble("Hud_Open", instance.Hud_Open);
			nbt.putDouble("xuiwei_health", instance.xuiwei_health);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.power = nbt.getDouble("power");
			instance.health = nbt.getString("health");
			instance.maxhealth = nbt.getString("maxhealth");
			instance.self_cultivation = nbt.getString("self_cultivation");
			instance.healths = nbt.getDouble("healths");
			instance.maxhealths = nbt.getDouble("maxhealths");
			instance.mathxyz0 = nbt.getDouble("mathxyz0");
			instance.tao = nbt.getString("tao");
			instance.tao_if = nbt.getBoolean("tao_if");
			instance.fabaolan = nbt.getDouble("fabaolan");
			instance.jinjie = nbt.getString("jinjie");
			instance.linqiizhi = nbt.getDouble("linqiizhi");
			instance.linqiizhimax = nbt.getDouble("linqiizhimax");
			instance.powertext = nbt.getString("powertext");
			instance.linqiizhimaxsc = nbt.getString("linqiizhimaxsc");
			instance.Hud_Open = nbt.getDouble("Hud_Open");
			instance.xuiwei_health = nbt.getDouble("xuiwei_health");
		}
	}

	public static class PlayerVariables {
		public double power = 0.0;
		public String health = "";
		public String maxhealth = "";
		public String self_cultivation = "\u51E1\u4EBA";
		public double healths = 0;
		public double maxhealths = 0;
		public double mathxyz0 = 0.0;
		public String tao = "\u65E0\u9053";
		public boolean tao_if = false;
		public double fabaolan = 0.0;
		public String jinjie = "";
		public double linqiizhi = 0.0;
		public double linqiizhimax = 1000.0;
		public String powertext = "";
		public String linqiizhimaxsc = "";
		public double Hud_Open = 0.0;
		public double xuiwei_health = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				TorrentialDesolationMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		if (!event.isWasDeath()) {
			clone.power = original.power;
			clone.health = original.health;
			clone.maxhealth = original.maxhealth;
			clone.self_cultivation = original.self_cultivation;
			clone.healths = original.healths;
			clone.maxhealths = original.maxhealths;
			clone.mathxyz0 = original.mathxyz0;
			clone.tao = original.tao;
			clone.tao_if = original.tao_if;
			clone.fabaolan = original.fabaolan;
			clone.jinjie = original.jinjie;
			clone.linqiizhi = original.linqiizhi;
			clone.linqiizhimax = original.linqiizhimax;
			clone.powertext = original.powertext;
			clone.linqiizhimaxsc = original.linqiizhimaxsc;
			clone.Hud_Open = original.Hud_Open;
			clone.xuiwei_health = original.xuiwei_health;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.power = message.data.power;
					variables.health = message.data.health;
					variables.maxhealth = message.data.maxhealth;
					variables.self_cultivation = message.data.self_cultivation;
					variables.healths = message.data.healths;
					variables.maxhealths = message.data.maxhealths;
					variables.mathxyz0 = message.data.mathxyz0;
					variables.tao = message.data.tao;
					variables.tao_if = message.data.tao_if;
					variables.fabaolan = message.data.fabaolan;
					variables.jinjie = message.data.jinjie;
					variables.linqiizhi = message.data.linqiizhi;
					variables.linqiizhimax = message.data.linqiizhimax;
					variables.powertext = message.data.powertext;
					variables.linqiizhimaxsc = message.data.linqiizhimaxsc;
					variables.Hud_Open = message.data.Hud_Open;
					variables.xuiwei_health = message.data.xuiwei_health;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
