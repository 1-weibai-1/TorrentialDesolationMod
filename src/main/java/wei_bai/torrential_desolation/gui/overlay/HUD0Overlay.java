
package wei_bai.torrential_desolation.gui.overlay;

import wei_bai.torrential_desolation.TorrentialDesolationModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class HUD0Overlay {

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			/*举例设置整数healths = 变量healths，就这样写
			*int healths = (int) entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
			*.orElse(new TorrentialDesolationModVariables.PlayerVariables()).healths;
			*/

			//设置整数healths = 变量healths
			int healths = (int) entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).healths;

			//设置maxhealths = 变量maxhealths
			int maxhealths = (int) entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).maxhealths;
			//设置manas = 变量manas
			double mathxyz0 = entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).mathxyz0;
			//设置power = 变量power
			double power = entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).power;
			String powertext = entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).powertext;
			double linqizhi = entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).linqiizhi;
			double linqizhimax = entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables()).linqiizhimax;

			double jinjie = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TorrentialDesolationModVariables.PlayerVariables())).jinjie);

			
			//设置healthpng = healths/maxhealths
			double healthpng = healths / maxhealths;
			//设置linqizhipng = linqizhi/linqizhimax
			double linqizhipng = linqizhi / linqizhimax;
			//设置数字self_cultivationpng = power/jinjie
			double self_cultivationpng = power / jinjie;

			//设置数字healthpngs = healthpng*183
			int healthpngs = (int) (healthpng * 183);	
			
			//设置数字self_cultivationpngs = self_cultivationpng*146
			int self_cultivationpngs = (int) (self_cultivationpng * 146);

			//设置数字powerpngs = linqizhipng*146
			int powerpngs = (int) (linqizhipng * 146);

			int cs = (int) (127 - mathxyz0);
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (true) {
				/*举例在界面上显示healths.png在坐标(50,6)，大小(183,20)，就这样写
				*Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/healths.png"));
				*Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 50, 6, 0, 0, *183, 20, 183, 20);
				*/


				//在界面上显示healths.png在坐标(50,6)，大小(183,20)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/healths.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 50, 6, 0, 0, 183, 20, 183, 20);
				
				//真
				//在界面上显示health.png在坐标(50,6)，大小(healthpngs,20)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/health.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 50, 6, 0, 0, healthpngs, 20, 183, 20);

				//在界面上显示self_cultivations.png在坐标(51,31)，大小(146,17)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/self_cultivations.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 51, 31, 0, 0, 146, 17, 146, 17);

				//真
				//在界面上显示self_cultivation.png在坐标(51,31)，大小(self_cultivationpngs,20)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/self_cultivation.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 51, 31, 0, 0, self_cultivationpngs, 17, self_cultivationpngs, 17);



				//在界面上显示powers.png在坐标(51,50)，大小(146,7)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/powers.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 51, 50, 0, 0, 146, 7, 146, 7);

				//真
				//在界面上显示power.png在坐标(51,50)，大小(powerpngs,7)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/power.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 51, 50, 0, 0, powerpngs, 7, powerpngs, 7);

				//在界面上显示power_level.png在坐标(51,50)，大小(146,7)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/power_level.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 51, 50, 0, 0, 146, 7, 146, 7);

				//在界面上显示main_hud.png在坐标(5,6)，大小(245,76)
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/main_hud.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 5, 6, 0, 0, 245, 76, 245, 76);

				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
				"" + ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TorrentialDesolationModVariables.PlayerVariables())).tao) + "", 13, 13, -3407872);

				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new TorrentialDesolationModVariables.PlayerVariables())).self_cultivation) + "",
						10, 36, -16777216);

				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"" + ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TorrentialDesolationModVariables.PlayerVariables())).health) + "",
								cs, 14, -16777216);

				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"/" + ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TorrentialDesolationModVariables.PlayerVariables())).jinjie) + "",
								120, 36, -16777216);

				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"" + powertext + "",
								73, 36, -16777216);

				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"" + linqizhi + "" ,
								73, 50, -16777216);

				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"/" + linqizhimax + "" ,
								120, 50, -16777216);

				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"/" + ((entity.getCapability(TorrentialDesolationModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new TorrentialDesolationModVariables.PlayerVariables())).maxhealth) + "",
								139, 14, -16777216);

								
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
