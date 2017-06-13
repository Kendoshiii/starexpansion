package de.se.common.handler.commands;

import de.se.common.config.Config;
import de.se.common.config.ConfigValues;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class BlackListCommand extends CommandBase{

	@Override
	public String getName() {
		return "add_blacklist";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {
		if (!(sender instanceof EntityPlayerMP)) {
			sender.sendMessage(new TextComponentString("This command must be issued by an opped player in game"));
			return;
		}
		EntityPlayerMP player = (EntityPlayerMP) sender;
		if (player.getActiveItemStack() == null) {
			sender.sendMessage(new TextComponentString("This command must be issued while holding the item to be blacklisted."));
			return;
		}
		ConfigValues.repairerBlacklist.add(player.getActiveItemStack().getUnlocalizedName());
		ConfigValues.blProperty.set(ConfigValues.repairerBlacklist.toArray(new String[ConfigValues.repairerBlacklist.size()]));
		Config.cfg.save();
	}
	
}
