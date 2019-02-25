package listener;

import ModeratorBot.moderator.ILogMain;
import factories.MemberFactory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.IDiscordId;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class NickNameChangeListener extends ListenerAdapter
{
	@Override
	public void onGuildMemberNickChange(GuildMemberNickChangeEvent event)
	{
		DiscordWriter writer = null;
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);
		String newName = event.getNewNick();
		String oldName = event.getPrevNick();
		String id = event.getMember().getUser().getId();
		String msg = "";
		GuildController controller = event.getGuild().getController();
		TextChannel txt = event.getGuild().getTextChannelById(IDiscordId.BOT_CHANNEL_ID);
		User user = event.getUser();

		if (oldName == null)
		{
			oldName = user.getName();
		}

		if (newName == null)
		{
			newName = user.getName();
		}

		writer = DiscordWriter.createWriter(writer, txt);

		if (MemberFactory.changeName(id, newName))
		{
			msg = IStaticListener.NICK_CHANGE_USER + oldName + IStaticListener.NICK_CHANGE_CALLS_HIMSELF + newName;
			writer.writeInfo(msg);
			log.addLogMessage(msg, ELogMsgType.SUCCESS, this.toString(), ILogMain.NICK_CHANGE);
		}
		else
		{
			controller.setNickname(event.getMember(), oldName);
			msg = IStaticListener.NICK_CHANGE_NICK + newName + IStaticListener.NICK_CHANGE_IN_USE;
			writer.writePrivate(msg, user);
			log.addLogMessage(msg, ELogMsgType.ERROR, this.toString(), ILogMain.NICK_CHANGE);

			msg = IStaticListener.NICK_CHANGE_TAKE_OTHER;
			writer.writePrivate(msg, user);
		}

	}
}
