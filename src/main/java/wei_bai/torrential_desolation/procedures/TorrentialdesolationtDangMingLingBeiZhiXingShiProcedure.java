package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class TorrentialdesolationtDangMingLingBeiZhiXingShiProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure TorrentialdesolationtDangMingLingBeiZhiXingShi!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				TorrentialDesolationMod.LOGGER
						.warn("Failed to load dependency cmdparams for procedure TorrentialdesolationtDangMingLingBeiZhiXingShi!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("xuiwei") && (new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("set")) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new Object() {
					public String getText() {
						String param = (String) cmdparams.get("2");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText());
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.power = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("health") && (new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("set")) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new Object() {
					public String getText() {
						String param = (String) cmdparams.get("2");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()))));
		}
		if ((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("maxhealth") && (new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).equals("set")) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							("attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set " + (new Object() {
								public String getText() {
									String param = (String) cmdparams.get("2");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())));
				}
			}
		}
	}
}
