package de.se.common.gui.repairer;

import org.lwjgl.opengl.GL11;

import de.se.common.container.repairer.ContainerRepairer;
import de.se.common.lib.Reference;
import de.se.common.tiles.repairer.TileRepairer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GUIRepairer extends GuiContainer {

	public static final ResourceLocation gui = new ResourceLocation(Reference.MODID,"textures/gui/repairer.png");
	private TileRepairer machine;

	public GUIRepairer(InventoryPlayer inventoryplayer, World world, TileRepairer tile) {
		super(new ContainerRepairer(inventoryplayer,tile));
		this.machine = tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(gui);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
