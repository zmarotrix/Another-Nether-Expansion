package zmarotrix.anothernetherexpansion.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class itemSword extends ItemSword {

	public itemSword(ToolMaterial material) {
		super(material);
		
	}
	
	/**	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
	} **/

}
