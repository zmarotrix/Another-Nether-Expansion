package zmarotrix.anothernetherexpansion.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import zmarotrix.anothernetherexpansion.tileentity.TileEntityLonsdaleiteFurnace;

public class ContainerLonsdaleiteFurnace extends Container{
	
	private TileEntityLonsdaleiteFurnace TELFurnace;
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	
	public ContainerLonsdaleiteFurnace(InventoryPlayer inventory, TileEntityLonsdaleiteFurnace entity) {
		this.TELFurnace = entity;
		this.addSlotToContainer(new Slot(entity, 0, 56, 17)); //input
		this.addSlotToContainer(new Slot(entity, 1, 56, 53));//fuel
		this.addSlotToContainer(new SlotFurnace(inventory.player, entity, 2, 116, 35));//output
		
		
        for (int i = 0; i < 3; ++i)// y axis
        {
            for (int j = 0; j < 9; ++j)// x axis
            {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18)); // inventory
            }
        }
		
        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142)); // actionbar
        }
		
	}
	
	public void addCraftingToCrafters(ICrafting icrafting) {
		
		//super.addCraftingToCrafters(icrafting);
		
		icrafting.sendProgressBarUpdate(this, 0, this.TELFurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 0, this.TELFurnace.burnTime);
		icrafting.sendProgressBarUpdate(this, 0, this.TELFurnace.currentItemBurnTime);
		
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.TELFurnace.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.TELFurnace.cookTime);
			}
			
			if(this.lastBurnTime != this.TELFurnace.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.TELFurnace.burnTime);
			}
			
			if(this.lastCurrentItemBurnTime != this.TELFurnace.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.TELFurnace.currentItemBurnTime);
			}
			
			
			this.lastCookTime = this.TELFurnace.cookTime;
			this.lastBurnTime = this.TELFurnace.burnTime;
			this.lastCurrentItemBurnTime = this.TELFurnace.currentItemBurnTime;
		}
		
		
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue) {
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	

}
