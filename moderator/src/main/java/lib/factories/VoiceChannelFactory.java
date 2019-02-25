
package lib.factories;

import lib.collections.VoiceChannelCollection;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;

public class VoiceChannelFactory {
  private static VoiceChannelCollection voiceChannelC = new VoiceChannelCollection();

  public static void mapAllVoiceChannels(Guild guild) {
    for (VoiceChannel vc : guild.getVoiceChannels()) {
      voiceChannelC.addVoiceChannel(vc);
    }
  }

  public static VoiceChannel getVoiceChannelById(String id) {
    if (voiceChannelC.containsId(id)) {
      return voiceChannelC.getVoiceChannelById(id);
    } else {
      return null;
    }
  }

  public static VoiceChannel getVoiceChannelByName(String name) {
    if (voiceChannelC.containsName(name)) {
      return voiceChannelC.getVoiceChannelByName(name);
    } else {
      return null;
    }
  }
}
