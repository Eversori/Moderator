package listener.voiceChannel;

import ModeratorBot.moderator.ILogMain;
import lib.factories.VoiceChannelFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.DiscordWriter;
import util.IDiscordId;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class VoiceChannelCreationListener extends ListenerAdapter
{
	@Override
	public void onVoiceChannelCreate(VoiceChannelCreateEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);
		VoiceChannel channel = event.getChannel();
		DiscordWriter writer = new DiscordWriter(event.getGuild().getTextChannelById(IDiscordId.BOT_CHANNEL_ID));

		if (VoiceChannelFactory.getVoiceChannelByName(channel.getName()) == null)
		{
			if (VoiceChannelFactory.addVoiceChannel(channel))
			{
				log.addLogMessage(IStaticListener.VC_CHANNEL_CREATION_ADD_SUC, ELogMsgType.SUCCESS, this.toString(),
				        ILogMain.VC_CH_CREATE);
			}
			else
			{
				log.addLogMessage(IStaticListener.VC_CHANNEL_CREATION_ADD_FAIL, ELogMsgType.ERROR, this.toString(),
				        ILogMain.VC_CH_CREATE);
			}
		}
		else
		{
			log.addLogMessage(IStaticListener.VC_CHANNEL_NAME_IN_USE, ELogMsgType.ERROR, this.toString(),
			        ILogMain.VC_CH_CREATE);
			writer.writeError(IStaticListener.VC_CHANNEL_NAME_IN_USE);
			channel.delete().queue();
			log.addState(IStaticListener.VC_CHANNEL_DELETED, this.toString());
		}
	}
}
