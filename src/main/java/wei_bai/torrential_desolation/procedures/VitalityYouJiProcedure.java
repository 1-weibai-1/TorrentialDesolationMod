package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import java.util.Map;

public class VitalityYouJiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure VitalityYouJi!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency itemstack for procedure VitalityYouJi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						("attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set "
								+ new java.text.DecimalFormat("#")
										.format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new TorrentialDesolationModVariables.PlayerVariables())).maxhealths + 10)));
			}
		}
		(itemstack).shrink((int) 1);
	}
}
