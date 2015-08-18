package com.earth2me.essentials.commands;

import static com.earth2me.essentials.I18n.tl;
import com.earth2me.essentials.Trade;
import com.earth2me.essentials.User;
import me.StevenLawson.essentials.EssentialsHandler;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

// Makes tpohere only available to admins and not available to users

public class Commandtpohere extends EssentialsCommand {
    public Commandtpohere() {
        super("tpohere");
    }

    @Override
    public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
        final User player = getPlayer(server, user, args, 0);
        if (!EssentialsHandler.isSuperAdmin(user)) {
            throw new Exception(ChatColor.RED + "Teleporting others is not enabled on this server.");
        }
        if (user.getWorld() != player.getWorld() && ess.getSettings().isWorldTeleportPermissions() && !user.isAuthorized("essentials.worlds." + user.getWorld().getName())) {
            throw new Exception(tl("noPerm", "essentials.worlds." + user.getWorld().getName()));
        }
        user.getTeleport().teleportPlayer(player, user.getBase(), new Trade(this.getName(), ess), TeleportCause.COMMAND);
        throw new NoChargeException();
    }
}
