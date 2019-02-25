
package commands;

import factories.MemberFactory;
import lib.ModBotMember;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.IDiscordId;
import util.log.ELogMsgType;
import util.log.LogController;
import util.log.Logger;

public class CmdKickMember implements Command {
  Logger logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);

  //!Kick member
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    boolean bool = false;
    if (mbm != null) {
      if (event.getChannel().getMembers().contains(MemberFactory.getMemberByEName(args[0]).getMember()))
        if (args.length >= 1 && args.length <= 5) {
          bool = true;
        }
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {
    try {
      Channel channel = event.getChannel();
      GuildController gc = event.getGuild().getController();
      int i = 0;
      // channel.getMembers().stream().filter(item -> item.getEffectiveName().equals(anObject)).findAny().isPresent();
      for (Member m : channel.getMembers()) {
        if (m.getEffectiveName().equals(args[i++])) {
          gc.moveVoiceMember(m, event.getGuild().getVoiceChannelById(IDiscordId.KICK_CHANNEL_ID));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    if (success) {
      logger.addLogMessage(ILogCommand.CMD_KICK_SUCCESS, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    } else {
      logger.addLogMessage(ILogCommand.CMD_KICK_FAILED, ELogMsgType.STATE, this.toString(), ILogCommand.CMD_EXE);
    }
  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
