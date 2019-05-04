package zmarotrix.anothernetherexpansion;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class zmTools {
	
	public static void reg(Item thing, String name) {
		
		//if (thing.getUnlocalizedName() == null)
		thing.setUnlocalizedName(AnotherNetherExpansion.modid + ":" + name);
		thing.setTextureName(AnotherNetherExpansion.modid + ":" + name);
		thing.setCreativeTab(AnotherNetherExpansion.tabANE);
		GameRegistry.registerItem(thing, name);
	}
	
	public static void reg(Block thing, String name) {
		
		//if (thing.getUnlocalizedName() == null)
		thing.setUnlocalizedName(AnotherNetherExpansion.modid + ":" + name);
		if (thing.getItemIcon(1, 0) == null)
		thing.setTextureName(AnotherNetherExpansion.modid + ":" + name);
		thing.setCreativeTab(AnotherNetherExpansion.tabANE);
		GameRegistry.registerBlock(thing, name);
	}

}
