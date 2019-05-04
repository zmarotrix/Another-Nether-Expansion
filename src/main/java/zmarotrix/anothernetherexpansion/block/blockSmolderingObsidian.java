package zmarotrix.anothernetherexpansion.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class blockSmolderingObsidian extends Block {

	public blockSmolderingObsidian(Material materialIn) {
		super(materialIn);
		this.setHardness(10.0F);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.2f);
		this.setResistance(50.0f);
		
		
		
	}

}
