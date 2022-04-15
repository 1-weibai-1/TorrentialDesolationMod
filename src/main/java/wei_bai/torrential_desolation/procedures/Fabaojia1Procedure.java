package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class Fabaojia1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure Fabaojia1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables())).fabaolan + 1);
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.fabaolan = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
