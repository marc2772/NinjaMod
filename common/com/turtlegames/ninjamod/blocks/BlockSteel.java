package com.turtlegames.ninjamod.blocks;

import com.turtlegames.ninjamod.NinjaMod;
import com.turtlegames.ninjamod.init.ModItems;
import com.turtlegames.ninjamod.item.ItemSteelIngot;
import com.turtlegames.ninjamod.lib.Names;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockSteel extends Block
{
	public BlockSteel()
	{
		super(Material.IRON);
		setCreativeTab(NinjaMod.tabNinja);
	}

	@Override
	public String getUnlocalizedName()
	{
		return "tile." + NinjaMod.RESOURCE_PREFIX + Names.STEEL_BLOCK; //tile.ninjamod:steel_block
	}
	
	public void addRecipes()
	{
		//spaces means empty spot
		GameRegistry.addShapedRecipe(new ItemStack(this), "sss", "sss", "sss", 
				's', ModItems.steelIngot);
	}
}
