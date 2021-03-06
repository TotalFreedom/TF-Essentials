package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import static com.earth2me.essentials.I18n.tl;
import com.earth2me.essentials.Kit;
import com.earth2me.essentials.User;
import com.earth2me.essentials.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import org.bukkit.Server;


public class Commandkit extends EssentialsCommand
{

	public Commandkit()
	{
		super("kit");
	}

	@Override
	public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception
	{
		if (args.length < 1)
		{
			final String kitList = Kit.listKits(ess, user);
			user.sendMessage(kitList.length() > 0 ? tl("kits", kitList) : tl("noKits"));
			throw new NoChargeException();
		}
		else if (args.length > 1 && user.isAuthorized("essentials.kit.others"))
		{
			final User userTo = getPlayer(server, user, args, 1);
			final String kitNames = StringUtil.sanitizeString(args[0].toLowerCase(Locale.ENGLISH)).trim();
			giveKits(userTo, user, kitNames);
		}
		else
		{
			final String kitNames = StringUtil.sanitizeString(args[0].toLowerCase(Locale.ENGLISH)).trim();
			giveKits(user, user, kitNames);
		}
	}

	@Override
	public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception
	{
		if (args.length < 2)
		{
			final String kitList = Kit.listKits(ess, null);
			sender.sendMessage(kitList.length() > 0 ? tl("kits", kitList) : tl("noKits"));
			throw new NoChargeException();
		}
		else
		{
			final User userTo = getPlayer(server, args, 1, true, false);
			final String[] kits = args[0].toLowerCase(Locale.ENGLISH).split(",");

			for (final String kitName : kits)
			{
				final Kit kit = new Kit(kitName, ess);
				kit.expandItems(userTo);

				sender.sendMessage(tl("kitGiveTo", kitName, userTo.getDisplayName()));
				userTo.sendMessage(tl("kitReceive", kitName));
			}
		}
	}

	private void giveKits(final User userTo, final User userFrom, final String kitNames) throws Exception
	{
		if (kitNames.isEmpty())
		{
			throw new Exception(tl("kitNotFound"));
		}
		String[] kitList = kitNames.split(",");

		List<Kit> kits = new ArrayList<Kit>();

		for (final String kitName : kitList)
		{
			if (kitName.isEmpty())
			{
				throw new Exception(tl("kitNotFound"));
			}

			Kit kit = new Kit(kitName, ess);
			kit.checkPerms(userFrom);
			kit.checkDelay(userFrom);
			kit.checkAffordable(userFrom);
			kits.add(kit);
		}

		for (final Kit kit : kits)
		{
			try
			{

				kit.checkDelay(userFrom);
				kit.checkAffordable(userFrom);
				kit.setTime(userFrom);
				kit.expandItems(userTo);
				kit.chargeUser(userTo);

				if (!userFrom.equals(userTo))
				{
					userFrom.sendMessage(tl("kitGiveTo", kit.getName(), userTo.getDisplayName()));
				}

				userTo.sendMessage(tl("kitReceive", kit.getName()));

			}
			catch (NoChargeException ex)
			{
				if (ess.getSettings().isDebug())
				{
					ess.getLogger().log(Level.INFO, "Soft kit error, abort spawning " + kit.getName(), ex);
				}
			}
			catch (Exception ex)
			{
				ess.showError(userFrom.getSource(), ex, "\\ kit: " + kit.getName());
			}
		}
	}
}
