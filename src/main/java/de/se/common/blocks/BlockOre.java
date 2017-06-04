package de.se.common.blocks;

public class BlockOre extends BlockBase {

	private String name;

	public BlockOre(int i, String name) {
		super(name);
		this.name = name;
		setHardness(0.5F);
		setHarvestLevel("pickaxe", i);
	}
}
