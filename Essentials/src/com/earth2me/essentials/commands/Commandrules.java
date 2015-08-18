package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import com.earth2me.essentials.textreader.IText;
import com.earth2me.essentials.textreader.KeywordReplacer;
import com.earth2me.essentials.textreader.TextInput;
import com.earth2me.essentials.textreader.TextPager;
import org.bukkit.ChatColor;
import org.bukkit.Server;


public class Commandrules extends EssentialsCommand {
    public Commandrules() {
        super("rules");
    }

    @Override
    public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
        if (sender.isPlayer()) {
            ess.getUser(sender.getPlayer()).setDisplayNick();
        }
		
		sender.sendMessage(ChatColor.GOLD + "=========================");
		sender.sendMessage("Rules can be found at http://totalfreedom.me/");
		sender.sendMessage(ChatColor.GOLD + "=========================");
    }
}
