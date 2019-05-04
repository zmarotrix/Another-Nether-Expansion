package zmarotrix.anothernetherexpansion.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;
import zmarotrix.anothernetherexpansion.block.blockLonsdaleiteFurnace;
import zmarotrix.anothernetherexpansion.handler.FuelHandler;

public class TileEntityLonsdaleiteFurnace extends TileEntity implements ISidedInventory{
	
	private String localizedName;
	
	private ItemStack[] slots = new ItemStack [3]; // 0 = input , 1 = fuel, 2 = output.
	
	private static final int[] slots_top = new int[] {0}; //where do things go in top
	private static final int[] slots_bottom = new int[] {2}; //what goes out the bottom
	private static final int[] slots_side = new int[] {1}; // ?????????
	
	public int furnaceSpeed = 200;
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;
	

	public void setCustomInventoryName(String displayName) {
		this.localizedName = displayName;
		
	}

	public String getInventoryName() {
		
		return this.hasCustomInventoryName() ? this.localizedName : "container.TELFurnace";
	}
	
	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	
	public int getInventorySize() {
		return slots.length;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int slotIn) {
		return slots[slotIn];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
        if (this.slots[index] != null){
            ItemStack itemstack;

            if (this.slots[index].stackSize <= count){
                itemstack = this.slots[index];
                this.slots[index] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.slots[index].splitStack(count);

                if (this.slots[index].stackSize == 0){
                    this.slots[index] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if(this.slots[index] != null) {
			ItemStack itemstack = this.slots[index];
			this.slots[index] = null;
			return itemstack;
			
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.slots[index] = stack;
		if(stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public boolean isCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openChest() {}
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return slot == 2 ? false : (slot == 1 ? isItemFuel(itemstack) : true);
	}
	
	public static boolean isItemFuel(ItemStack itemstack) {
		return TileEntityFurnace.getItemBurnTime(itemstack) > 0;
	}
	
	
    public void updateEntity()
    {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

        if (this.burnTime > 0)
        {
            --this.burnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.burnTime != 0 || this.slots[1] != null && this.slots[0] != null)
            {
                if (this.burnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.burnTime = TileEntityFurnace.getItemBurnTime(this.slots[1]);

                    if (this.burnTime > 0)
                    {
                        flag1 = true;

                        if (this.slots[1] != null)
                        {
                            --this.slots[1].stackSize;

                            if (this.slots[1].stackSize == 0)
                            {
                                this.slots[1] = slots[1].getItem().getContainerItem(slots[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == this.furnaceSpeed)
                    {
                        this.cookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }

            if (flag != this.burnTime > 0)
            {
                flag1 = true;
                blockLonsdaleiteFurnace.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }
    
    
    private boolean canSmelt()
    {
        if (this.slots[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.slots[0]);
            if (itemstack == null) return false;
            if (this.slots[2] == null) return true;
            if (!this.slots[2].isItemEqual(itemstack)) return false;
            int result = slots[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slots[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
	
	
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.slots[0]);

            if (this.slots[2] == null)
            {
                this.slots[2] = itemstack.copy();
            }
            else if (this.slots[2].getItem() == itemstack.getItem())
            {
                this.slots[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.slots[0].stackSize;

            if (this.slots[0].stackSize <= 0)
            {
                this.slots[0] = null;
            }
        }
    }
    
    public boolean isBurning()
    {
        return this.burnTime > 0;
    }
    
    
    
	

	@Override
	public int[] getSlotsForFace(int side) {

		return side == 0 ? slots_bottom : (side == 1 ? slots_top : slots_side);
	}

	@Override //can hoppers drop items. probably pipes too.
	public boolean canInsertItem(int i, ItemStack itemstack, int slot) {
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override // Define what NOT to take out.
	public boolean canExtractItem(int i, ItemStack itemstack, int slot) {
		return slot != 0 || slot != 1 || slot != 2 || slot != 3 || i != 0 || itemstack.getItem() != Items.bucket;
	}
	
	public int getBurnTimeRemainingScale(int i) {
		if(this.cookTime == 0) {
			this.currentItemBurnTime = this.furnaceSpeed;
		}
		return this.burnTime*i / this.currentItemBurnTime;	
	}
	
	public int getCookProgressScaled(int i) {
		return this.cookTime * i / this.furnaceSpeed;
	}
		
		
	
}
