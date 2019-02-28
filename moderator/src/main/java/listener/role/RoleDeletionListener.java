package listener.role;

import ModeratorBot.moderator.ILogMain;
import lib.factories.RoleFactory;
import listener.IStaticListener;
import net.dv8tion.jda.core.events.role.RoleDeleteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class RoleDeletionListener extends ListenerAdapter
{
	@Override
	public void onRoleDelete(RoleDeleteEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		if (RoleFactory.removeRole(event.getRole()))
		{
			log.addLogMessage(IStaticListener.ROLE_DELETION_RM_SUC, ELogMsgType.SUCCESS, this.toString(),
			        ILogMain.ROLE_DELETE);
		}
		else
		{
			log.addLogMessage(IStaticListener.ROLE_DELETION_RM_FAIL, ELogMsgType.ERROR, this.toString(),
			        ILogMain.ROLE_DELETE);
		}
	}
}
