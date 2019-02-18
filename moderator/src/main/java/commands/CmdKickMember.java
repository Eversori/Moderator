
package commands;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CmdKickMember implements Command {

  public boolean called(String[] args, GuildMessageReceivedEvent event) {
    boolean bool = false;
    if (args.length >= 1 && args.length <= 5) {
      bool = true;
    }
    return bool;
  }

  public void action(String[] args, GuildMessageReceivedEvent event) {

  }

  public void executed(boolean success, GuildMessageReceivedEvent event) {
    // TODO Auto-generated method stub

  }

  public String help() {
    // TODO Auto-generated method stub
    return null;
  }

}
