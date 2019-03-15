package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import util.log.LogController;

public class CmdPrinLog implements Command
{

	@Override
	public boolean called(String[] args, GuildMessageReceivedEvent event)
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action(String[] args, GuildMessageReceivedEvent event)
	{
		// TODO Auto-generated method stub
		LogController.printLogs();
	}

	@Override
	public void executed(boolean success, GuildMessageReceivedEvent event)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
