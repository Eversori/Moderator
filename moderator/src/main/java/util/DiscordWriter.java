
package util;

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class DiscordWriter
{

	private TextChannel					channel		= null;
	private GuildMessageReceivedEvent	event		= null;
	private EmbedBuilder				embedout	= null;
	private static Color				warning		= Color.RED;
	private static Color				info		= Color.ORANGE;
	private static Color				success		= Color.GREEN;

	public DiscordWriter(TextChannel channel)
	{
		this.channel = channel;
	}

	public DiscordWriter(GuildMessageReceivedEvent event)
	{
		this.channel = event.getChannel();
		this.event = event;
	}

	/**
	 * Writes an Error-Message in the Error-Message-Color. Standard = Red
	 * 
	 * @param msg
	 */
	public void writeError(String msg)
	{
		embedout = new EmbedBuilder().setColor(warning);
		embedout.setDescription(msg);
		channel.sendMessage(embedout.build()).queue();
		embedout = null;
	}

	/**
	 * Writes a Success-Message in the Success-Message-Color. Standard = Green
	 * 
	 * @param msg
	 */
	public void writeSuccess(String msg)
	{
		embedout = new EmbedBuilder().setColor(success);
		embedout.setDescription(msg);
		channel.sendMessage(embedout.build()).queue();
		embedout = null;
	}

	/**
	 * Writes an Info-Message in the Info-Message-Color. Standard = Orange
	 * 
	 * @param msg
	 */
	public void writeInfo(String msg)
	{
		embedout = new EmbedBuilder().setColor(info);
		embedout.setDescription(msg);
		channel.sendMessage(embedout.build()).queue();
		embedout = null;
	}

	/**
	 * writes a message not embed
	 * 
	 * @param msg
	 */
	public void writeNotEmbed(String msg)
	{
		channel.sendMessage(msg).queue();
	}

	/**
	 * Writes a custom-colored Message
	 * 
	 * @param msg
	 * @param c
	 */
	public void writeCustomColored(String msg, Color c)
	{
		embedout = new EmbedBuilder().setColor(c);
		embedout.setDescription(msg);
		channel.sendMessage(embedout.build()).queue();
		embedout = null;
	}

	public GuildMessageReceivedEvent getEvent()
	{
		return event;
	}

	private void setEvent(GuildMessageReceivedEvent event)
	{
		this.event = event;
	}

	public TextChannel getChannel()
	{
		return channel;
	}
}