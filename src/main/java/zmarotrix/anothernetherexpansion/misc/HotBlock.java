package zmarotrix.anothernetherexpansion.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

public class HotBlock extends DamageSource {

	public HotBlock() {
		super("HotBlock");
		this.setFireDamage();
	}
	


}
