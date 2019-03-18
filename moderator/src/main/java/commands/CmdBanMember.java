
package commands;

import lib.ModBotMember;
import lib.factories.MemberFactory;
import lib.factories.RoleFactory;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.IDiscordId;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class CmdBanMember implements Command
{
	Logger			logger	= null;
	DiscordWriter	writer	= null;

	// !Ban member (reason)
	public boolean called(String[] args, GuildMessageReceivedEvent event)
	{
		ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
		logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);
		writer = new DiscordWriter(event.getChannel());
		boolean bool = false;
		if (mbm != null)
		{
			if (mbm.hasRole(RoleFactory.getRoleById(IDiscordId.ADM_ROLE_ID))
			        || mbm.hasRole(RoleFactory.getRoleById(IDiscordId.MOD_ROLE_ID)))
			{
				if (MemberFactory.getMemberByEName(args[0]) != null)
				{
					if (args.length >= 1 && args.length <= 10)
					{
						bool = true;
					}
					else
					{
						writer.writeError(IStaticCommand.CMD_BAN_WRONG_PATTERN);
						logger.addState(ILogCommand.CMD_BAN_FAILED, this.toString());
					}
				}
				else
				{
					writer.writeError(args[0] + IStaticCommand.CMD_BAN_MEMBER_DONT_EXIST);
					logger.addState(ILogCommand.CMD_BAN_FAILED, this.toString());
				}
			}
			else
			{
				writer.writeError(IStaticCommand.CMD_PERM);
				logger.addState(IStaticCommand.CMD_PERM, this.toString());
			}
		}
		else
		{
			writer.writeError(IStaticCommand.CMD_MEMBER_ERROR);
			logger.addState(IStaticCommand.CMD_MEMBER_ERROR, this.toString());
		}
		return bool;
	}

	public void action(String[] args, GuildMessageReceivedEvent event)
	{
		GuildController gc = event.getGuild().getController();
		String reason = null;
		Member member = MemberFactory.getMemberByEName(args[0]).getMember();
		try
		{
			if (args.length > 2)
			{
				for (int i = 1; i < args.length; i++)
				{
					reason = reason + " " + args[i];
				}
				gc.ban(member, 1, reason).queue();
				gc.kick(member).queue();
			}
			else
			{
				gc.ban(member, 1).queue();
				gc.kick(member).queue();
			}
			writer.writeInfo(args[0] + IStaticCommand.CMD_BAN_SUC);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		writer = null;
	}

	public void executed(boolean success, GuildMessageReceivedEvent event)
	{
		if (success)
		{
			logger.addLogMessage(ILogCommand.CMD_BAN_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
		}
		else
		{
			logger.addLogMessage(ILogCommand.CMD_BAN_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
		}
		writer = null;
		logger = null;
	}

	public String help()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
