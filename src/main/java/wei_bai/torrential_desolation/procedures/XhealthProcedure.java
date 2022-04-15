package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MainWindow;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.matrix.MatrixStack;

public class XhealthProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRenderGameOverlayPre(RenderGameOverlayEvent.Pre event) {
			Entity entity = Minecraft.getInstance().getRenderViewEntity();
			World world = entity.world;
			MatrixStack matrixStack = event.getMatrixStack();
			RenderGameOverlayEvent.ElementType elementType = event.getType();
			MainWindow mainWindow = event.getWindow();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			float partialTicks = event.getPartialTicks();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("matrixStack", matrixStack);
			dependencies.put("partialTicks", partialTicks);
			dependencies.put("mainWindow", mainWindow);
			dependencies.put("elementType", elementType);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("elementType") == null) {
			if (!dependencies.containsKey("elementType"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency elementType for procedure Xhealth!");
			return;
		}
		RenderGameOverlayEvent.ElementType elementType = (RenderGameOverlayEvent.ElementType) dependencies.get("elementType");
		RenderGameOverlayEvent.Pre hud = (RenderGameOverlayEvent.Pre) dependencies.get("event");
		if (hud.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
	}
}
