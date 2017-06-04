package de.se;

import java.util.ArrayList;
import java.util.List;

import de.se.common.blocks.BlockMetal;
import de.se.common.blocks.BlockOre;
import de.se.common.blocks.machine.BlockMachineFrame;
import de.se.common.blocks.machine.atreactor.BlockATReactorController;
import de.se.common.blocks.machine.atreactor.BlockATReactorGlass;
import de.se.common.blocks.machine.atreactor.BlockATReactorPowerConnector;
import de.se.common.lib.Names;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SEBlocks {

	public static List<Block> BLOCKS = new ArrayList();
	
	public static Block COPPER_ORE, TIN_ORE, SILVER_ORE, LEAD_ORE, RADIANT_ORE;

	public static Block COPPER_BLOCK, TIN_BLOCK, BRONZE_BLOCK, SILVER_BLOCK, LEAD_BLOCK, METEORIE_BLOCK;
	
	public static Block MACHINE_FRAME;
	
	public static Block STEEL_CASE, ATREACTOR_CONTROLLER, ATREACTOR_POWER_CONNECTOR, RADIANT_GLASS, RADIANT_BLOCK;

	public static void init() {

		COPPER_ORE = new BlockOre(1, Names.oreCopper);
		TIN_ORE = new BlockOre(1, Names.oreTin);
		SILVER_ORE = new BlockOre(2, Names.oreSilver);
		LEAD_ORE = new BlockOre(2, Names.oreLead);
		RADIANT_ORE = new BlockOre(3, Names.oreRadiant).setLightLevel(0.3F);
		
		COPPER_BLOCK = new BlockMetal(1, Names.blockCopper);
		TIN_BLOCK = new BlockMetal(1, Names.blockTin);
		BRONZE_BLOCK = new BlockMetal(1, Names.blockBronze);
		SILVER_BLOCK = new BlockMetal(1, Names.blockSilver);
		LEAD_BLOCK = new BlockMetal(1, Names.blockLead);
		METEORIE_BLOCK = new BlockMetal(2, Names.blockMeteorite);
		
		MACHINE_FRAME = new BlockMachineFrame(Names.blockMachineFrame);
		
		STEEL_CASE = new BlockMetal(1, Names.blockSteelCase);
		ATREACTOR_CONTROLLER = new BlockATReactorController(Names.blockATReactorController);
		ATREACTOR_POWER_CONNECTOR = new BlockATReactorPowerConnector(Names.blockATReactorPowerConnector);
		RADIANT_GLASS = new BlockATReactorGlass(Names.blockATReactorGlass);
		RADIANT_BLOCK = new BlockMetal(2, Names.blockRadiant).setLightLevel(1.0F);

		reg();

	}

	private static void reg() {

		BLOCKS.add(COPPER_ORE);
		BLOCKS.add(TIN_ORE);
		BLOCKS.add(SILVER_ORE);
		BLOCKS.add(LEAD_ORE);
		BLOCKS.add(RADIANT_ORE);

		BLOCKS.add(COPPER_BLOCK);
		BLOCKS.add(TIN_BLOCK);
		BLOCKS.add(BRONZE_BLOCK);
		BLOCKS.add(SILVER_BLOCK);
		BLOCKS.add(LEAD_BLOCK);
		BLOCKS.add(METEORIE_BLOCK);
		
		BLOCKS.add(MACHINE_FRAME);
		
		BLOCKS.add(STEEL_CASE);
		BLOCKS.add(ATREACTOR_CONTROLLER);
		BLOCKS.add(ATREACTOR_POWER_CONNECTOR);
		BLOCKS.add(RADIANT_GLASS);
		BLOCKS.add(RADIANT_BLOCK);

		for (Block block : BLOCKS) {
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}

	}

}
