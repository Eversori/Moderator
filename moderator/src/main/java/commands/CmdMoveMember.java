
package commands;

import factories.MemberFactory;
import lib.ModBotMember;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;
import util.log.LogController;
import util.log.Logger;

public class CmdMoveMember implements Command {
  Logger logger = LogController.getLogger(ILogCommand.LOG_ID, ILogCommand.NAME);

  //!move channel member ....
  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    ModBotMember mbm = MemberFactory.getMemberByID(event.getAuthor().getId());
    boolean bool = false;
    if (mbm != null) {
      if (args.length >= 2 && args.length <= 7) {
        bool = true;
      }
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {
    GuildController gc = event.getGuild().getController();

    for (int i = 1; i <= args.length; i++) {
      //TODO
      //gc.moveVoiceMember(MemberFactory.getMemberByEName(args[i]), args[0]);
    }
  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    // TODO Auto-generated method stub

  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
