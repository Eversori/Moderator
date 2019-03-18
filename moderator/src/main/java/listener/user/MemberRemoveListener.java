package listener.user;

import lib.factories.MemberFactory;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MemberRemoveListener extends ListenerAdapter
{

	@Override
	public void onGuildMemberLeave(GuildMemberLeaveEvent event)
	{
		// TODO Auto-generated method stub
		super.onGuildMemberLeave(event);
		MemberFactory.removeMember(event.getMember());
	}
}
