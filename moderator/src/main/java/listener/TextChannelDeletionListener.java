package listener;

import net.dv8tion.jda.core.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TextChannelDeletionListener extends ListenerAdapter
{
	@Override
	public void onTextChannelDelete(TextChannelDeleteEvent event)
	{
		// TODO Auto-generated method stub
		super.onTextChannelDelete(event);
	}
}
