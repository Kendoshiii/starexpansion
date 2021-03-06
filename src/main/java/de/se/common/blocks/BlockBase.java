package de.se.common.blocks;

import de.se.StarExpansion;
import de.se.common.items.ItemBlockBase;
import de.se.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class BlockBase extends Block {

	private String name;

	public BlockBase(String name) {
		super(Material.ROCK);
		this.name = name;
		this.setHardness(5F);
		this.setResistance(10F);
		setHardness(1.9F);
		setRegistryName(Reference.MODID, name);
		setCreativeTab(StarExpansion.INSTANCE.tab);
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		super.getSubBlocks(item, tab, list);
	}

	@Override
	public String getUnlocalizedName() {
		return "block." + Reference.MODID + ":" + name;
	}

	public Item createItem() {
		return new ItemBlockBase(this, false);
	}

	
}
