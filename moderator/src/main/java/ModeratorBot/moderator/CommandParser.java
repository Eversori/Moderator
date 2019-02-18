package ModeratorBot.moderator;

import java.util.ArrayList;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CommandParser
{
	private String						beheaded	= "";
	private String[]					args		= null;
	private String						invoke		= "";
	private GuildMessageReceivedEvent	event		= null;

	public CommandParser(String raw)
	{
		this.parse(raw);
	}

	/**
	 * parsing of a command String
	 * 
	 * @param raw
	 */
	private void parse(String raw)
	{
		beheaded = raw.replaceFirst(IStaticMain.PREFIX, "");

		String beheadedSplit[] = beheaded.split(" ");

		invoke = beheadedSplit[0];

		args = new String[beheadedSplit.length - 1];

		ArrayList<String> split = new ArrayList<String>();

		for (String s : beheadedSplit)
		{
			split.add(s);
		}

		split.subList(1, split.size()).toArray(args);
	}

	public String getBeheaded()
	{
		return beheaded;
	}

	public String[] getArgs()
	{
		return args;
	}

	public String getInvoke()
	{
		return invoke;
	}

	public GuildMessageReceivedEvent getEvent()
	{
		return event;
	}

}
