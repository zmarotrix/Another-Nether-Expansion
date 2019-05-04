package zmarotrix.anothernetherexpansion.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class oreLonsdaleiteOre extends Block {

	public oreLonsdaleiteOre(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(0.4F);

	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return AnotherNetherExpansion.itemLonsdaleite;
	}
	
	//@override
	//public int quantityDropped(Random rand){here you can set how many whatever drops}
	
	/**	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(5));
	} **/
}
