
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

public class CmdKickMember implements Command {
  Logger logger = null;
  DiscordWriter writer = null;

  // !Kick member
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);
    writer = new DiscordWriter(event.getChannel());
    boolean bool = false;
    if (mbm != null) {
      if (MemberFactory.getMemberByEName(args[0]) != null) {
        if (mbm.hasRole(RoleFactory.getRoleById(IDiscordId.ADM_ROLE_ID)) || mbm.hasRole(RoleFactory.getRoleById(IDiscordId.MOD_ROLE_ID))) {
          if (args.length >= 1) {
            bool = true;
          } else {
            writer.writeError(IStaticCommand.CMD_KICK_WRONG_PATTERN);
            logger.addState(IStaticCommand.CMD_KICK_WRONG_PATTERN, this.toString());
          }
        } else {
          writer.writeError(IStaticCommand.CMD_PERM);
          logger.addState(IStaticCommand.CMD_PERM, this.toString());
        }
      } else {
        writer.writeError(args[0] + IStaticCommand.CMD_KICK_MEMBER_DONT_EXISTS);
        logger.addState(args[0] + IStaticCommand.CMD_KICK_MEMBER_DONT_EXISTS, this.toString());
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
      gc.moveVoiceMember(MemberFactory.getMemberByEName(args[0]).getMember(), event.getGuild().getVoiceChannelById(IDiscordId.KICK_CHANNEL_ID)).queue();
      writer.writeInfo(args[0] + IStaticCommand.CMD_KICK_SUC);
      logger.addState(args[0] + IStaticCommand.CMD_KICK_SUC, this.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
    writer = null;
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_KICK_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_KICK_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
    writer = null;
    logger = null;
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
