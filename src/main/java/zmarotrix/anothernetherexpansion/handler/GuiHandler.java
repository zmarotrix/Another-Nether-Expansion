package zmarotrix.anothernetherexpansion.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;
import zmarotrix.anothernetherexpansion.container.ContainerLonsdaleiteFurnace;
import zmarotrix.anothernetherexpansion.gui.GuiLonsdaleiteFurnace;
import zmarotrix.anothernetherexpansion.tileentity.TileEntityLonsdaleiteFurnace;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null) {
			switch(ID) {
			case AnotherNetherExpansion.guiIDlonsdaleiteFurnace:
				if(entity instanceof TileEntityLonsdaleiteFurnace) {
					return new ContainerLonsdaleiteFurnace(player.inventory, (TileEntityLonsdaleiteFurnace) entity);
				}
			
			
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null) {
			switch(ID) {
			case AnotherNetherExpansion.guiIDlonsdaleiteFurnace:
				if(entity instanceof TileEntityLonsdaleiteFurnace) {
					return new GuiLonsdaleiteFurnace(player.inventory, (TileEntityLonsdaleiteFurnace) entity);
				}
			
			
			}
		}
		return null;
	}
	

}
