package zmarotrix.anothernetherexpansion.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class blockFyerstoneBrick extends Block {

	public blockFyerstoneBrick(Material materialIn) {
		
		super(materialIn);
		this.setHardness(7.0F);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.4f);
		this.setResistance(50.0f);
		//this.isTranslucent();
	}

}
