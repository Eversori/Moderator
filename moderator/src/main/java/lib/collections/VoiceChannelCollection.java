
package lib.collections;

import net.dv8tion.jda.core.entities.VoiceChannel;

public class VoiceChannelCollection {
  private Collection<String, String, VoiceChannel> col;

  public VoiceChannelCollection() {
    col = new Collection<>();
  }

  public boolean addVoiceChannel(VoiceChannel vc) {
    if (vc != null) {
      if (!col.containsFirstKey(vc.getId()) || !col.containsSecondKey(vc.getName())) {
        col.add(vc, vc.getId(), vc.getName());
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public VoiceChannel getVoiceChannelById(String id) {
    if (col.containsFirstKey(id)) {
      return col.getByFirstKey(id);
    } else {
      return null;
    }
  }

  public VoiceChannel getVoiceChannelByName(String name) {
    if (col.containsSecondKey(name)) {
      return col.getBySecondKey(name);
    } else {
      return null;
    }
  }

  public boolean containsId(String id) {
    if (col.containsFirstKey(id)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean containsName(String name) {
    if (col.containsSecondKey(name)) {
      return true;
    } else {
      return false;
    }
  }

  public void removeVoiceChannel(VoiceChannel channel) {
    if (col.containsFirstKey(channel.getId())) {
      col.remove(channel.getId(), channel.getName());
    }
  }
}
