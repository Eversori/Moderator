
package util;

import java.util.ArrayList;

import net.dv8tion.jda.core.Permission;

public class InitPermissions {
  ArrayList<Permission> allowTxt = new ArrayList<Permission>();
  ArrayList<Permission> denyTxt = new ArrayList<Permission>();
  ArrayList<Permission> allowVc = new ArrayList<Permission>();
  ArrayList<Permission> denyVc = new ArrayList<Permission>();
  ArrayList<Permission> denyEveryoneTxt = new ArrayList<Permission>();
  ArrayList<Permission> denyEveryoneVc = new ArrayList<Permission>();

  public void permission() {
    allowVc.add(Permission.VIEW_CHANNEL);
    allowVc.add(Permission.VOICE_CONNECT);
    allowVc.add(Permission.VOICE_SPEAK);

    denyVc.add(Permission.MANAGE_CHANNEL);
    denyVc.add(Permission.VOICE_MOVE_OTHERS);

    allowTxt.add(Permission.VIEW_CHANNEL);
    allowTxt.add(Permission.MESSAGE_READ);
    allowTxt.add(Permission.MESSAGE_WRITE);
    allowTxt.add(Permission.MESSAGE_ADD_REACTION);
    allowTxt.add(Permission.MESSAGE_ATTACH_FILES);
    allowTxt.add(Permission.MESSAGE_EMBED_LINKS);

    denyTxt.add(Permission.MANAGE_CHANNEL);
    denyTxt.add(Permission.MESSAGE_MANAGE);

    denyEveryoneTxt.add(Permission.VIEW_CHANNEL);
    denyEveryoneTxt.add(Permission.MESSAGE_READ);
    denyEveryoneVc.add(Permission.VIEW_CHANNEL);
    denyEveryoneVc.add(Permission.VOICE_CONNECT);
  }
}
