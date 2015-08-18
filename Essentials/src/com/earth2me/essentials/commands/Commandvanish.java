package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.User;
import org.bukkit.Server;
import me.StevenLawson.essentials.EssentialsHandler;


public class Commandvanish extends EssentialsToggleCommand {
    public Commandvanish() {
        super("vanish", "essentials.vanish.others");
    }

    @Override
    protected void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
		sender.sendMessage(EssentialsHandler.COMMAND_BLOCKED);
    }

	@Override
	void togglePlayer(CommandSource sender, User user, Boolean enabled) throws NotEnoughArgumentsException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}