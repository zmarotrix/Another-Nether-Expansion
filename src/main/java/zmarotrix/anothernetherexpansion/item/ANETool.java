package zmarotrix.anothernetherexpansion.item;

import java.util.Objects;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;
import zmarotrix.anothernetherexpansion.zmTools;

public class ANETool {
	
	public static Item make(ToolMaterial material, int type) {
		
		switch(type) {
			case 0 : return new itemShovel(material); 
			case 1 : return new itemSword(material); 
			case 2 : return new itemAxe(material); 
			case 3 : return new itemPickaxe(material); 
			case 4 : return new itemHoe(material);}
		return null;
			
	}
}
