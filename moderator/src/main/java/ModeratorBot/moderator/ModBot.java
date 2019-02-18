
package ModeratorBot.moderator;

import commands.CmdAddRoleToMember;
import commands.CmdBanMember;
import commands.CmdKickMember;
import commands.CmdMoveMember;
import commands.CmdRemoveRoleFromMember;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

/**
 * Hello world!
 */
public class ModBot {
  public static void main(String[] args) {
    JDA jda = null;
    JDABuilder builder = new JDABuilder(AccountType.BOT);
    try {
      addCommands();
      builder.setToken("").setAutoReconnect(true).setStatus(OnlineStatus.ONLINE);
      jda = builder.build();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void addCommands() {
    CommandHandler.commands.put(IStaticMain.KICK, new CmdKickMember());
    CommandHandler.commands.put(IStaticMain.MOVE, new CmdMoveMember());
    CommandHandler.commands.put(IStaticMain.BAN, new CmdBanMember());
    CommandHandler.commands.put(IStaticMain.ADD_ROLE, new CmdAddRoleToMember());
    CommandHandler.commands.put(IStaticMain.REMOVE_ROLE, new CmdRemoveRoleFromMember());
  }
}
