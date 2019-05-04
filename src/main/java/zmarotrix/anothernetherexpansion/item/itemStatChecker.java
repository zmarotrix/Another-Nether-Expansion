package zmarotrix.anothernetherexpansion.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class itemStatChecker extends Item {
	public itemStatChecker() {
		//this.setFull3D(); //renders as a tool rather than an Item in hand.
		this.setNoRepair();
		this.setMaxStackSize(1);
	}
	
	/**	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
	} **/
	
	

}
