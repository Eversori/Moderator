
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

public class CmdRemoveRoleFromMember implements Command {

  Logger logger = null;
  DiscordWriter writer = null;

  // !Remove role member
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    writer = new DiscordWriter(event.getChannel());
    boolean bool = false;
    if (mbm != null) {
      if (mbm.hasRole(RoleFactory.getRoleById(IDiscordId.ADM_ROLE_ID))) {
        if (RoleFactory.getRoleByName(args[0]) != null) {
          if (args.length >= 2 && args.length <= 2) {
            if (MemberFactory.getMemberByEName(args[1]) != null) {
              if (MemberFactory.getMemberByEName(args[1]).hasRole(RoleFactory.getRoleByName(args[0]))) {
                bool = true;
              } else {
                writer.writeError(IStaticCommand.CMD_REMOVE_ROLE_MEMBER_HAS_ROLE);
                logger.addState(IStaticCommand.CMD_REMOVE_ROLE_MEMBER_HAS_ROLE, this.toString());
              }
            } else {
              writer.writeError(args[1] + IStaticCommand.CMD_REMOVE_ROLE_MEMBER_DONT_EXISTS);
              logger.addState(args[1] + IStaticCommand.CMD_REMOVE_ROLE_MEMBER_DONT_EXISTS, this.toString());
            }
          } else {
            writer.writeError(IStaticCommand.CMD_REMOVE_ROLE_WRONG_PATTERN);
            logger.addState(IStaticCommand.CMD_REMOVE_ROLE_WRONG_PATTERN, this.toString());
          }
        } else {
          writer.writeError(args[0] + IStaticCommand.CMD_REMOVE_ROLE_DONT_EXISTS);
          logger.addState(args[0] + IStaticCommand.CMD_REMOVE_ROLE_DONT_EXISTS, this.toString());
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
      gc.removeSingleRoleFromMember(MemberFactory.getMemberByEName(args[1]).getMember(), RoleFactory.getRoleByName(args[0])).queue();
      writer.writeInfo(args[0] + IStaticCommand.CMD_REMOVE_ROLE_SUC + args[1] + ".");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_REMOVE_ROLE_FROM_MEMBER_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_REMOVE_ROLE_FROM_MEMBER_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
    writer = null;
    logger = null;
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
