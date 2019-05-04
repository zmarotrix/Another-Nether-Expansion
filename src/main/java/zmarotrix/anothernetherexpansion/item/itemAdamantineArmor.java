package zmarotrix.anothernetherexpansion.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import zmarotrix.anothernetherexpansion.AnotherNetherExpansion;

public class itemAdamantineArmor extends ItemArmor {
	boolean wasFastLastTick;

	public itemAdamantineArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
		// TODO Auto-generated constructor stub
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(this.armorType==2)
		{
			return "ane:textures/models/armor/Adamantine_layer_2.png";
		}
		return "ane:textures/models/armor/Adamantine_layer_1.png";
	}
	
	
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		
		
		
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null) 
		{
			if(player.getCurrentArmor(3).getItem() == AnotherNetherExpansion.adamantineHelmet && 
				player.getCurrentArmor(2).getItem() == AnotherNetherExpansion.adamantineChestplate && 
				player.getCurrentArmor(1).getItem() == AnotherNetherExpansion.adamantineLeggings && 
				player.getCurrentArmor(0).getItem() == AnotherNetherExpansion.adamantineBoots) 
			{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.getId() , 210, 1));
				player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 210, 1));
			}
		}
		
		
		
		
	}
		
}
