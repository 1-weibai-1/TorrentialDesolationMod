package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class XuilianSongKaiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure XuilianSongKai!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("xuiwei", 0);
	}
}
