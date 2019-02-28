
package commands;

import lib.ModBotMember;
import lib.factories.MemberFactory;
import lib.factories.VoiceChannelFactory;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class CmdMoveMember implements Command {
  Logger logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);
  DiscordWriter writer = null;

  //!move channel member member 2 member 3 ...
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    writer = new DiscordWriter(event.getChannel());
    boolean bool = false;
    if (mbm != null) {
      if (VoiceChannelFactory.getVoiceChannelByName(args[0]) != null) {
        if (args.length >= 2 && args.length <= 7) {
          if (MemberFactory.list(args)) {
            bool = true;
          } else {
            writer.writeError(IStaticCommand.CMD_MOVE_MEMBER_DONT_EXIST);
            logger.addState(IStaticCommand.CMD_MOVE_MEMBER_DONT_EXIST, this.toString());
          }
        } else {
          writer.writeError(IStaticCommand.CMD_MOVE_WRONG_PATTERN);
          logger.addState(IStaticCommand.CMD_MOVE_WRONG_PATTERN, this.toString());
          bool = false;
        }
      } else {
        writer.writeError(args[0] + IStaticCommand.CMD_MOVE_CHANNEL_DONT_EXISTS);
        logger.addState(IStaticCommand.CMD_MOVE_CHANNEL_DONT_EXISTS, this.toString());
        bool = false;
      }
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {
    GuildController gc = event.getGuild().getController();
    StringBuilder namen = new StringBuilder();
    try {
      for (int i = 1; i <= args.length; i++) {
        gc.moveVoiceMember(MemberFactory.getMemberByEName(args[i]).getMember(), VoiceChannelFactory.getVoiceChannelByName(args[0]));
        namen.append(args[i]);
      }
      writer.writeInfo(namen + IStaticCommand.CMD_MOVE_SUC + args[0] + ".");
      logger.addState(namen + IStaticCommand.CMD_MOVE_SUC + args[0] + ".", this.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_MOVE_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_MOVE_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
    writer = null;
    logger = null;
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
