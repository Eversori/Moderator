package listener;

import ModeratorBot.moderator.CommandHandler;
import ModeratorBot.moderator.CommandParser;
import ModeratorBot.moderator.IStaticMain;
import lib.ModBotMember;
import lib.factories.MemberFactory;
import lib.factories.RoleFactory;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.IDiscordId;

public class CommandListener extends ListenerAdapter
{
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event)
	{
		String raw = event.getMessage().getContentDisplay();
		String authorId = event.getAuthor().getId();
		String selfId = event.getJDA().getSelfUser().getId();
		Role role = RoleFactory.getRoleById(IDiscordId.JOIN_ROLE_ID);
		ModBotMember author = MemberFactory.getMemberByID(authorId);

		if (raw.startsWith(IStaticMain.PREFIX) && !authorId.equals(selfId) && !author.hasRole(role))
		{
			CommandHandler.handleCommand(new CommandParser(raw, event));
		}
	}
}
