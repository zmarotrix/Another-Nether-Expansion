package zmarotrix.anothernetherexpansion.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;
import zmarotrix.anothernetherexpansion.container.ContainerLonsdaleiteFurnace;
import zmarotrix.anothernetherexpansion.tileentity.TileEntityLonsdaleiteFurnace;

public class GuiLonsdaleiteFurnace extends GuiContainer{
	
	public static final ResourceLocation bkg = new ResourceLocation(AnotherNetherExpansion.modid + ":" +  "textures/gui/GuiLonsdaleiteFurnace.png");
	public TileEntityLonsdaleiteFurnace TELFurnace;
	public int width = 176;
	public int height = 166;

	public GuiLonsdaleiteFurnace(InventoryPlayer inv, TileEntityLonsdaleiteFurnace entity) {
		
		super(new ContainerLonsdaleiteFurnace(inv, entity));
		this.TELFurnace = entity;
		
		this.xSize = width;
		this.ySize = height;
	}
	
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = "Lonsdaleite Furnace";
		this.fontRendererObj.drawString(name, (this.xSize/2) - (this.fontRendererObj.getStringWidth(name)) / 2, 5, 13158550);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8 , this.ySize - 96 + 2, 13158550);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bkg);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0 , xSize, ySize);
		
	}
	
	
	
	
	
	
	
	

}
