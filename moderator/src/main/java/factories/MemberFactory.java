
package factories;

import java.util.HashMap;

import lib.ModBotMember;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;

public class MemberFactory {
  private static HashMap<String, ModBotMember> memberC = new HashMap<String, ModBotMember>();

  public static void mapAllMember(Guild guild) {
    for (Member member : guild.getMembers()) {
      String id = member.getUser().getId();
      if (!memberC.containsKey(id)) {
        ModBotMember mbm = new ModBotMember(id, member.getRoles(), member.getNickname());
        memberC.put(id, mbm);
      }
    }
  }

  public static ModBotMember getMember(String id) {
    if (memberC.containsKey(id)) {
      return memberC.get(id);
    } else {
      return null;
    }
  }
}
