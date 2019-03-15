package listener.user;

import ModeratorBot.moderator.ILogMain;
import lib.factories.MemberFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;
import util.IDiscordId;
import util.PrivateMessageWriter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class MemberJoinListener extends ListenerAdapter
{

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		Member member = event.getMember();
		PrivateMessageWriter pmWrite = new PrivateMessageWriter(member.getUser().openPrivateChannel().complete());
		GuildController controller = event.getGuild().getController();
		Role joinRole = event.getGuild().getRoleById(IDiscordId.JOIN_ROLE_ID);

		if (!MemberFactory.contains(member))
		{
			if (MemberFactory.getMemberByEName(member.getEffectiveName()) != null)
			{
				String changedName = member.getEffectiveName() + IStaticListener.MEMBER_JOIN_NAME_CHANGE;
				String msg = IStaticListener.MEMBER_JOIN_NAME_IN_USE + changedName;
				log.addLogMessage(msg, ELogMsgType.INFO, this.toString(), ILogMain.MEMBER_JOIN);
				pmWrite.write(msg);
				controller.setNickname(member, changedName);
				MemberFactory.addMember(member);
			}
			controller.addSingleRoleToMember(member, joinRole);
			MemberFactory.addRoleToMember(member, joinRole);

			log.addState(IStaticListener.MEMBER_JOIN_ROLE_ADDED, this.toString());
		}
	}
}
