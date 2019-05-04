package zmarotrix.anothernetherexpansion.block;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;
import net.minecraft.init.Items;

public class blockFyrestone extends Block {
	
	public int itemChoice;
	
	@Override
   	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
   	{
   		float f = 0.01F;
   		return AxisAlignedBB.getBoundingBox((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 1) - f, (float)(k + 1) - f);
   	}
   	
   	@Override
   	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
   	{
   		float f = 0.01F;
   		return AxisAlignedBB.getBoundingBox((float)i + f, j, (float)k + f, (float)(i + 1) - f, j + 1, (float)(k + 1) - f);
   	}

	public blockFyrestone(Material material) {
		super(material);
		this.setHardness(7.0F);
		this.setHarvestLevel("pickaxe", 5);
		this.setLightLevel(0.7F);

	}
	
   	@Override
   	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
   	{
   		entity.attackEntityFrom(DamageSource.inFire, 2);
    }
   	
	
   	/**
   	@Override 
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        int count = quantityDropped(metadata, fortune, world.rand);
        for(int i = 0; i < count; i++)
        {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null)
            {
                ret.add(new ItemStack(item, 1, damageDropped(metadata)));
            }
        }
        return ret;
    }
   	
   	**/
   	

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		
		itemChoice = rand.nextInt(20);
		if (itemChoice == 9)
		{
			return Items.blaze_powder;
		}
		else 
		{
			return AnotherNetherExpansion.itemFyrestoneShard;
		}
	}
	
	@Override
	public int quantityDropped(Random rand){ 
		if (itemChoice == 9)
		{
			return 1 + rand.nextInt(2);
		}
		else 
		{
			return 1 + rand.nextInt(3);
		}
	} 

}
