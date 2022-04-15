
package wei_bai.torrential_desolation.gui;

import wei_bai.torrential_desolation.TorrentialDesolationMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class BloodgasGUI1GuiWindow extends ContainerScreen<BloodgasGUI1Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = BloodgasGUI1Gui.guistate;

	public BloodgasGUI1GuiWindow(BloodgasGUI1Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 24, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 78, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 96, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 60, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 78, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 78, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 78, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 96, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 96, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 96, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + 101, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + 119, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + 137, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 132, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 150, this.guiTop + 159, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/arrow_1.png"));
		this.blit(ms, this.guiLeft + 89, this.guiTop + 33, 0, 0, 38, 21, 38, 21);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/plus.png"));
		this.blit(ms, this.guiLeft + 41, this.guiTop + 33, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 20, this.guiTop + 34, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 61, this.guiTop + 34, 0, 0, 19, 19, 19, 19);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("torrential_desolation:textures/lattice.png"));
		this.blit(ms, this.guiLeft + 140, this.guiTop + 34, 0, 0, 19, 19, 19, 19);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
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
		this.addButton(new Button(this.guiLeft + 73, this.guiTop + 77, 35, 20, new StringTextComponent("È·¶¨"), e -> {
			if (true) {
				TorrentialDesolationMod.PACKET_HANDLER.sendToServer(new BloodgasGUI1Gui.ButtonPressedMessage(0, x, y, z));
				BloodgasGUI1Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
