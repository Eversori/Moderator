package listener;

import ModeratorBot.moderator.ILogMain;
import lib.factories.RoleFactory;
import net.dv8tion.jda.core.events.role.RoleCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class RoleCreationListener extends ListenerAdapter
{
	@Override
	public void onRoleCreate(RoleCreateEvent event)
	{
		Logger log = LogController.getLogger(ILogMain.NUM, ILogMain.NAME);

		if (RoleFactory.addRole(event.getRole()))
		{
			log.addLogMessage(IStaticListener.ROLE_CREATION_ADD_SUC, ELogMsgType.SUCCESS, this.toString(),
			        ILogMain.ROLE_CREATE);
		}
		else
		{
			log.addLogMessage(IStaticListener.ROLE_CREATION_ADD_FAIL, ELogMsgType.ERROR, this.toString(),
			        ILogMain.ROLE_CREATE);
		}
	}
}
