
package commands;

import factories.MemberFactory;
import lib.ModBotMember;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.DiscordWriter;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class CmdBanMember implements Command {
  Logger logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);

  //!Ban member (reason)
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    boolean bool = false;
    if (mbm != null) {
      if (MemberFactory.getMemberByEName(args[0]) != null)
        if (args.length >= 1 && args.length <= 10) {
          bool = true;
        }
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {
    GuildController gc = event.getGuild().getController();
    DiscordWriter writer = new DiscordWriter(event.getChannel());
    String reason = null;
    try {
      if (args.length >= 2) {
        for (int i = 1; i <= args.length; i++) {
          reason = reason + " " + args[i];
        }
        gc.ban(MemberFactory.getMemberByEName(args[0]).getMember(), 1, reason);
      } else {
        gc.ban(MemberFactory.getMemberByEName(args[0]).getMember(), 1);
      }
      writer.writeInfo(args[0] + " was successfully banned.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    writer = null;
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_BAN_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_BAN_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
