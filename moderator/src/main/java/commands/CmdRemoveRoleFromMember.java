
package commands;

import factories.MemberFactory;
import factories.RoleFactory;
import lib.ModBotMember;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CmdRemoveRoleFromMember implements Command {

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
    // TODO Auto-generated method stub

  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    // TODO Auto-generated method stub

  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
