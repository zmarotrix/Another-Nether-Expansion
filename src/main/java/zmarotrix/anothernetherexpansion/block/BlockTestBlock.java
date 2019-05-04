package zmarotrix.anothernetherexpansion.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;


public class BlockTestBlock extends Block{
	
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

   	
   	public BlockTestBlock() {
   		super(Material.rock);
   	}
   	
   	@Override
   	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
   	{
        entity.attackEntityFrom(DamageSource.inFire, 2);
    }
}

