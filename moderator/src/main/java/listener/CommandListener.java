package listener;

import ModeratorBot.moderator.CommandHandler;
import ModeratorBot.moderator.CommandParser;
import ModeratorBot.moderator.IStaticMain;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter
{
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event)
	{
		String raw = event.getMessage().getContentDisplay();
		String authorId = event.getAuthor().getId();
		String selfId = event.getJDA().getSelfUser().getId();

		if (raw.startsWith(IStaticMain.PREFIX) && !authorId.equals(selfId))
		{
			CommandHandler.handleCommand(new CommandParser(raw));
		}
	}
}
