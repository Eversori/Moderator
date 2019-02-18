
package ModeratorBot.moderator;

import commands.CmdAddRoleToMember;
import commands.CmdBanMember;
import commands.CmdKickMember;
import commands.CmdMoveMember;
import commands.CmdRemoveRoleFromMember;
import listener.CommandListener;
import listener.DirectMessageListener;
import listener.NameChangeListener;
import listener.NickNameChangeListener;
import listener.ReadyListener;
import listener.ReconnectedListener;
import listener.RoleCreationListener;
import listener.RoleDeletionListener;
import listener.ShutdownListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import util.ISecrets;

/**
 * Hello world!
 */
public class ModBot
{
	public static void main(String[] args)
	{
		JDA jda = null;
		JDABuilder builder = new JDABuilder(AccountType.BOT);

		addListener(builder);
		try
		{
			addCommands();
			builder.setToken(ISecrets.TOKEN).setAutoReconnect(true).setStatus(OnlineStatus.ONLINE);
			jda = builder.build();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void addCommands()
	{
		CommandHandler.commands.put(IStaticMain.KICK, new CmdKickMember());
		CommandHandler.commands.put(IStaticMain.MOVE, new CmdMoveMember());
		CommandHandler.commands.put(IStaticMain.BAN, new CmdBanMember());
		CommandHandler.commands.put(IStaticMain.ADD_ROLE, new CmdAddRoleToMember());
		CommandHandler.commands.put(IStaticMain.REMOVE_ROLE, new CmdRemoveRoleFromMember());
	}

	private static void addListener(JDABuilder builder)
	{
		builder.addEventListener(new CommandListener(), new DirectMessageListener(), new NameChangeListener(),
		        new NickNameChangeListener(), new ReadyListener(), new ReconnectedListener(),
		        new RoleCreationListener(), new RoleDeletionListener(), new ShutdownListener());
	}
}
