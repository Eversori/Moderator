package listener;

import java.io.File;
import ModeratorBot.moderator.IStaticMain;
import lib.factories.MemberFactory;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.IDiscordId;

public class ReadyListener extends ListenerAdapter
{
	@Override
	public void onReady(ReadyEvent event)
	{
		File xmlFile = new File(IStaticMain.FILE_PATH);
		Guild host = event.getJDA().getGuildById(IDiscordId.HOST_GUILD_ID);

		// XmlUtility.unmarshallFile(xmlFile, ModBotMember.class);

		MemberFactory.mapAllMember(host);
	}
}
