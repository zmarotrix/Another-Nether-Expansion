package zmarotrix.anothernetherexpansion.misc;

import java.util.Iterator;

import javax.annotation.Nonnull;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public class FyrestoneShardEntityItem extends EntityItem {
	
	
	public FyrestoneShardEntityItem(World worldIn, double x, double y, double z) 
	{
		super(worldIn, x, y, z);
		isImmuneToFire = true;
	}

	public FyrestoneShardEntityItem(World worldIn, double x, double y, double z, ItemStack stack)
	{
		super(worldIn, x, y, z, stack);
		isImmuneToFire = true;
	}

	public FyrestoneShardEntityItem(World worldIn)
	{
		super(worldIn);
	    isImmuneToFire = true;
	}

	private static float health = 5;

	@Override
	public boolean attackEntityFrom(@Nonnull DamageSource source, float amount) 
	{
		if(source.getDamageType().equals(DamageSource.outOfWorld.damageType))
		{
			return true;
		}
		return false;
	}  
	  
}
