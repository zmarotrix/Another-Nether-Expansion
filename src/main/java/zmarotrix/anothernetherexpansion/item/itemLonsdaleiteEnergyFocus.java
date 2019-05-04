package zmarotrix.anothernetherexpansion.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class itemLonsdaleiteEnergyFocus extends Item{
	
	public itemLonsdaleiteEnergyFocus(){
		this.setMaxStackSize(1);
		this.setMaxDurability(5);
		this.setNoRepair();
		this.setCreativeTab(AnotherNetherExpansion.tabANE);
	}
	
	/**	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
	} **/

}
