package zmarotrix.anothernetherexpansion.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import zmarotrix.anothernetherexpansion.misc.FyrestoneShardEntityItem;

public class itemFyrestoneShard extends Item
{
	public itemFyrestoneShard(){
		
	}
	@Override
    public boolean hasCustomEntity(ItemStack stack){
        return true;
    }
	
	@Override
    public Entity createEntity(World world, Entity location, ItemStack itemstack){
		FyrestoneShardEntityItem entity = new FyrestoneShardEntityItem(world, location.posX, location.posY, location.posZ, itemstack);
		
		entity.delayBeforeCanPickup = 40;
	    entity.motionX = location.motionX;
	    entity.motionY = location.motionY;
	    entity.motionZ = location.motionZ;
	    return entity;
    }
	
	public static Object toEntity(EntityItem item){
		return ((Object) item);
	}
	
}
