package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class HUDset1Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure HUDset1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 320) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(320));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (320 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 470) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(470));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (470 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 720) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(720));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (720 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1120) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(1120));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (1120 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1720) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(1720));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (1720 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2420) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(2420));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (2420 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3220) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(3220));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (3220 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4120) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(4120));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (4120 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 5120) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(5120));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (5120 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 15220) {
			{
				String _setval = (new java.text.DecimalFormat("#").format(15220));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jinjie = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			double _setval = ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power);
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.linqiizhimax = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).linqiizhi > (entity
						.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).linqiizhimax) {
			{
				double _setval = ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).linqiizhimax);
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linqiizhi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
