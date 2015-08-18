package com.earth2me.essentials.commands;

import com.earth2me.essentials.User;
import me.StevenLawson.essentials.EssentialsHandler;
import org.bukkit.Server;

public class Commandmail extends EssentialsCommand {

    public Commandmail() {
        super("mail");
    }

    //TODO: Tidy this up / TL these errors.
    @Override
    public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
		user.sendMessage(EssentialsHandler.COMMAND_BLOCKED);
	}
}
