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

public class HUD0setProcedure {
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
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure HUD0set!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			String _setval = ("" + ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.health = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = ("" + new java.text.DecimalFormat("#")
					.format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power));
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.powertext = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = ("" + ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maxhealth = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		
		{
			String _setval = (new java.text.DecimalFormat("#")
					.format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TorrentialDesolationModVariables.PlayerVariables())).linqiizhimax));
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.linqiizhimaxsc = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.DecimalFormat("#").format((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.healths = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(new java.text.DecimalFormat("#").format((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
			entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maxhealths = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		/*举个例子 如果power>=0且power<10，则self_cultivation为凡人，那么就这么写：
		*if (0 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
		*		.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
		*		&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
		*				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 10) {
		*	{
		*		String _setval = "\u51E1\u4EBA";
		*		entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
		*			capability.self_cultivation = _setval;
		*			capability.syncPlayerVariables(entity);
		*		});
		*	}
		*}
		*/

		//如果变量power介于0~320之间,则最大灵气值为power/2
		if (0 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 320) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power / 2));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linqiizhimax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//如果变量power介于320~470之间,则最大灵气值为power/2
		if (320 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 470) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power / 2));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linqiizhimax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//如果变量power介于470~720之间,则最大灵气值为power/2
		if (470 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 720) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power / 2));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linqiizhimax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//如果变量power介于720~1120之间,则最大灵气值为power/2
		if (720 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1120) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power / 2));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linqiizhimax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//如果变量power介于1120~1720之间,则最大灵气值为power/2
		if (1120 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1720) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new java.text.DecimalFormat("#").format((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power / 2));
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.linqiizhimax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//=============================《下面就是境界的写法》=============================
		/*举例在0《=灵气值《10时，设置境界名称为“凡人”就这样写：
		*if (0 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 10) {
			{
				String _setval = "\u51E1\u4EBA";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		*/
		/*
		下面是境界：
		【凡人
		，明劲
		，暗劲
		，化劲
		，丹劲
		，罡劲
		，宗师】这是练气一品下的境界。
		上面的境界算法跟下面的不一样，因为这里的境界的灵气值间隔之间是一个间隔加10，如第一个0~10，第二个10~20，第三个20~40，第四个40~70，第五个70~110。
		上面的境界的间隔是从0~220，但220是不取的
		下面的境界的间隔是从220~+∞，但220是取的
		下面的境界算法是：一个大境界，其中有10个小境界。
		小境界的间隔是按照[练气(10)]练气后面的10
		第1个小境界220~230，第2个小境界230~240,....,第8个小境界290~300，第9个小境界300~320，第10个小境界320。
		【练气(10)
		，筑基(15)
		，金丹(25)
		，元婴(40)
		，化神(60)
		，炼虚(70)
		，大乘(80)
		，地仙(90)
		，天仙(100)】
		这里的境界名称用法是这样的：练气为一个大境界，练气一品为一个小境界.
		【真仙(101)
		，玄仙(102)
		，金仙(105)
		，太乙真仙(106)
		，太乙玄仙(107)
		，太乙金仙(110)
		，大罗真仙(150)
		，大罗玄仙(160)
		，大罗金仙(180)
		，准圣/半步混元大罗金仙(190)
		，圣人/混元大罗金仙(200)
		，天道级圣人/混元无极大罗金仙(250)
		，大道圣人/混元无极太上大罗仙(500)】
		*/

		/*举例
		//这为一个小境界8练气10
		//在290《=灵气值《300时，设置境界名称为“练气八品”
		if (290 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 300) {
			{
				String _setval = "\u7EC3\u6C14\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9练气10
		//在300《=灵气值《320时，设置境界名称为“练气九品”
		if (300 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 320) {
			{
				String _setval = "\u7EC3\u6C14\u4E5D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10练气10
		//在灵气值=320时，设置境界名称为“练气十品”
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power == 320) {
			{
				String _setval = "\u7EC3\u6C14\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		*/

		//在0《=灵气值《10时，设置境界名称为“凡人”
		if (0 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 10) {
			{
				String _setval = "\u51E1\u4EBA";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//在10《=灵气值《20时，设置境界名称为“明劲”
		if (10 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 20) {
			{
				String _setval = "\u660E\u52B2";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		
		//在20《=灵气值《40时，设置境界名称为“暗劲”
		if (20 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 40) {
			{
				String _setval = "\u6697\u52B2";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//在40《=灵气值《70时，设置境界名称为“化劲”
		if (40 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 70) {
			{
				String _setval = "\u5316\u52B2";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//在70《=灵气值《110时，设置境界名称为“丹劲”
		if (70 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 110) {
			{
				String _setval = "\u4E39\u52B2";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//在110《=灵气值《160时，设置境界名称为“罡劲”
		if (110 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 160) {
			{
				String _setval = "\u7F61\u52B2";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//在160《=灵气值《220时，设置境界名称为“宗师”
		if (160 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 220) {
			{
				String _setval = "\u5B97\u5E08";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}

		//这是下面的境界
		//这为一个大境界1练气10
		//在220《=灵气值《230时，设置境界名称为“练气一品”
		if (220 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 230) {
			{
				String _setval = "\u7EC3\u6C14\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2练气10
		//在230《=灵气值《240时，设置境界名称为“练气二品”
		if (230 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 240) {
			{
				String _setval = "\u7EC3\u6C14\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3练气10
		//在240《=灵气值《250时，设置境界名称为“练气三品”
		if (240 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 250) {
			{
				String _setval = "\u7EC3\u6C14\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4练气10
		//在250《=灵气值《260时，设置境界名称为“练气四品”.
		if (250 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 260) {
			{
				String _setval = "\u7EC3\u6C14\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5练气10
		//在260《=灵气值《270时，设置境界名称为“练气五品”
		if (260 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 270) {
			{
				String _setval = "\u7EC3\u6C14\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6练气10
		//在270《=灵气值《280时，设置境界名称为“练气六品”
		if (270 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 280) {
			{
				String _setval = "\u7EC3\u6C14\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7练气10
		//在280《=灵气值《290时，设置境界名称为“练气七品”
		if (280 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 290) {
			{
				String _setval = "\u7EC3\u6C14\u4E03\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8练气10
		//在290《=灵气值《300时，设置境界名称为“练气八品”
		if (290 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 300) {
			{
				String _setval = "\u7EC3\u6C14\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9练气10
		//在300《=灵气值《320时，设置境界名称为“练气九品”
		if (300 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 320) {
			{
				String _setval = "\u7EC3\u6C14\u4E5D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10练气10
		//在灵气值=320时，设置境界名称为“练气十品”
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power == 320) {
			{
				String _setval = "\u7EC3\u6C14\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个大境界1筑基15
		//在320《=灵气值《335时，设置境界名称为“筑基一品”
		if (320 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 335) {
			{
				String _setval = "\u7B51\u57FA\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2筑基15
		//在335《=灵气值《350时，设置境界名称为“筑基二品”
		if (335 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 350) {
			{
				String _setval = "\u7B51\u57FA\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3筑基15
		//在350《=灵气值《365时，设置境界名称为“筑基三品”
		if (350 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 365) {
			{
				String _setval = "\u7B51\u57FA\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4筑基15
		//在365《=灵气值《380时，设置境界名称为“筑基四品”
		if (365 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 380) {
			{
				String _setval = "\u7B51\u57FA\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5筑基15
		//在380《=灵气值《395时，设置境界名称为“筑基五品”
		if (380 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 395) {
			{
				String _setval = "\u7B51\u57FA\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6筑基15
		//在395《=灵气值《410时，设置境界名称为“筑基六品”
		if (395 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 410) {
			{
				String _setval = "\u7B51\u57FA\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7筑基15
		//在410《=灵气值《425时，设置境界名称为“筑基七品”
		if (410 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 425) {
			{
				String _setval = "\u7B51\u57FA\u4E03\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8筑基15
		//在425《=灵气值《440时，设置境界名称为“筑基八品”
		if (425 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 440) {
			{
				String _setval = "\u7B51\u57FA\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9筑基15
		//在440《=灵气值《470时，设置境界名称为“筑基九品”
		if (440 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 470) {
			{
				String _setval = "\u7B51\u57FA\u4E5D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10筑基15
		//在灵气值=470时，设置境界名称为“筑基十品”
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power == 470) {
			{
				String _setval = "\u7B51\u57FA\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个大境界1金丹25
		//在470《灵气值《495时，设置境界名称为“金丹一品”
		if (470 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 495) {
			{
				String _setval = "\u91D1\u4E39\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2金丹25
		//在495《灵气值《520时，设置境界名称为“金丹二品”
		if (495 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 520) {
			{
				String _setval = "\u91D1\u4E39\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3金丹25
		//在520《灵气值《545时，设置境界名称为“金丹三品”
		if (520 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 545) {
			{
				String _setval = "\u91D1\u4E39\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4金丹25
		//在545《灵气值《570时，设置境界名称为“金丹四品”
		if (545 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 570) {
			{
				String _setval = "\u91D1\u4E39\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5金丹25
		//在570《灵气值《595时，设置境界名称为“金丹五品”
		if (570 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 595) {
			{
				String _setval = "\u91D1\u4E39\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6金丹25
		//在595《灵气值《620时，设置境界名称为“金丹六品”
		if (595 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 620) {
			{
				String _setval = "\u91D1\u4E39\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7金丹25
		//在620《灵气值《645时，设置境界名称为“金丹七品”
		if (620 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 645) {
			{
				String _setval = "\u91D1\u4E39\u4E03\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8金丹25
		//在645《灵气值《670时，设置境界名称为“金丹八品”
		if (645 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 670) {
			{
				String _setval = "\u91D1\u4E39\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9金丹25
		//在670《灵气值《720时，设置境界名称为“金丹九品”
		if (670 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 720) {
			{
				String _setval = "\u91D1\u4E39\u4E5D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10金丹25
		//在灵气值=720时，设置境界名称为“金丹十品”
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power == 720) {
			{
				String _setval = "\u91D1\u4E39\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个大境界1元婴40
		//在720《灵气值《760时，设置境界名称为“元婴一品”
		if (720 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 760) {
			{
				String _setval = "\u5143\u5A74\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2元婴40
		//在760《灵气值《800时，设置境界名称为“元婴二品”
		if (760 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 800) {
			{
				String _setval = "\u5143\u5A74\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3元婴40
		//在800《灵气值《840时，设置境界名称为“元婴三品”
		if (800 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 840) {
			{
				String _setval = "\u5143\u5A74\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4元婴40
		//在840《灵气值《880时，设置境界名称为“元婴四品”
		if (840 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 880) {
			{
				String _setval = "\u5143\u5A74\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5元婴40
		//在880《灵气值《920时，设置境界名称为“元婴五品”
		if (880 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 920) {
			{
				String _setval = "\u5143\u5A74\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6元婴40
		//在920《灵气值《960时，设置境界名称为“元婴六品”
		if (920 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 960) {
			{
				String _setval = "\u5143\u5A74\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7元婴40
		//在960《灵气值《1000时，设置境界名称为“元婴七品”
		if (960 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1000) {
			{
				String _setval = "\u5143\u5A74\u4E03\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8元婴40
		//在1000《灵气值《1040时，设置境界名称为“元婴八品”
		if (1000 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1040) {
			{
				String _setval = "\u5143\u5A74\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9元婴40
		//在1040《灵气值《1120时，设置境界名称为“元婴九品”
		if (1040 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1120) {
			{
				String _setval = "\u5143\u5A74\u4E5D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10元婴40
		//在灵气值=1120时，设置境界名称为“元婴十品”
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power == 1120) {
			{
				String _setval = "\u5143\u5A74\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个大境界1化神60
		//在1120《灵气值《1180时，设置境界名称为“化神一品”
		if (1120 < (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1180) {
			{
				String _setval = "\u5316\u795E\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2化神60
		//在1180《=灵气值《1240时，设置境界名称为“化神二品”
		if (1180 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1240) {
			{
				String _setval = "\u5316\u795E\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3化神60
		//在1240《=灵气值《1300时，设置境界名称为“化神三品”
		if (1240 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1300) {
			{
				String _setval = "\u5316\u795E\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4化神60
		//在1300《=灵气值《1360时，设置境界名称为“化神四品”
		if (1300 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1360) {
			{
				String _setval = "\u5316\u795E\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5化神60
		//在1360《=灵气值《1420时，设置境界名称为“化神五品”
		if (1360 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1420) {
			{
				String _setval = "\u5316\u795E\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6化神60
		//在1420《=灵气值《1480时，设置境界名称为“化神六品”
		if (1420 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1480) {
			{
				String _setval = "\u5316\u795E\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7化神60
		//在1480《=灵气值《1540时，设置境界名称为“化神七品”
		if (1480 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1540) {
			{
				String _setval = "\u5316\u795E\u4E03\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8化神60
		//在1540《=灵气值《1600时，设置境界名称为“化神八品”
		if (1540 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1600) {
			{
				String _setval = "\u5316\u795E\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9化神60
		//在1600《=灵气值《1720时，设置境界名称为“化神九品”
		if (1600 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1720) {
			{
				String _setval = "\u5316\u795E\u4E5D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10化神60
		//在灵气值=1720时，设置境界名称为“化神十品”
		if ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power == 1720) {
			{
				String _setval = "\u5316\u795E\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界1炼虚70
		//在1720《灵气值《1790时，设置境界名称为“炼虚一品”
		if (1720 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1790) {
			{
				String _setval = "\u70bc\u865a\u4e00\u54c1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2炼虚70
		//在1790《=灵气值《1860时，设置境界名称为“炼虚二品”
		if (1790 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1860) {
			{
				String _setval = "\u70bc\u865a\u4e8c\u54c1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3炼虚70
		//在1860《=灵气值《1930时，设置境界名称为“炼虚三品”
		if (1860 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 1930) {
			{
				String _setval = "\u70bc\u865a\u4e09\u54c1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4炼虚70
		//在1930《=灵气值《2000时，设置境界名称为“炼虚四品”
		if (1930 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2000) {
			{
				String _setval = "\u70bc\u865a\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5炼虚70
		//在2000《=灵气值《2070时，设置境界名称为“炼虚五品”
		if (2000 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2070) {
			{
				String _setval = "\u70bc\u865a\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6炼虚70
		//在2070《=灵气值《2140时，设置境界名称为“炼虚六品”
		if (2070 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2140) {
			{
				String _setval = "\u70bc\u865a\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7炼虚70
		//在2140《=灵气值《2210时，设置境界名称为“炼虚七品”
		if (2140 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2210) {
			{
				String _setval = "\u70bc\u865a\u4E03\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8炼虚70
		//在2210《=灵气值《2280时，设置境界名称为“炼虚八品”
		if (2210 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2280) {
			{
				String _setval = "\u70bc\u865a\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9炼虚70
		//在2280《=灵气值《2420时，设置境界名称为“炼虚九品”
		if (2280 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2420) {
			{
				String _setval = "\u70bc\u865a\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10炼虚70
		//在灵气值=2420时，设置境界名称为“炼虚十品”
		if (2420 == (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power) {
			{
				String _setval = "\u70bc\u865a\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界1大乘80
		//在2420《=灵气值《2500时，设置境界名称为“大乘一品”
		if (2420 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2500) {
			{
				String _setval = "\u5927\u4e58\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2大乘80
		//在2500《=灵气值《2580时，设置境界名称为“大乘二品”
		if (2500 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2580) {
			{
				String _setval = "\u5927\u4e58\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3大乘80
		//在2580《=灵气值《2660时，设置境界名称为“大乘三品”
		if (2580 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2660) {
			{
				String _setval = "\u5927\u4e58\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4大乘80
		//在2660《=灵气值《2740时，设置境界名称为“大乘四品”
		if (2660 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2740) {
			{
				String _setval = "\u5927\u4e58\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5大乘80
		//在2740《=灵气值《2820时，设置境界名称为“大乘五品”
		if (2740 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2820) {
			{
				String _setval = "\u5927\u4e58\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6大乘80
		//在2820《=灵气值《2900时，设置境界名称为“大乘六品”
		if (2820 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2900) {
			{
				String _setval = "\u5927\u4e58\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7大乘80
		//在2900《=灵气值《2980时，设置境界名称为“大乘七品”
		if (2900 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 2980) {
			{
				String _setval = "\u5927\u4e58\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8大乘80
		//在2980《=灵气值《3060时，设置境界名称为“大乘八品”
		if (2980 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3060) {
			{
				String _setval = "\u5927\u4e58\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9大乘80*2
		//在3060《=灵气值《3220时，设置境界名称为“大乘九品”
		if (3060 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3220) {
			{
				String _setval = "\u5927\u4e58\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10大乘
		//在灵气值=3220时，设置境界名称为“大乘十品”
		if (3220 == (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power) {
			{
				String _setval = "\u5927\u4e58\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界1地仙90
		//在3220《=灵气值《3310时，设置境界名称为“地仙一品”
		if (3220 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3310) {
			{
				String _setval = "\u5730\u4ed9\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2地仙90
		//在3310《=灵气值《3400时，设置境界名称为“地仙二品”
		if (3310 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3400) {
			{
				String _setval = "\u5730\u4ed9\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3地仙90
		//在3400《=灵气值《3490时，设置境界名称为“地仙三品”
		if (3400 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3490) {
			{
				String _setval = "\u5730\u4ed9\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4地仙90
		//在3490《=灵气值《3580时，设置境界名称为“地仙四品”
		if (3490 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3580) {
			{
				String _setval = "\u5730\u4ed9\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5地仙90
		//在3580《=灵气值《3670时，设置境界名称为“地仙五品”
		if (3580 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3670) {
			{
				String _setval = "\u5730\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6地仙90
		//在3670《=灵气值《3760时，设置境界名称为“地仙六品”
		if (3670 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3760) {
			{
				String _setval = "\u5730\u4ed9\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7地仙90
		//在3760《=灵气值《3850时，设置境界名称为“地仙七品”
		if (3760 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3850) {
			{
				String _setval = "\u5730\u4ed9\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8地仙90
		//在3850《=灵气值《3940时，设置境界名称为“地仙八品”
		if (3850 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 3940) {
			{
				String _setval = "\u5730\u4ed9\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9地仙90*2
		//在3940《=灵气值《4120时，设置境界名称为“地仙九品”
		if (3940 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4120) {
			{
				String _setval = "\u5730\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10地仙
		//在灵气值=4120时，设置境界名称为“地仙十品”
		if (4120 == (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power) {
			{
				String _setval = "\u5730\u4ed9\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个大境界1天仙100
		//在4120《=灵气值《4220时，设置境界名称为“天仙一品”
		if (4120 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4220) {
			{
				String _setval = "\u5929\u4ed9\u4E00\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2天仙100
		//在4220《=灵气值《4320时，设置境界名称为“天仙二品”
		if (4220 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4320) {
			{
				String _setval = "\u5929\u4ed9\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3天仙100
		//在4320《=灵气值《4420时，设置境界名称为“天仙三品”
		if (4320 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4420) {
			{
				String _setval = "\u5929\u4ed9\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4天仙100
		//在4420《=灵气值《4520时，设置境界名称为“天仙四品”
		if (4420 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4520) {
			{
				String _setval = "\u5929\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5天仙100
		//在4520《=灵气值《4620时，设置境界名称为“天仙五品”
		if (4520 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4620) {
			{
				String _setval = "\u5929\u4ed9\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6天仙100
		//在4620《=灵气值《4720时，设置境界名称为“天仙六品”
		if (4620 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4720) {
			{
				String _setval = "\u5929\u4ed9\u516B\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7天仙100
		//在4720《=灵气值《4820时，设置境界名称为“天仙七品”
		if (4720 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4820) {
			{
				String _setval = "\u5929\u4ed9\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8天仙100
		//在4820《=灵气值《4920时，设置境界名称为“天仙八品”
		if (4820 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 4920) {
			{
				String _setval = "\u5929\u4ed9\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9天仙100*2
		//在4920《=灵气值《5120时，设置境界名称为“天仙九品”
		if (4920 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 5120) {
			{
				String _setval = "\u5929\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10天仙
		//在灵气值=5120时，设置境界名称为“天仙十品”
		if (5120 == (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power) {
			{
				String _setval = "\u5929\u4ed9\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界1真仙1010
		//在5120《=灵气值《6130时，设置境界名称为“真仙一品”
		if (5120 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 6130) {
			{
				String _setval = "\u771f\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界2真仙1010
		//在6130《=灵气值《7140时，设置境界名称为“真仙二品”
		if (6130 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 7140) {
			{
				String _setval = "\u771f\u4ed9\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界3真仙1010
		//在7140《=灵气值《8150时，设置境界名称为“真仙三品”
		if (7140 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 8150) {
			{
				String _setval = "\u771f\u4ed9\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界4真仙1010
		//在8150《=灵气值《9160时，设置境界名称为“真仙四品”
		if (8150 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 9160) {
			{
				String _setval = "\u771f\u4ed9\u4E8C\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界5真仙1010
		//在9160《=灵气值《10170时，设置境界名称为“真仙五品”
		if (9160 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 10170) {
			{
				String _setval = "\u771f\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界6真仙1010
		//在10170《=灵气值《11180时，设置境界名称为“真仙六品”
		if (10170 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 11180) {
			{
				String _setval = "\u771f\u4ed9\u516D\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界7真仙1010
		//在11180《=灵气值《12190时，设置境界名称为“真仙七品”
		if (11180 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 12190) {
			{
				String _setval = "\u771f\u4ed9\u4E09\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界8真仙1010
		//在12190《=灵气值《13200时，设置境界名称为“真仙八品”
		if (12190 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 13200) {
			{
				String _setval = "\u771f\u4ed9\u56DB\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界9真仙1010*2
		//在13200《=灵气值《15220时，设置境界名称为“真仙九品”
		if (13200 <= (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power
				&& (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power < 15220) {
			{
				String _setval = "\u771f\u4ed9\u4E94\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		//这为一个小境界10真仙
		//在灵气值=15220时，设置境界名称为“真仙十品”
		if (15220 == (entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TorrentialDesolationModVariables.PlayerVariables())).power) {
			{
				String _setval = "\u771f\u4ed9\u5341\u54C1";
				entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.self_cultivation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
