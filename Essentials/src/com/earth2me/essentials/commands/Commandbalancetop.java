package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import org.bukkit.Server;
import org.bukkit.ChatColor;


public class Commandbalancetop extends EssentialsCommand {
    public Commandbalancetop() {
        super("balancetop");
    }

    @Override
    protected void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
		sender.sendMessage(ChatColor.DARK_RED + "Essentials economy has been disabled in the config.");
	}
}
