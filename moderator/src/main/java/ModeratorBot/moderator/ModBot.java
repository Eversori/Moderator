
package ModeratorBot.moderator;

import commands.CmdAddRoleToMember;
import commands.CmdBanMember;
import commands.CmdKickMember;
import commands.CmdMoveMember;
import commands.CmdPrinLog;
import commands.CmdRemoveRoleFromMember;
import listener.CommandListener;
import listener.ReadyListener;
import listener.ReconnectedListener;
import listener.ShutdownListener;
import listener.role.RoleCreationListener;
import listener.role.RoleDeletionListener;
import listener.textChannel.TextChannelCreationListener;
import listener.textChannel.TextChannelDeletionListener;
import listener.user.MemberJoinListener;
import listener.user.NameChangeListener;
import listener.user.NickNameChangeListener;
import listener.voiceChannel.VoiceChannelCreationListener;
import listener.voiceChannel.VoiceChannelDeletionListener;
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
		CommandHandler.commands.put("log", new CmdPrinLog());
	}

	private static void addListener(JDABuilder builder)
	{
		builder.addEventListener(new CommandListener(), new NameChangeListener(), new NickNameChangeListener(),
		        new ReadyListener(), new ReconnectedListener(), new RoleCreationListener(), new RoleDeletionListener(),
		        new ShutdownListener(), new TextChannelCreationListener(), new TextChannelDeletionListener(),
		        new VoiceChannelCreationListener(), new VoiceChannelDeletionListener(), new MemberJoinListener());
	}
}
