package util;

import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;

public class PrivateMessageWriter
{
	private PrivateChannel channel = null;

	public PrivateMessageWriter(User user)
	{
		if (!user.hasPrivateChannel())
		{
			this.channel = user.openPrivateChannel().complete();
		}
	}

	public PrivateMessageWriter(PrivateChannel channel)
	{
		this.channel = channel;
	}

	public PrivateMessageWriter(String channelId, Event event)
	{
		channel = event.getJDA().getPrivateChannelById(channelId);
	}

	public void write(String message)
	{
		if (channel != null)
		{
			channel.sendMessage(message).queue();
		}
	}
}
