
package ModeratorBot.moderator;

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
      builder.setToken("").setAutoReconnect(true).setStatus(OnlineStatus.ONLINE);
      jda = builder.build();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
