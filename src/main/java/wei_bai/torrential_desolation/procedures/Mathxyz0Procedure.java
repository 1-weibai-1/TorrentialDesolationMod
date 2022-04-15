package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class Mathxyz0Procedure {
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
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure Mathxyz0!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (0 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 10) {
			{
				double _setval = 6;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (10 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 100) {
			{
				double _setval = 12;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (100 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 1000) {
			{
				double _setval = 18;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (1000 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 10000) {
			{
				double _setval = 24;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (10000 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 100000) {
			{
				double _setval = 30;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (100000 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 1000000) {
			{
				double _setval = 36;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (1000000 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 10000000) {
			{
				double _setval = 42;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (10000000 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 100000000) {
			{
				double _setval = 48;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (100000000 <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) > 1000000000) {
			{
				double _setval = 54;
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mathxyz0 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
