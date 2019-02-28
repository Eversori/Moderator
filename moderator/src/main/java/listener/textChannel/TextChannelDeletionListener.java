package listener.textChannel;

import ModeratorBot.moderator.ILogMain;
import lib.factories.TextChannelFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class TextChannelDeletionListener extends ListenerAdapter
{
	@Override
	public void onTextChannelDelete(TextChannelDeleteEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		if (TextChannelFactory.removeChannel(event.getChannel()))
		{
			log.addLogMessage(IStaticListener.TEXT_CHANNEL_DELETION_RM_SUC, ELogMsgType.SUCCESS, this.toString(),
			        ILogMain.TXT_CH_DELETE);
		}
		else
		{
			log.addLogMessage(IStaticListener.TEXT_CHANNEL_DELETION_RM_FAIL, ELogMsgType.ERROR, this.toString(),
			        ILogMain.TXT_CH_DELETE);
		}
	}
}
