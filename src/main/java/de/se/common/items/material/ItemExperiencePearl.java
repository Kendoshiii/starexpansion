package de.se.common.items.material;

import de.se.StarExpansion;
import de.se.common.items.ItemBase;
import de.se.common.utils.StackUtils;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemExperiencePearl extends ItemBase{

	public ItemExperiencePearl(String name) {
		super(name);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if(!world.isRemote){
            int amount;
            if(!player.isSneaking()){
                amount = 10;
                if(!player.capabilities.isCreativeMode){
                    stack = StackUtils.addStackSize(stack, -1);
                }
            }
            else{
                amount = 10 * StackUtils.getStackSize(stack);
                if(!player.capabilities.isCreativeMode){
                    stack = StackUtils.setStackSize(stack, 0);
                }
            }

            EntityXPOrb orb = new EntityXPOrb(world, player.posX + 0.5, player.posY + 0.5, player.posZ + 0.5, amount);
            orb.getEntityData().setBoolean(StarExpansion.MODID + "used", true);
            world.spawnEntity(orb);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		
	}
	
}
