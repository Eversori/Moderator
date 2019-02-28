package listener.voiceChannel;

import ModeratorBot.moderator.ILogMain;
import lib.factories.VoiceChannelFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class VoiceChannelDeletionListener extends ListenerAdapter
{
	@Override
	public void onVoiceChannelDelete(VoiceChannelDeleteEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		if (VoiceChannelFactory.removeVoiceChannel(event.getChannel()))
		{
			log.addLogMessage(IStaticListener.VC_CHANNEL_DELETION_RM_SUC, ELogMsgType.SUCCESS, this.toString(),
			        ILogMain.VC_CH_DELETE);
		}
		else
		{
			log.addLogMessage(IStaticListener.VC_CHANNEL_DELETION_RM_FAIL, ELogMsgType.ERROR, this.toString(),
			        ILogMain.VC_CH_DELETE);
		}
	}
}
