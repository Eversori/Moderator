package listener;

import ModeratorBot.moderator.ILogMain;
import factories.MemberFactory;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;
import util.IDiscordId;
import util.PrivateMessageWriter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class NameChangeListener extends ListenerAdapter
{
	@Override
	public void onUserUpdateName(UserUpdateNameEvent event)
	{
		PrivateMessageWriter writer = new PrivateMessageWriter(event.getEntity());
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);
		GuildController controller = event.getJDA().getGuildById(IDiscordId.HOST_GUILD_ID).getController();
		Member member = null;
		String msg = "";
		String newName = event.getNewName();
		String oldName = event.getOldName();
		String id = event.getEntity().getId();

		member = MemberFactory.getMemberByID(id).getMember();

		if (MemberFactory.changeName(id, newName))
		{
			msg = oldName + IStaticListener.NAME_CHANGE_SUC + newName;
			log.addLogMessage(msg, ELogMsgType.SUCCESS, this.toString(), ILogMain.NAME_CHANGE);
		}
		else
		{
			controller.setNickname(member, oldName);

			msg = newName + IStaticListener.NAME_CHANGE_IN_USE;
			writer.write(msg);
			log.addLogMessage(msg, ELogMsgType.ERROR, this.toString(), ILogMain.NAME_CHANGE);

			msg = IStaticListener.NAME_CHANGE_TAKE_OTHER;
			writer.write(msg);
		}
	}
}
