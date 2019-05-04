package zmarotrix.anothernetherexpansion.block;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;
import zmarotrix.anothernetherexpansion.tileentity.TileEntityLonsdaleiteFurnace;

public class blockLonsdaleiteFurnace extends BlockContainer {

	private static boolean isActive = false;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconBottom;
	
	private static boolean keepInv;
	
	
	public blockLonsdaleiteFurnace(boolean isActive) {
		super(Material.iron);
		this.isActive=isActive;
	}
	
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AnotherNetherExpansion.modid + ":" + "lonsdaleite_furnace_side");
		this.iconFront = iconRegister.registerIcon(AnotherNetherExpansion.modid + ":" + (this.isActive ? "lonsdaleite_furnace_active" : "lonsdaleite_furnace_idle"));
		this.iconTop = iconRegister.registerIcon(AnotherNetherExpansion.modid + ":" + "lonsdaleite_furnace_top");
		this.iconBottom= iconRegister.registerIcon(AnotherNetherExpansion.modid + ":" + "lonsdaleite_furnace_bottom");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : (side == meta ? this.blockIcon : this.iconFront));
    }
	
	public Item getItemDropped(World world, int posX, int posY, int posZ) {
		return Item.getItemFromBlock(AnotherNetherExpansion.blockLonsdaleiteFurnaceIdle);
	}
	
	public void onBlockAdded(World world, int posX, int posY, int posZ) {
		super.onBlockAdded(world, posX, posY, posZ);
		this.setDefaultDirection(world, posX, posY, posZ);
	}
	
	
    private void setDefaultDirection(World world, int posX, int posY, int posZ)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(posX, posY, posZ - 1);
            Block block1 = world.getBlock(posX, posY, posZ + 1);
            Block block2 = world.getBlock(posX - 1, posY, posZ);
            Block block3 = world.getBlock(posX + 1, posY, posZ);
            byte b0 = 3;

            if (block.isFullBlock() && !block1.isFullBlock())
            {
                b0 = 3;
            }

            if (block1.isFullBlock() && !block.isFullBlock())
            {
                b0 = 2;
            }

            if (block2.isFullBlock() && !block3.isFullBlock())
            {
                b0 = 5;
            }

            if (block3.isFullBlock() && !block2.isFullBlock())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(posX, posY, posZ, b0, 2);
        }
    }

    public TileEntity createTileEntity(World world, int i) {
    	return new TileEntityLonsdaleiteFurnace();
    }
    
    //get direction player is facing
    public void onBlockPlacedBy(World world, int posX, int posY, int posZ, EntityLivingBase player, ItemStack itemstack)
    {
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            world.setBlockMetadataWithNotify(posX, posY, posZ, 2, 2);
        }

        if (l == 1)
        {
            world.setBlockMetadataWithNotify(posX, posY, posZ, 5, 2);
        }

        if (l == 2)
        {
            world.setBlockMetadataWithNotify(posX, posY, posZ, 3, 2);
        }

        if (l == 3)
        {
            world.setBlockMetadataWithNotify(posX, posY, posZ, 4, 2);
        }

        if (itemstack.hasDisplayName())
        {
            ((TileEntityLonsdaleiteFurnace)world.getTileEntity(posX, posY, posZ)).setCustomInventoryName(itemstack.getDisplayName());
        }
    }
	
	public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player,int side, float subX, float subY, float subZ)
    {
        if (!world.isRemote)
        {
        	FMLNetworkHandler.openGui(player, AnotherNetherExpansion.instance, AnotherNetherExpansion.guiIDlonsdaleiteFurnace, world, posX, posY, posZ);
        }
        return true;
    }
	
	

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		
		return null;
	}



	public static void updateBlockState(boolean b, World worldObj, int x, int y, int z) {
		int i = worldObj.getBlockMetadata(x, y, z);
		TileEntity tileentity = worldObj.getTileEntity(x, y, z);
		if(isActive) {
			worldObj.setBlock(x, y, z, AnotherNetherExpansion.blockLonsdaleiteFurnaceActive);
		} else { 
			worldObj.setBlock(x, y, z, AnotherNetherExpansion.blockLonsdaleiteFurnaceIdle);
		}
		
		keepInv = false;
		
		worldObj.setBlockMetadataWithNotify(x, y, z, i, 2);
		if(tileentity != null)
		{
			worldObj.setTileEntity(x, y, z, tileentity);
		}
		
	}

}
