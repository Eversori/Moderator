package listener.user;

import ModeratorBot.moderator.ILogMain;
import lib.factories.MemberFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.log.LogController;
import util.log.Logger;

public class MemberJoinListener extends ListenerAdapter
{

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		if (MemberFactory.addMember(event.getMember()))
		{

		}
		else
		{
			String changedName = event.getMember();
			String msg = IStaticListener.MEMBER_JOIN_NAME_IN_USE;
		}
	}
}
