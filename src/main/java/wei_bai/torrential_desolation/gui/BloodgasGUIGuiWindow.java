
package wei_bai.torrential_desolation.gui;

import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BloodgasGUIGuiWindow extends ContainerScreen<BloodgasGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BloodgasGUIGui.guistate;
	TextFieldWidget bloodgers;

	public BloodgasGUIGuiWindow(BloodgasGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 0;
		this.ySize = 0;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
		bloodgers.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (bloodgers.isFocused())
			return bloodgers.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		bloodgers.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "\u4E00\u70B9\u8840\u6C14\u503C=\u5341\u70B9\u751F\u547D\u503C", -37, -26, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		bloodgers = new TextFieldWidget(this.font, this.guiLeft + -70, this.guiTop + -54, 140, 20, new StringTextComponent("number")) {
			{
				setSuggestion("number");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("number");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("number");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:bloodgers", bloodgers);
		bloodgers.setMaxStringLength(32767);
		this.children.add(this.bloodgers);
		this.addButton(new Button(this.guiLeft + -14, this.guiTop + -6, 35, 20, new StringTextComponent("È·¶¨"), e -> {
			if (true) {
				TorrentialDesolationMod.PACKET_HANDLER.sendToServer(new BloodgasGUIGui.ButtonPressedMessage(0, x, y, z));
				BloodgasGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 74, this.guiTop + -54, 56, 20, new StringTextComponent("¡ª¡ª¡ª¡ª¡·"), e -> {
			if (true) {
				TorrentialDesolationMod.PACKET_HANDLER.sendToServer(new BloodgasGUIGui.ButtonPressedMessage(1, x, y, z));
				BloodgasGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}
}
