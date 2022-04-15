package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class HUD_openProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure HUD_open!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).Hud_Open == 0) {
			return true;
		} else if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).Hud_Open == 1) {
			return false;
		}
		return true;
	}
}
