package zmarotrix.anothernetherexpansion.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class ANEBlocks extends Block{
	
	public ANEBlocks(Material material, float hardness) {
		super(material);
		this.setHardness(hardness);
	}
	public ANEBlocks(Material material, float hardness, boolean isResistant) {
		super(material);
		this.setHardness(hardness);
		this.setResistance(Blocks.obsidian.getExplosionResistance(null));
	}
	public ANEBlocks(Material material) {
		super(material);
		this.setHardness(1.0f);
	}
	public ANEBlocks(Material material, float hardness, String HarvestTool, int Harvestability) {
		super(material);
		this.setHardness(hardness);
		this.setHarvestLevel(HarvestTool, Harvestability);
	}
	/**	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
	} **/

}
