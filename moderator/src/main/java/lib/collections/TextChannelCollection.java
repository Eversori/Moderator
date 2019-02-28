
package lib.collections;

import net.dv8tion.jda.core.entities.TextChannel;

public class TextChannelCollection
{
	private Collection<String, String, TextChannel> col = null;

	public TextChannelCollection()
	{
		col = new Collection<>();
	}

	public boolean addTxtChannel(TextChannel channel)
	{
		if (channel != null)
		{
			if (!col.containsFirstKey(channel.getId()) && !col.containsSecondKey(channel.getName()))
			{
				col.add(channel, channel.getId(), channel.getName());
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	public TextChannel getTxtChannelById(String id)
	{
		if (col.containsFirstKey(id))
		{
			return col.getByFirstKey(id);
		}
		else
		{
			return null;
		}
	}

	public TextChannel getTxtChannelByName(String name)
	{
		if (col.containsSecondKey(name))
		{
			return col.getBySecondKey(name);
		}
		else
		{
			return null;
		}
	}

	public boolean containsId(String id)
	{
		if (col.containsFirstKey(id))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean containsName(String name)
	{
		if (col.containsSecondKey(name))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean removeTxtChannel(TextChannel channel)
	{
		if (channel != null)
		{
			if (col.containsFirstKey(channel.getId()))
			{
				col.remove(channel.getId(), channel.getName());
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
