package com.turtlegames.ninjamod.init;

import com.turtlegames.ninjamod.NinjaMod;
import com.turtlegames.ninjamod.item.ItemKatana;
import com.turtlegames.ninjamod.item.ItemSteelIngot;
import com.turtlegames.ninjamod.item.ItemSteelNugget;
import com.turtlegames.ninjamod.lib.Names;

import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ModItems
{
	public static ItemSteelIngot steelIngot;
	public static ItemSteelNugget steelNugget;
	public static ItemKatana katana;
	
	public static ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 0, 1000, 7, 4, 30);
	
	public static void init()
	{
		steelIngot = new ItemSteelIngot();
		registerItem(steelIngot, Names.STEEL_INGOT);
		OreDictionary.registerOre("ingotSteel", steelIngot);
		
		steelNugget = new ItemSteelNugget();
		registerItem(steelNugget, Names.STEEL_NUGGET);
		
		katana = new ItemKatana(STEEL);
		registerItem(katana, Names.KATANA);
	}
	
	public static void initRecipes()
	{
		steelIngot.addRecipes();
		steelNugget.addRecipes();
		katana.addRecipes();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher)
	{
		meshItem(mesher, steelIngot, Names.STEEL_INGOT);
		meshItem(mesher, steelNugget, Names.STEEL_NUGGET);
		meshItem(mesher, katana, Names.KATANA);
	}
	
	public static void registerItem(Item item, String name)
	{
		item.setRegistryName(new ResourceLocation(NinjaMod.MODID, name));
		GameRegistry.register(item);
	}
	
	public static void meshItem(ItemModelMesher mesher, Item item, String name)
	{
		ModelResourceLocation model = new ModelResourceLocation(NinjaMod.RESOURCE_PREFIX + name, "inventory");
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
