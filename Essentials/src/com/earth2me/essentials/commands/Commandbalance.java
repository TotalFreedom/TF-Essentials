package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import org.bukkit.ChatColor;
import org.bukkit.Server;

public class Commandbalance extends EssentialsCommand {
    public Commandbalance() {
        super("balance");
    }

    @Override
    protected void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
		sender.sendMessage(ChatColor.DARK_RED + "Essentials economy has been disabled in the config.");
    }
}
