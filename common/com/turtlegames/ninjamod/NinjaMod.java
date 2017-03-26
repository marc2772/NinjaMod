package com.turtlegames.ninjamod;

import com.turtlegames.ninjamod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NinjaMod.MODID, name = NinjaMod.MODNAME, version = NinjaMod.VERSION, dependencies = NinjaMod.DEPENDENCIES)
public class NinjaMod 
{
	//Constants
	public static final String MODID = "ninjamod";
	public static final String MODNAME = "Ninja Mod";
	public static final String VERSION = "@VERSION@";
	public static final String DEPENDENCIES = "required-after:forge@[13.20.0.2228,)";
	public static final String RESOURCE_PREFIX = MODID + ":"; //ninjamod:
	
	@Instance(MODID)
	public static NinjaMod instance;
	
	@SidedProxy(clientSide = "com.turtlegames.ninjamod.ClientProxy", serverSide = "com.turtlegames.ninjamod.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
	
	public static CreativeTabs tabNinja = new CreativeTabs(NinjaMod.RESOURCE_PREFIX + "creative_tab")
		{
			@Override
			public ItemStack getTabIconItem()
			{
				return new ItemStack(ModItems.katana);
			}
		};
}
