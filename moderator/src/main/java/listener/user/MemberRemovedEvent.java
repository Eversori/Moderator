package listener.user;

import lib.factories.MemberFactory;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MemberRemovedEvent extends ListenerAdapter
{
	@Override
	public void onGuildMemberLeave(GuildMemberLeaveEvent event)
	{
		MemberFactory.removeMember(event.getMember());
	}

}
