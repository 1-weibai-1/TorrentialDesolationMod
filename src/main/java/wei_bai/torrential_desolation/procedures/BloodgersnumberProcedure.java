package wei_bai.torrential_desolation.procedures;

import wei_bai.torrential_desolation.item.BloodgasItem;
import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.Blocks;

import java.util.Map;
import java.util.HashMap;

public class BloodgersnumberProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency entity for procedure Bloodgersnumber!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				TorrentialDesolationMod.LOGGER.warn("Failed to load dependency guistate for procedure Bloodgersnumber!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
				&& new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:bloodgers");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()) * 10 < ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)) {
			if (entity instanceof LivingEntity) {
				ItemStack _setstack = new ItemStack(BloodgasItem.block);
				_setstack.setCount((int) 1);
				((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
				if (entity instanceof ServerPlayerEntity)
					((ServerPlayerEntity) entity).inventory.markDirty();
			}
			((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
					.putDouble("bloodgas", new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new Object() {
						public String getText() {
							TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:bloodgers");
							if (_tf != null) {
								return _tf.getText();
							}
							return "";
						}
					}.getText()));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - new Object() {
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
								TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:bloodgers");
								if (_tf != null) {
									return _tf.getText();
								}
								return "";
							}
						}.getText()))) * 10));
		} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Blocks.AIR
				.asItem() && ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:bloodgers");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()) * 10) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 0);
		}
	}
}
