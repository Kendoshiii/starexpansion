package de.se.common.utils.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import gnu.trove.map.TMap;
import gnu.trove.map.hash.THashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class SupportHelper {

	public static ArrayList<String> names = new ArrayList<String>();
	protected static final TMap textLines = new THashMap();
	private final String url = "https://raw.githubusercontent.com/Akiishii/improvedmetals/master/supporters.txt";
	private boolean rewarded = false;

	public SupportHelper() {

		updateList();

	}

	private void updateList() {
		try {
			URL listFile = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(listFile.openStream()));
			String temp = reader.readLine();
			while (temp != null) {
				String[] rows = temp.split(",");
				if (rows.length == 4) {
					String name = rows[0].trim();
					if (rows[1].trim().equals("true")) {
						names.add(name);
					}
					textLines.put(name, rows[2] + "," + rows[3]);
				}
				temp = reader.readLine();
			}
		} catch (Exception e) {

		}
	}

	public static String getPlayerLine(String player, int line) {
		return getPlayerLine(player, line, null);
	}

	public static String getPlayerLine(String player, int line, String replace) {
		if (textLines.containsKey(player)) {
			String[] lines = ((String) textLines.get(player)).split(",");
			if (lines[line - 1] != null) {
				return lines[line - 1];
			}
		}
		return replace;
	}

	@SubscribeEvent
	public void onJoin(EntityJoinWorldEvent event) {
		if (!event.getWorld().isRemote) {
			if (event.getEntity() instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) event.getEntity();
				if (names.contains(player.getName())) {
					ItemStack beef = new ItemStack(Items.BEEF);
					beef.addEnchantment(Enchantments.FORTUNE, 1);
					beef.setStackDisplayName("The Steak of Awesomeness");
					if(rewarded != true){
						if (!player.inventory.hasItemStack(beef)) {
							player.inventory.addItemStackToInventory(beef);
							rewarded = true;
						}
					}
				}
			}
		}
	}
}
