package zmarotrix.anothernetherexpansion;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraftforge.common.util.EnumHelper;
import zmarotrix.anothernetherexpansion.block.ANEBlocks;
import zmarotrix.anothernetherexpansion.block.BlockLonsdaleite;
import zmarotrix.anothernetherexpansion.block.blockLonsdaleiteBlock;
import zmarotrix.anothernetherexpansion.block.BlockTestBlock;
import zmarotrix.anothernetherexpansion.block.blockFyerstoneBrick;
import zmarotrix.anothernetherexpansion.block.blockFyrestone;
import zmarotrix.anothernetherexpansion.block.blockLonsdaleiteFurnace;
import zmarotrix.anothernetherexpansion.block.blockSmolderingObsidian;
import zmarotrix.anothernetherexpansion.block.oreCelenegilOre;
import zmarotrix.anothernetherexpansion.block.oreLonsdaleiteOre;
import zmarotrix.anothernetherexpansion.handler.CraftingHandler;
import zmarotrix.anothernetherexpansion.handler.FuelHandler;
import zmarotrix.anothernetherexpansion.handler.GuiHandler;
import zmarotrix.anothernetherexpansion.item.ANEItems;
import zmarotrix.anothernetherexpansion.item.ANETool;
import zmarotrix.anothernetherexpansion.item.itemAdamantineArmor;
import zmarotrix.anothernetherexpansion.item.itemSword;
import zmarotrix.anothernetherexpansion.misc.FyrestoneShardEntityItem;
import zmarotrix.anothernetherexpansion.misc.HotBlock;
import zmarotrix.anothernetherexpansion.tileentity.TileEntityLonsdaleiteFurnace;
import zmarotrix.anothernetherexpansion.item.itemAxe;
import zmarotrix.anothernetherexpansion.item.itemCelenegilArmor;
import zmarotrix.anothernetherexpansion.item.itemFyrestoneArmor;
import zmarotrix.anothernetherexpansion.item.itemFyrestoneShard;
import zmarotrix.anothernetherexpansion.item.itemHoe;
import zmarotrix.anothernetherexpansion.item.itemLonsdaleiteEnergyFocus;
import zmarotrix.anothernetherexpansion.item.itemPickaxe;
import zmarotrix.anothernetherexpansion.item.itemStatChecker;
import zmarotrix.anothernetherexpansion.item.itemLonsdaleiteArmor;
import cpw.mods.fml.common.Loader;

@Mod(modid = AnotherNetherExpansion.modid, name = AnotherNetherExpansion.modName, version = AnotherNetherExpansion.version) //updates the name and version Forge recognizes. 

public class AnotherNetherExpansion {
	
	//Mod Info
	public static final String modid = "ane";
	public static final String modName = "Another Nether Expansion";
	public static final String version = "Alpha v1.6.1";
	
	@Instance(modid)
	public static AnotherNetherExpansion instance;
	
	//ORE BASICS//////////
	
	//Losdaleite basics
	public static Block oreLonsdaleiteOre;
	public static Item itemLonsdaleite;
	public static Item itemLonsdaleiteNugget;
	public static Block blockLonsdaleiteBlock;
	
	//Celenegil basics
	public static Block oreCelenegilOre;
	public static Item itemCelenegilIngot;
	public static Item itemCelenegilNugget;
	public static Block blockCelenegilBlock;
	public static Block blockCelenegilStoneBlock;

	
	//Fyrestone basics
	public static Item itemFyrestoneIngot;
	public static Item itemFyrestoneShard;
	public static Block blockFyrestone;
	public static Block blockFyrestoneBrick;
	public static Block blockSmolderingObsidian;
	
	//Adamantine basics
	public static Block oreAdamantineOre;
	public static Item itemAdamantineIngot;
	public static Item itemAdamantineNugget;
	public static Block blockAdamantineBlock;
	
	//Voidstone basics
	public static Block oreVoidShardOre; //the ore
	public static Item itemVoidPurity; //refined essences, probably smelted for now.
	public static Item itemColdVoid; //crafted from essence
	public static Item itemVoidEssence; //drops from ore
	public static Block blockVoidShardStone; //crafted from cold void and endstone
	
	//TOOLS///////////////
	
	//Losdaleite tools
	public static Item lonsdaleitePickaxe;
	public static Item lonsdaleiteAxe;
	public static Item lonsdaleiteShovel;
	public static Item lonsdaleiteHoe;
	public static Item lonsdaleiteSword;

	//Celenegil tools
	public static Item celenegilPickaxe;
	public static Item celenegilAxe;
	public static Item celenegilShovel;
	public static Item celenegilHoe;
	public static Item celenegilSword;
	
	//Fyrestone Tools
	public static Item fyrestonePickaxe;
	public static Item fyrestoneAxe;
	public static Item fyrestoneShovel;
	public static Item fyrestoneHoe;
	public static Item fyrestoneSword;
	
	//Adamantine Tools
	public static Item adamantinePickaxe;
	public static Item adamantineAxe;
	public static Item adamantineShovel;
	public static Item adamantineHoe;
	public static Item adamantineSword;

	//ARMOR///////////////
	
	//Losdaleite Armor
	public static Item lonsdaleiteChestplate;
	public static Item lonsdaleiteHelmet;
	public static Item lonsdaleiteLeggings;
	public static Item lonsdaleiteBoots;
	
	//Celenegil Armor
	public static Item celenegilChestplate;
	public static Item celenegilHelmet;
	public static Item celenegilLeggings;
	public static Item celenegilBoots;
	
	//Fyrestone Armor
	public static Item fyrestoneChestplate;
	public static Item fyrestoneHelmet;
	public static Item fyrestoneLeggings;
	public static Item fyrestoneBoots;
	
	//Fyrestone Armor
	public static Item adamantineChestplate;
	public static Item adamantineHelmet;
	public static Item adamantineLeggings;
	public static Item adamantineBoots;
	
	//MISC///////////////
	
	public static final int guiIDlonsdaleiteFurnace = 0;
	
	//planned
	public static Item itemLonsdaleiteRod;
	public static Block blockHellFurnace;
	public static Block blockFyrestoneFurnace;
	public static Item itemLonsdaleiteEnergyFocus; // Crafted from quartz, glass and lonsdaleite. Uses itemIronHammer crafting model. 
	public static Item itemInfusedCoal; // maybe? what would I use this for?
	public static Item itemInfusedTorch;
	public static PotionEffect wack;
	public static Block blockLonsdaleiteFurnaceIdle;
	public static Block blockLonsdaleiteFurnaceActive;
	
	
	//TO-DO//////////
	//Organize creative tab
	//en_US.lang god damn it!
	//I'm gonna learn how to make that Hell Furnace one day...
	//stop restructuring the mod!
	//add .config integration
	//TEXTURES! YOU LAZY ASS!
	//Animated textures for Fyrestone such and such
	//OreDictionairy support, see link
	//https://github.com/Tslat/Advent-Of-Ascension/blob/1.7.10/source/izer/Itemizer.java
	
	//PROJECT E INTEGRATION////
	
	public static Item itemYellowMatter;
	public static Block blockEnergyCollecterMkIII;
	
	//tests

	public static Item itemIronSheet;
	public static Item statChecker;
	public static Block testBlock;
	
	
	public static CreativeTabs tabANE = new CreativeTabs("tabANE") {
		@Override @SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return new ItemStack(itemLonsdaleite).getItem();
		}
	};
	
	
	//This is a new Tool Material //addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
	public static final Item.ToolMaterial lonsdaleiteToolMaterial = EnumHelper.addToolMaterial(modid + ":" + "lonsdaleite_tool_material", 4, 2046, 10.0F, 6.0F, 15);
	public static final Item.ToolMaterial celenegilToolMaterial = EnumHelper.addToolMaterial(modid + ":" + "celenegil_tool_material", 5, 2046+516, 14.0F, 8.0F, 15);
	public static final Item.ToolMaterial fyrestoneToolMaterial = EnumHelper.addToolMaterial(modid + ":" + "fyrestone_tool_material", 5, 1024, 14.0F, 12.0F, 20);
	public static final Item.ToolMaterial adamantineToolMaterial = EnumHelper.addToolMaterial(modid + ":" + "adamantine_tool_material", 6, 3070, 18.0F, 8.0F, 15);

	public static final ItemArmor.ArmorMaterial lonsdaleiteArmorMaterial = EnumHelper.addArmorMaterial(modid + ":" + "lonsdaleite_armor_material", 1024+512, new int[] {3,8,5,3}, 10);
	public static final ItemArmor.ArmorMaterial celenegilArmorMaterial = EnumHelper.addArmorMaterial(modid + ":" + "celenegil_armor_material", 2048, new int[] {3,8,6,3}, 15);
	public static final ItemArmor.ArmorMaterial fyrestoneArmorMaterial = EnumHelper.addArmorMaterial(modid + ":" + "fyrestone_armor_material", 1024, new int[] {4,9,7,3}, 30);
	public static final ItemArmor.ArmorMaterial adamantineArmorMaterial = EnumHelper.addArmorMaterial(modid + ":" + "adamantine_armor_material", 2048+512, new int[] {3,9,7,3}, 25);

	
	public static DamageSource HotBlock;

	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item/Block init and Registration
		//Config handling
		
		
		//ITEMS////////////////////
		//zmTools.reg(statChecker = new ANEItems(), "stat_checker");
		
		//Lonsdaleite stuff
		
		itemLonsdaleite = new ANEItems();
		zmTools.reg(itemLonsdaleite, "lonsdaleite");
		
		
		zmTools.reg(itemLonsdaleiteNugget = new ANEItems(), "lonsdaleite_nugget");
		
		//Celenegil stuff
		
		zmTools.reg(itemCelenegilIngot = new ANEItems(), "celenegil_ingot");
		zmTools.reg(itemCelenegilNugget = new ANEItems(), "celenegil_nugget");
		
		//fyrestone
		
		zmTools.reg(itemFyrestoneShard = new itemFyrestoneShard(), "fyrestone_shard");
		zmTools.reg(itemFyrestoneIngot = new ANEItems(), "fyrestone_ingot");
		
		//Adamantine
		
		zmTools.reg(itemAdamantineIngot = new ANEItems(), "adamantine_ingot");
		zmTools.reg(itemAdamantineNugget = new ANEItems(), "adamantine_nugget");
		
		
		
		//other
		
		//zmTools.reg(itemIronSheet = new ANEItems(), "iron_sheet");
		//zmTools.reg(itemLonsdaleiteEnergyFocus = new itemLonsdaleiteEnergyFocus(), "lonsdaleite_energy_focus");

		
		//BLOCKS///////////////////testBlock
		//zmTools.reg(testBlock = new BlockTestBlock(), "test_block");
		
		
		zmTools.reg(blockLonsdaleiteBlock = new blockLonsdaleiteBlock(Material.iron), "lonsdaleite_block");
		zmTools.reg(blockCelenegilBlock = new blockSmolderingObsidian(Material.iron), "celenegil_block");
		//zmTools.reg(blockCelenegilStoneBlock = new ANEBlocks(Material.iron, 5.0F), "celenegil_stone");
		
		
		zmTools.reg(oreLonsdaleiteOre = new oreLonsdaleiteOre(Material.rock), "lonsdaleite_ore");
		zmTools.reg(oreCelenegilOre = new oreCelenegilOre(Material.rock), "celenegil_ore");
		
		
		zmTools.reg(blockFyrestone = new blockFyrestone(Material.rock), "fyrestone");
		zmTools.reg(blockFyrestoneBrick = new blockFyerstoneBrick(Material.rock), "fyrestone_brick");
		zmTools.reg(blockSmolderingObsidian = new blockSmolderingObsidian(Material.rock), "smoldering_obsidian_brick");
		zmTools.reg(oreAdamantineOre = new ANEBlocks(Material.rock, 5.0F, "pickaxe", 5), "adamantine_ore");
		zmTools.reg(blockAdamantineBlock = new blockSmolderingObsidian(Material.iron), "adamantine_block");
		
		//How to add a smelting recipe. should probably be in init rather than preinit?
		//GameRegistry.addSmelting(input, output, xp);
		
		//TOOLS////////////////////// 0 = shovel, 1 = sword, 2 = axe, 3 = pickaxe, 4 = hoe 

		zmTools.reg(lonsdaleiteShovel = ANETool.make(lonsdaleiteToolMaterial, 0), "lonsdaleite_shovel");
		zmTools.reg(lonsdaleiteSword = ANETool.make(lonsdaleiteToolMaterial, 1), "lonsdaleite_sword");
		zmTools.reg(lonsdaleiteAxe = ANETool.make(lonsdaleiteToolMaterial, 2), "lonsdaleite_axe");
		zmTools.reg(lonsdaleitePickaxe = ANETool.make(lonsdaleiteToolMaterial, 3), "lonsdaleite_pickaxe");
		zmTools.reg(lonsdaleiteHoe = ANETool.make(lonsdaleiteToolMaterial, 4), "lonsdaleite_hoe");
		
		zmTools.reg(celenegilShovel = ANETool.make(celenegilToolMaterial, 0), "celenegil_shovel");
		zmTools.reg(celenegilSword = ANETool.make(celenegilToolMaterial, 1), "celenegil_sword");
		zmTools.reg(celenegilAxe = ANETool.make(celenegilToolMaterial, 2), "celenegil_axe");
		zmTools.reg(celenegilPickaxe = ANETool.make(celenegilToolMaterial, 3), "celenegil_pickaxe");
		zmTools.reg(celenegilHoe = ANETool.make(celenegilToolMaterial, 4), "celenegil_hoe");
		
		zmTools.reg(fyrestoneShovel = ANETool.make(fyrestoneToolMaterial, 0), "fyrestone_shovel");
		zmTools.reg(fyrestoneSword = ANETool.make(fyrestoneToolMaterial, 1), "fyrestone_sword");
		zmTools.reg(fyrestoneAxe = ANETool.make(fyrestoneToolMaterial, 2), "fyrestone_axe");
		zmTools.reg(fyrestonePickaxe = ANETool.make(fyrestoneToolMaterial, 3), "fyrestone_pickaxe");
		zmTools.reg(fyrestoneHoe = ANETool.make(fyrestoneToolMaterial, 4), "fyrestone_hoe");
		
		zmTools.reg(adamantineShovel = ANETool.make(adamantineToolMaterial, 0), "adamantine_shovel");
		zmTools.reg(adamantineSword = ANETool.make(adamantineToolMaterial, 1), "adamantine_sword");
		zmTools.reg(adamantineAxe = ANETool.make(adamantineToolMaterial, 2), "adamantine_axe");
		zmTools.reg(adamantinePickaxe = ANETool.make(adamantineToolMaterial, 3), "adamantine_pickaxe");
		zmTools.reg(adamantineHoe = ANETool.make(adamantineToolMaterial, 4), "adamantine_hoe");
		
		
		
		
		
		//ARMOR////////////////////////////
		
		//Lonsdaleite
		zmTools.reg(lonsdaleiteChestplate = new itemLonsdaleiteArmor(lonsdaleiteArmorMaterial, 0,1), "lonsdaleite_chestpiece");
		zmTools.reg(lonsdaleiteHelmet = new itemLonsdaleiteArmor(lonsdaleiteArmorMaterial, 0,0), "lonsdaleite_helmet");
		zmTools.reg(lonsdaleiteLeggings = new itemLonsdaleiteArmor(lonsdaleiteArmorMaterial, 0,2), "lonsdaleite_leggings");
		zmTools.reg(lonsdaleiteBoots = new itemLonsdaleiteArmor(lonsdaleiteArmorMaterial, 0,3), "lonsdaleite_boots");
		
		//Celenegil
		zmTools.reg(celenegilChestplate = new itemCelenegilArmor(celenegilArmorMaterial, 0,1), "celenegil_chestpiece");
		zmTools.reg(celenegilHelmet = new itemCelenegilArmor(celenegilArmorMaterial, 0,0), "celenegil_helmet");
		zmTools.reg(celenegilLeggings = new itemCelenegilArmor(celenegilArmorMaterial, 0,2), "celenegil_leggings");
		zmTools.reg(celenegilBoots = new itemCelenegilArmor(celenegilArmorMaterial, 0,3), "celenegil_boots");
		
		//Fyrestone
		zmTools.reg(fyrestoneChestplate = new itemFyrestoneArmor(fyrestoneArmorMaterial, 0,1), "fyrestone_chestpiece");
		zmTools.reg(fyrestoneHelmet = new itemFyrestoneArmor(fyrestoneArmorMaterial, 0,0), "fyrestone_helmet");
		zmTools.reg(fyrestoneLeggings = new itemFyrestoneArmor(fyrestoneArmorMaterial, 0,2), "fyrestone_leggings");
		zmTools.reg(fyrestoneBoots = new itemFyrestoneArmor(fyrestoneArmorMaterial, 0,3), "fyrestone_boots");
		
		//Adamantine
		zmTools.reg(adamantineChestplate = new itemAdamantineArmor(adamantineArmorMaterial, 0,1), "adamantine_chestpiece");
		zmTools.reg(adamantineHelmet = new itemAdamantineArmor(adamantineArmorMaterial, 0,0), "adamantine_helmet");
		zmTools.reg(adamantineLeggings = new itemAdamantineArmor(adamantineArmorMaterial, 0,2), "adamantine_leggings");
		zmTools.reg(adamantineBoots = new itemAdamantineArmor(adamantineArmorMaterial, 0,3), "adamantine_boots");
		
		
		//MACHINES////////////////////////
		
		//zmTools.reg(blockLonsdaleiteFurnaceIdle = new blockLonsdaleiteFurnace(false), "lonsdaleite_furnace_Idle");
		//zmTools.reg(blockLonsdaleiteFurnaceActive = new blockLonsdaleiteFurnace(true).setLightLevel(0.625f), "lonsdaleite_furnace_Active");
		
		//MISC////////////////////////////
		
		GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
		GameRegistry.registerFuelHandler(new FuelHandler());
		EntityRegistry.registerModEntity(FyrestoneShardEntityItem.class, "FyrestoneShard Item", 1532, this, 35, 5, true);
		
		
		if (Loader.isModLoaded("ProjectE"))
		{
			
			
		}
		
	}
	
	


	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Proxy, Tile entity, entity, GUI and Packet Registration
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		GameRegistry.registerTileEntity(TileEntityLonsdaleiteFurnace.class, "lonsdaleite_furnace");
		
		//MISC/////////////////
		
		GameRegistry.addRecipe(new ItemStack(statChecker), new Object[]{"n","b",'n', Items.gold_nugget, 'b', Items.book});
		GameRegistry.addShapelessRecipe(new ItemStack(testBlock), new Object[] {Items.diamond, Items.gold_ingot, Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(itemLonsdaleiteEnergyFocus), "g", "glg","q", 'q', Items.quartz, 'l', itemLonsdaleite, 'g', Blocks.glass);
		

		
		//Lonsdaleite Block/Ingot/Nugget
		
		GameRegistry.addRecipe(new ItemStack(blockLonsdaleiteBlock),new Object[] {"111","111","111",'1', itemLonsdaleite});
		GameRegistry.addRecipe(new ItemStack(itemLonsdaleite,9),new Object[] {"1",'1', blockLonsdaleiteBlock});
		GameRegistry.addRecipe(new ItemStack(itemLonsdaleite),new Object[] {"111","111","111",'1', itemLonsdaleiteNugget});
		GameRegistry.addRecipe(new ItemStack(itemLonsdaleiteNugget,9),new Object[] {"1",'1', itemLonsdaleite});
		
		//Celenegil Block/Ingot/Nugget
		
		GameRegistry.addRecipe(new ItemStack(blockCelenegilBlock),new Object[] {"111","111","111",'1', itemCelenegilIngot});
		GameRegistry.addRecipe(new ItemStack(itemCelenegilIngot,9),new Object[] {"1",'1', blockCelenegilBlock});
		GameRegistry.addRecipe(new ItemStack(itemCelenegilIngot),new Object[] {"111","111","111",'1', itemCelenegilNugget});
		GameRegistry.addRecipe(new ItemStack(itemCelenegilNugget,9),new Object[] {"1",'1', itemCelenegilIngot});
		
		//fyrestone Block/Ingot/Nugget
		
		GameRegistry.addRecipe(new ItemStack(blockFyrestoneBrick),new Object[] {"111","111","111",'1', itemFyrestoneIngot});
		GameRegistry.addRecipe(new ItemStack(itemFyrestoneIngot,9),new Object[] {"1",'1', blockFyrestoneBrick});
		GameRegistry.addShapelessRecipe(new ItemStack(itemFyrestoneIngot), new Object[] {itemFyrestoneShard,itemFyrestoneShard,itemFyrestoneShard,itemFyrestoneShard});
		GameRegistry.addShapelessRecipe(new ItemStack(itemFyrestoneShard, 4), new Object[] {new ItemStack(itemFyrestoneIngot)});
		GameRegistry.addShapelessRecipe(new ItemStack(blockSmolderingObsidian, 9), new Object[] {Blocks.obsidian, Blocks.obsidian, Blocks.obsidian, Blocks.obsidian,
				Blocks.obsidian, Blocks.obsidian, Blocks.obsidian, Blocks.obsidian, itemFyrestoneShard});
		
		//Adamantine
		
		GameRegistry.addRecipe(new ItemStack(blockAdamantineBlock),new Object[] {"111","111","111",'1', itemAdamantineIngot});
		GameRegistry.addRecipe(new ItemStack(itemAdamantineIngot,9),new Object[] {"1",'1', blockAdamantineBlock});
		//GameRegistry.addRecipe(new ItemStack(itemAdamantineIngot),new Object[] {"111","111","111",'1', itemAdamantineNugget});
		GameRegistry.addShapelessRecipe(new ItemStack(itemAdamantineIngot), new Object[] {itemAdamantineNugget, itemAdamantineNugget, itemAdamantineNugget});
		
		
		
		//TOOLS/////////////////
		
		//Losdaleite
		
		GameRegistry.addRecipe(new ItemStack(lonsdaleitePickaxe),new Object[]{"111"," 2 "," 2 ", '1', itemLonsdaleite, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteHoe),new Object[]{"11"," 2"," 2", '1', itemLonsdaleite, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteHoe),new Object[]{"11","2 ","2 ", '1', itemLonsdaleite, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteAxe),new Object[]{"11","12"," 2", '1', itemLonsdaleite, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteAxe),new Object[]{"11","21","2 ", '1', itemLonsdaleite, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteSword),new Object[]{"1","1","2", '1', itemLonsdaleite, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteShovel),new Object[]{"1","2","2", '1', itemLonsdaleite, '2', Items.stick});
		
		//Celenegil
		
		GameRegistry.addRecipe(new ItemStack(celenegilPickaxe),new Object[]{"111"," 2 "," 2 ", '1', itemCelenegilIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(celenegilHoe),new Object[]{"11"," 2"," 2", '1', itemCelenegilIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(celenegilHoe),new Object[]{"11","2 ","2 ", '1', itemCelenegilIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(celenegilAxe),new Object[]{"11","12"," 2", '1', itemCelenegilIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(celenegilAxe),new Object[]{"11","21","2 ", '1', itemCelenegilIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(celenegilSword),new Object[]{"1","1","2", '1', itemCelenegilIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(celenegilShovel),new Object[]{"1","2","2", '1', itemCelenegilIngot, '2', Items.stick});
		
		//Fyrestone
		
		GameRegistry.addRecipe(new ItemStack(fyrestonePickaxe),new Object[]{"111"," 2 "," 2 ", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(fyrestoneHoe),new Object[]{"11"," 2"," 2", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(fyrestoneHoe),new Object[]{"11","2 ","2 ", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(fyrestoneAxe),new Object[]{"11","12"," 2", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(fyrestoneAxe),new Object[]{"11","21","2 ", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(fyrestoneSword),new Object[]{"1","1","2", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(fyrestoneShovel),new Object[]{"1","2","2", '1', itemFyrestoneIngot, '2', Items.blaze_rod});
		
		//Adamantine
		
		GameRegistry.addRecipe(new ItemStack(adamantinePickaxe),new Object[]{"111"," 2 "," 2 ", '1', itemAdamantineIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(adamantineHoe),new Object[]{"11"," 2"," 2", '1', itemAdamantineIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(adamantineHoe),new Object[]{"11","2 ","2 ", '1', itemAdamantineIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(adamantineAxe),new Object[]{"11","12"," 2", '1', itemAdamantineIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(adamantineAxe),new Object[]{"11","21","2 ", '1', itemAdamantineIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(adamantineSword),new Object[]{"1","1","2", '1', itemAdamantineIngot, '2', Items.stick});
		GameRegistry.addRecipe(new ItemStack(adamantineShovel),new Object[]{"1","2","2", '1', itemAdamantineIngot, '2', Items.stick});
		
		
		//ARMOR/////////////////
		
		//Losdaleite
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteChestplate),new Object[]{"l l","lll","lll", 'l',itemLonsdaleite});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteHelmet),new Object[]{"lll","l l",'l',itemLonsdaleite});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteLeggings),new Object[]{"lll","l l","l l", 'l',itemLonsdaleite});
		GameRegistry.addRecipe(new ItemStack(lonsdaleiteBoots),new Object[]{"l l","l l", 'l',itemLonsdaleite});
		
		//Celenegil
		GameRegistry.addRecipe(new ItemStack(celenegilChestplate),new Object[]{"l l","lll","lll", 'l',itemCelenegilIngot });
		GameRegistry.addRecipe(new ItemStack(celenegilHelmet),new Object[]{"lll","l l",'l',itemCelenegilIngot });
		GameRegistry.addRecipe(new ItemStack(celenegilLeggings),new Object[]{"lll","l l","l l", 'l',itemCelenegilIngot });
		GameRegistry.addRecipe(new ItemStack(celenegilBoots),new Object[]{"l l","l l", 'l',itemCelenegilIngot });
		
		//fyrestone itemFyrestoneIngot
		GameRegistry.addRecipe(new ItemStack(fyrestoneChestplate),new Object[]{"l l","lll","lll", 'l',itemFyrestoneIngot });
		GameRegistry.addRecipe(new ItemStack(fyrestoneHelmet),new Object[]{"lll","l l",'l',itemFyrestoneIngot });
		GameRegistry.addRecipe(new ItemStack(fyrestoneLeggings),new Object[]{"lll","l l","l l", 'l',itemFyrestoneIngot });
		GameRegistry.addRecipe(new ItemStack(fyrestoneBoots),new Object[]{"l l","l l", 'l',itemFyrestoneIngot });
		
		//Adamantine
		GameRegistry.addRecipe(new ItemStack(adamantineChestplate),new Object[]{"l l","lll","lll", 'l',itemAdamantineIngot });
		GameRegistry.addRecipe(new ItemStack(adamantineHelmet),new Object[]{"lll","l l",'l',itemAdamantineIngot });
		GameRegistry.addRecipe(new ItemStack(adamantineLeggings),new Object[]{"lll","l l","l l", 'l',itemAdamantineIngot });
		GameRegistry.addRecipe(new ItemStack(adamantineBoots),new Object[]{"l l","l l", 'l',itemAdamantineIngot });
		
		
		//SMELTING///////////////
		
		GameRegistry.addSmelting(oreCelenegilOre, new ItemStack(itemCelenegilIngot), 50);
		GameRegistry.addSmelting(oreAdamantineOre, new ItemStack(itemAdamantineNugget), 100);
		
		
		if (Loader.isModLoaded("ProjectE"))
		{
			
			
		}

		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
		
	}
	

}
