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

public class itemFyrestoneArmor extends ItemArmor {

	public itemFyrestoneArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
		// TODO Auto-generated constructor stub
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(this.armorType==2)
		{
			return "ane:textures/models/armor/Fyrestone_layer_2.png";
		}
		return "ane:textures/models/armor/Fyrestone_layer_1.png";
	}
	
	
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null) {
			if(player.getCurrentArmor(3).getItem() == AnotherNetherExpansion.fyrestoneHelmet && 
				player.getCurrentArmor(2).getItem() == AnotherNetherExpansion.fyrestoneChestplate && 
				player.getCurrentArmor(1).getItem() == AnotherNetherExpansion.fyrestoneLeggings && 
				player.getCurrentArmor(0).getItem() == AnotherNetherExpansion.fyrestoneBoots) {
				
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 210, 3));
			}
			
		}
	}

}