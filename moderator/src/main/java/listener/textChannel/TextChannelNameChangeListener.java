package listener.textChannel;

import net.dv8tion.jda.core.events.channel.text.update.TextChannelUpdateNameEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TextChannelNameChangeListener extends ListenerAdapter
{
	@Override
	public void onTextChannelUpdateName(TextChannelUpdateNameEvent event)
	{
		// TODO Auto-generated method stub
		super.onTextChannelUpdateName(event);
	}
}
