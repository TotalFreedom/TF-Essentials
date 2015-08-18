package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.User;
import org.bukkit.Server;

import static com.earth2me.essentials.I18n.tl;
import me.StevenLawson.essentials.EssentialsHandler;


public class Commandmsgtoggle extends EssentialsToggleCommand {
    public Commandmsgtoggle() {
        super("msgtoggle", "essentials.msgtoggle.others");
    }

    @Override
    protected void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
        toggleOtherPlayers(server, sender, args);
    }

    @Override
    protected void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
        if (args.length == 1) {
            Boolean toggle = matchToggleArgument(args[0]);
            if (toggle == null && EssentialsHandler.isSuperAdmin(user)) {
                toggleOtherPlayers(server, user.getSource(), args);
            } else {
                togglePlayer(user.getSource(), user, toggle);
            }
        } else if (args.length == 2 && EssentialsHandler.isSuperAdmin(user)) {
            toggleOtherPlayers(server, user.getSource(), args);
        } else {
            togglePlayer(user.getSource(), user, null);
        }
    }

    @Override
    void togglePlayer(CommandSource sender, User user, Boolean enabled) {
        if (enabled == null) {
            enabled = !user.isIgnoreMsg();
        }

        user.setIgnoreMsg(enabled);

        user.sendMessage(!enabled ? tl("msgEnabled") : tl("msgDisabled"));
        if (!sender.isPlayer() || !sender.getPlayer().equals(user.getBase())) {
            sender.sendMessage(!enabled ? tl("msgEnabledFor", user.getDisplayName()) : tl("msgDisabledFor", user.getDisplayName()));
        }
    }
}
