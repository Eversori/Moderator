
package commands;

import factories.MemberFactory;
import factories.RoleFactory;
import lib.ModBotMember;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class CmdRemoveRoleFromMember implements Command {

  Logger logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);

  //!Remove role member
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    boolean bool = false;
    if (mbm != null) {
      if (RoleFactory.getRoleByName(args[0]) != null)
        if (args.length >= 2 && args.length <= 7) {
          bool = true;
        }
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {
    GuildController gc = event.getGuild().getController();
    DiscordWriter writer = new DiscordWriter(event.getChannel());
    try {
      gc.removeSingleRoleFromMember(MemberFactory.getMemberByEName(args[1]).getMember(), RoleFactory.getRoleByName(args[0]));
      writer.writeInfo(args[0] + " was successfully removed from " + args[1] + ".");
    } catch (Exception e) {
      e.printStackTrace();
    }
    writer = null;
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_REMOVE_ROLE_FROM_MEMBER_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_REMOVE_ROLE_FROM_MEMBER_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
