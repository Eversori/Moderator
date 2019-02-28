package listener.textChannel;

import ModeratorBot.moderator.ILogMain;
import lib.factories.TextChannelFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class TextChannelCreationListener extends ListenerAdapter
{
	@Override
	public void onTextChannelCreate(TextChannelCreateEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		if (TextChannelFactory.addChannel(event.getChannel()))
		{
			log.addLogMessage(IStaticListener.TEXT_CHANNEL_CREATION_ADD_SUC, ELogMsgType.SUCCESS, this.toString(),
			        ILogMain.TXT_CH_CREATE);
		}
		else
		{
			log.addLogMessage(IStaticListener.TEXT_CHANNEL_CREATION_ADD_FAIL, ELogMsgType.ERROR, this.toString(),
			        ILogMain.TXT_CH_CREATE);
		}
	}
}
