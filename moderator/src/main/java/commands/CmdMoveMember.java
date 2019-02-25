
package commands;

import factories.MemberFactory;
import factories.VoiceChannelFactory;
import lib.ModBotMember;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class CmdMoveMember implements Command {
  Logger logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);

  //!move channel member member 2 member 3 ...
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    boolean bool = false;
    if (mbm != null) {
      if (VoiceChannelFactory.getVoiceChannelByName(args[0]) != null)
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
      for (int i = 1; i <= args.length; i++) {
        gc.moveVoiceMember(MemberFactory.getMemberByEName(args[i]).getMember(), VoiceChannelFactory.getVoiceChannelByName(args[0]));
      }
      String namen = null;
      for (int i = 1; i <= args.length; i++) {
        namen = namen + " " + args[i];
      }
      writer.writeInfo(namen + " were moved to " + args[0] + ".");
    } catch (Exception e) {
      e.printStackTrace();
    }
    writer = null;
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_MOVE_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_MOVE_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
