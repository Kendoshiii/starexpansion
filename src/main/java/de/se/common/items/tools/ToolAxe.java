package de.se.common.items.tools;

import java.util.List;

import de.se.StarExpansion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ToolAxe extends ToolAdvAxe {

	private String name;
	
	public ToolAxe(ToolMaterial material, String name) {
		super(material, -3.0F);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(StarExpansion.INSTANCE.tab);
	}

	
	@Override
	public String getUnlocalizedName(){
		return "item." + StarExpansion.MODID + ":" + name;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if (getHasSubtypes()) {
			return getUnlocalizedName() + "." + stack.getItemDamage();
		}

		return getUnlocalizedName();
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		int damage = stack.getMaxDamage() - stack.getItemDamage();
		if(damage == -1 ){
			tooltip.add("Durability: " + "UNBREAKABLE");
		}else{
			tooltip.add("Durability: " + damage);
		}
		super.addInformation(stack, player, tooltip, advanced);
	}

}
