
package lib.factories;

import lib.collections.TextChannelCollection;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

public class TextChannelFactory {
  private static TextChannelCollection textChannelC = new TextChannelCollection();

  public static void mapAllTextChannels(Guild guild) {
    for (TextChannel tc : guild.getTextChannels()) {
      textChannelC.addTxtChannel(tc);
    }
  }

  public static TextChannel getTxtChannelById(String id) {
    if (textChannelC.containsId(id)) {
      return textChannelC.getTxtChannelById(id);
    } else {
      return null;
    }
  }

  public static TextChannel getTxtChannelByName(String name) {
    if (textChannelC.containsName(name)) {
      return textChannelC.getTxtChannelByName(name);
    } else {
      return null;
    }
  }
}
