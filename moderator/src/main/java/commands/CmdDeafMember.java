
package commands;

import lib.ModBotMember;
import lib.factories.MemberFactory;
import lib.factories.RoleFactory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.IDiscordId;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

//!deaf member
public class CmdDeafMember implements Command {
  private Logger logger = null;
  private DiscordWriter writer = null;

  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);
    writer = new DiscordWriter(event.getChannel());
    boolean bool = false;
    if (mbm != null) {
      if (mbm.hasRole(RoleFactory.getRoleById(IDiscordId.ADM_ROLE_ID)) || mbm.hasRole(RoleFactory.getRoleById(IDiscordId.MOD_ROLE_ID))) {
        if (MemberFactory.getMemberByEName(args[0]) != null) {
          if (args.length >= 1) {
            bool = true;
          } else {
            writer.writeError(IStaticCommand.CMD_DEAF_WRONG_PATTERN);
            logger.addState(IStaticCommand.CMD_DEAF_WRONG_PATTERN, this.toString());
          }
        } else {
          writer.writeError(args[0] + IStaticCommand.CMD_DEAF_MEMBER_DONT_EXIST);
          logger.addState(args[0] + IStaticCommand.CMD_DEAF_MEMBER_DONT_EXIST, this.toString());
        }
      } else {
        writer.writeError(IStaticCommand.CMD_PERM);
        logger.addState(IStaticCommand.CMD_PERM, this.toString());
      }
    } else {
      writer.writeError(IStaticCommand.CMD_MEMBER_ERROR);
      logger.addState(IStaticCommand.CMD_MEMBER_ERROR, this.toString());
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {
    GuildController gc = event.getGuild().getController();
    try {
      gc.setDeafen(MemberFactory.getMemberByEName(args[0]).getMember(), true).queue();
      writer.writeInfo(args[0] + IStaticCommand.CMD_DEAF_SUC);
      logger.addState(args[0] + IStaticCommand.CMD_DEAF_SUC, this.toString());
    } catch (Exception e) {
      logger.addException(e.getMessage(), this.toString(), ILogCommand.CMD_EXE);
    }
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_DEAF_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_DEAF_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
    writer = null;
    logger = null;
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
