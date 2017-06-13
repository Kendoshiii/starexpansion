package de.se.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/*
 * This class was created by Kendoshiii and modified with the Rarity code written by Ellpeck
 */

public class ItemBlockBase extends ItemBlock{

	public ItemBlockBase(Block block, boolean Subtypes) {
		super(block);
		setRegistryName(block.getRegistryName());
		if (Subtypes) {
			setMaxDamage(0);
			setHasSubtypes(true);
		}
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (getHasSubtypes()) {
			return getUnlocalizedName() + "." + stack.getItemDamage();
		}

		return getUnlocalizedName();
	}
	
    @Override
    public EnumRarity getRarity(ItemStack stack){
        if(this.block instanceof ICustomRarity){
            return ((ICustomRarity)this.block).getRarity(stack);
        }
        else{
            return EnumRarity.COMMON;
        }
    }

    public interface ICustomRarity{

        EnumRarity getRarity(ItemStack stack);

    }
	
}
