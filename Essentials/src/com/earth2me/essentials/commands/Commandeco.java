package com.earth2me.essentials.commands;

import com.earth2me.essentials.ChargeException;
import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.User;
import com.earth2me.essentials.utils.NumberUtil;
import net.ess3.api.MaxMoneyException;
import org.bukkit.Server;

import java.math.BigDecimal;
import java.util.Locale;

import static com.earth2me.essentials.I18n.tl;
import org.bukkit.ChatColor;


public class Commandeco extends EssentialsLoopCommand {
    BigDecimal amount;

    public Commandeco() {
        super("eco");
    }

    @Override
    public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
		sender.sendMessage(ChatColor.DARK_RED + "Essentials economy has been disabled in the config.");
    }

	@Override
	protected void updatePlayer(Server server, CommandSource sender, User user, String[] args) throws NotEnoughArgumentsException, PlayerExemptException, ChargeException, MaxMoneyException
	{
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}