package de.se.common.items.armor.emerald;

import java.util.List;

import de.se.SEItems;
import de.se.StarExpansion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEmeraldLeggs extends ItemArmor{

	public ItemEmeraldLeggs(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(StarExpansion.INSTANCE.tab);
		setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		if(stack.getItem() == SEItems.EMERALD_LEGGS){
			int damage = stack.getMaxDamage() - stack.getItemDamage();
			if(damage == -1){
				tooltip.add("Durability: §cUNBREAKABLE");
			}else{
				tooltip.add("Durability: §6" + damage);
			}
		}
	}
	
	/*@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack leggs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		
		if(ConfigValues.allowFlight){
			if (((head != null) && ((head.getItem() instanceof ItemEmeraldHelmet)) && (chest != null) && ((chest.getItem() instanceof ItemEmeraldChest)) && (leggs != null) && ((leggs.getItem() instanceof ItemEmeraldLeggs)) && (boots != null) && ((boots.getItem() instanceof ItemEmeraldBoots))) || (player.capabilities.isCreativeMode) || (player.isSpectator())){
				if(player.isInWater()){
					player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 5, 0, true, false));
				}
				player.stepHeight = 1.0F;
				player.fallDistance = 0.0F;
				player.capabilities.allowFlying = true;
				
			}
			else
			{
				player.stepHeight = 0.5F;
				player.capabilities.isFlying = false;
				player.capabilities.allowFlying = false;
			}
		}
	}*/
	
	@Override
	public int getItemEnchantability(){
		return 0;
	}


}
