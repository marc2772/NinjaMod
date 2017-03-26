package com.turtlegames.ninjamod.init;

import com.turtlegames.ninjamod.NinjaMod;
import com.turtlegames.ninjamod.blocks.BlockSteel;
import com.turtlegames.ninjamod.lib.Names;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks
{
	public static BlockSteel steelBlock;
	
	public static void init()
	{
		steelBlock = new BlockSteel();
		
		registerBlock(steelBlock, Names.STEEL_BLOCK);
	}
	
	public static void initRecipes()
	{
		steelBlock.addRecipes();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initClient(ItemModelMesher mesher)
	{
		meshBlock(mesher, steelBlock, Names.STEEL_BLOCK);
	}
	
	public static void registerBlock(Block block, String name)
	{
		ResourceLocation location = new ResourceLocation(NinjaMod.MODID, name);
		block.setRegistryName(location);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), location);
	}
	
	public static void meshBlock(ItemModelMesher mesher, Block block, String name)
	{
		Item item = Item.getItemFromBlock(block);
		ModelResourceLocation model = new ModelResourceLocation(NinjaMod.RESOURCE_PREFIX + name, "inventory");
		ModelLoader.registerItemVariants(item, model);
		mesher.register(item, 0, model);
	}
}
