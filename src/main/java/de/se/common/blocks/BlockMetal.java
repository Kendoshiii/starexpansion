package de.se.common.blocks;

public class BlockMetal extends BlockBase{

	private String name;
	
	public BlockMetal(int i, String name) {
		super(name);
		this.name = name;
		
		setHarvestLevel("pickaxe", i);
	}
	
}
