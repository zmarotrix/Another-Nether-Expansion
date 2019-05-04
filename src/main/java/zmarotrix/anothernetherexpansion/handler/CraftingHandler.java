package zmarotrix.anothernetherexpansion.handler;

import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class CraftingHandler {
	
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		for(int i=2;i<event.craftMatrix.getSizeInventory(); i++)
		{
			if (event.craftMatrix.getStackInSlot(i) != null)
			{
				
				
				
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if (item0 != null && item0.getItem() == AnotherNetherExpansion.itemLonsdaleiteEnergyFocus) 
				{
					ItemStack k = new ItemStack(AnotherNetherExpansion.itemLonsdaleiteEnergyFocus, 2, (item0.getMetadata() +1));
					
					if (k.getMetadata() >= k.getMaxDurability()) 
					{
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i,k);
				}
				
				
				
				
				
				
			}	
		}
	}
	

}
