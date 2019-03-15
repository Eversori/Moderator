package listener;

import lib.factories.MemberFactory;
import lib.factories.RoleFactory;
import lib.factories.TextChannelFactory;
import lib.factories.VoiceChannelFactory;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.IDiscordId;

public class ReadyListener extends ListenerAdapter
{
	@Override
	public void onReady(ReadyEvent event)
	{
		System.out.println("hi");
		Guild host = event.getJDA().getGuildById(IDiscordId.HOST_GUILD_ID);

		MemberFactory.mapAllMember(host);
		RoleFactory.mapAllRoles(host);
		TextChannelFactory.mapAllTextChannels(host);
		VoiceChannelFactory.mapAllVoiceChannels(host);
	}
}
