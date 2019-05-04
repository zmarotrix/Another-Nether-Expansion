package zmarotrix.anothernetherexpansion.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class BlockLonsdaleite extends Block{
	
	public BlockLonsdaleite(Material material) {
		super(material);
		this.setHardness(5.0F);
	}
	
	/**	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
	} **/

}
