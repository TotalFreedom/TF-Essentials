package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import me.StevenLawson.essentials.EssentialsHandler;
import org.bukkit.Server;


public class Commandban extends EssentialsCommand {
    public Commandban() {
        super("ban");
    }

    @Override
    public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
		sender.sendMessage(EssentialsHandler.COMMAND_BLOCKED);
    }
}
