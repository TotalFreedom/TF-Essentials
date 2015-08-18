package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.utils.StringUtil;
import me.StevenLawson.essentials.EssentialsHandler;
import org.bukkit.Server;


public class Commandjails extends EssentialsCommand {
    public Commandjails() {
        super("jails");
    }

    @Override
    protected void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
		sender.sendMessage(EssentialsHandler.COMMAND_BLOCKED);
    }
}
