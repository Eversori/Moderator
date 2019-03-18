
package commands;

public interface IStaticCommand {
  // !move
  public static String CMD_MOVE_SUC = " were moved to ";
  public static String CMD_MOVE_WRONG_PATTERN = "Command Move Pattern was wrong. Command Move: !move member1 member2 member3 ...";
  public static String CMD_MOVE_CHANNEL_DONT_EXISTS = " isn't a channel";
  public static String CMD_MOVE_MEMBER_DONT_EXIST = "Member doesn't exist.";

  // !kick
  public static String CMD_KICK_SUC = " was kicked.";
  public static String CMD_KICK_WRONG_PATTERN = "Command Kick Pattern was wrong. Command Kick: !kick member";
  public static String CMD_KICK_MEMBER_DONT_EXISTS = " isn't a member.";

  // !remove
  public static String CMD_REMOVE_ROLE_SUC = " successfully removed from ";
  public static String CMD_REMOVE_ROLE_WRONG_PATTERN = "Command Remove Role was wrong. Command RemoveRole: !remove role member";
  public static String CMD_REMOVE_ROLE_DONT_EXISTS = " isn't a role.";
  public static String CMD_REMOVE_ROLE_MEMBER_DONT_EXISTS = " isn't a member.";
  public static String CMD_REMOVE_ROLE_MEMBER_HAS_ROLE = " doesn't have this role.";

  // !add
  public static String CMD_ROLE_ROLE_SUC = " successfully added to ";
  public static String CMD_ROLE_ROLE_WRONG_PATTERN = "Command Add Role was wrong. Command AddRole: !add role member";
  public static String CMD_ROLE_ROLE_DONT_EXISTS = " isn't a role.";
  public static String CMD_ROLE_ROLE_MEMBER_DONT_EXISTS = " isn't a member.";
  public static String CMD_ROLE_MEMBER_HAS_ROLE = " already has this role!";

  // !ban
  public static String CMD_BAN_SUC = " successfully banned.";
  public static String CMD_BAN_WRONG_PATTERN = "Command Ban was wrong. Command Ban: !ban member (reason)";
  public static String CMD_BAN_MEMBER_DONT_EXIST = " does not exist.";

  // !mute
  public static String CMD_MUTE_SUC = " successfully muted.";
  public static String CMD_MUTE_MEMBER_DONT_EXIST = " isn't a member.";
  public static String CMD_MUTE_WRONG_PATTERN = "Command Mute was wrong. Command Mute: !mute member";

  // !deaf
  public static String CMD_DEAF_SUC = " successfull deafed.";
  public static String CMD_DEAF_MEMBER_DONT_EXIST = "isn't a member.";
  public static String CMD_DEAF_WRONG_PATTERN = "Command Deaf was wrong. Command Deaf: !deaf member";

  // !invite
  public static String CMD_INVITE_SUC = " successfully invited!";
  public static String CMD_INVITE_WRONG_PATTERN = "Command Invite was wrong. Command Invite: !invite member";
  public static String CMD_INVITE_MEMBER_EXIST = " is already invited.";

  // permission
  public static String CMD_PERM = "You don't have permission to use this command!";

  // membererror
  public static String CMD_MEMBER_ERROR = "Member is null!";
}
