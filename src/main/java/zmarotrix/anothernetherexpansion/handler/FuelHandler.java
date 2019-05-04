package zmarotrix.anothernetherexpansion.handler;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == AnotherNetherExpansion.itemLonsdaleite) return 3200;
		if (fuel.getItem() == AnotherNetherExpansion.itemLonsdaleiteNugget) return 3200/9;
		if (fuel.getItem() == AnotherNetherExpansion.itemFyrestoneShard) return 6400/4;
		if (fuel.getItem() == AnotherNetherExpansion.itemFyrestoneIngot) return 6400;
		return 0;
	}
}
