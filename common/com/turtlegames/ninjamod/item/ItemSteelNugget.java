package com.turtlegames.ninjamod.item;

import com.turtlegames.ninjamod.NinjaMod;
import com.turtlegames.ninjamod.init.ModItems;
import com.turtlegames.ninjamod.lib.Names;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemSteelNugget extends Item
{
	public ItemSteelNugget()
	{
		super();
		setCreativeTab(NinjaMod.tabNinja);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item." + NinjaMod.RESOURCE_PREFIX + Names.STEEL_NUGGET; //item.katana:steel_nugget
	}
	
	public void addRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(this, 9), ModItems.steelIngot);
	}
}
