package com.turtlegames.ninjamod.item;

import com.turtlegames.ninjamod.NinjaMod;
import com.turtlegames.ninjamod.blocks.BlockSteel;
import com.turtlegames.ninjamod.init.ModBlocks;
import com.turtlegames.ninjamod.init.ModItems;
import com.turtlegames.ninjamod.lib.Names;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemSteelIngot extends Item
{
	public ItemSteelIngot()
	{
		super();
		setCreativeTab(NinjaMod.tabNinja);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item." + NinjaMod.RESOURCE_PREFIX + Names.STEEL_INGOT; //item.ninjamod:steel_ingot
	}
	
	public void addRecipes()
	{
		//8 irons and 1 coal in the middle
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(this), "iii", "ici", "iii",
				'i', "ingotIron",
				'c', new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE)));
		
		GameRegistry.addShapelessRecipe(new ItemStack(this, 9), ModBlocks.steelBlock);
		GameRegistry.addShapedRecipe(new ItemStack(this), "iii", "iii", "iii",
				'i', ModItems.steelNugget);
	}
}
