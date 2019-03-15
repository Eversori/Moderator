
package commands;

public interface IStaticCommand {
  //!move
  public static String CMD_MOVE_SUC = " were moved to ";
  public static String CMD_MOVE_WRONG_PATTERN = "Command Move Pattern was wrong. Command Move: !move member1 member2 member3 ...";
  public static String CMD_MOVE_CHANNEL_DONT_EXISTS = " channel don´t exist.";
  public static String CMD_MOVE_MEMBER_DONT_EXIST = "Member don´t exist.";

  //!kick
  public static String CMD_KICK_SUC = " was kicked.";
  public static String CMD_KICK_WRONG_PATTERN = "Command Kick Pattern was wrong. Command Kick: !kick member";
  public static String CMD_KICK_MEMBER_DONT_EXISTS = " member don´t exist.";

  //!remove
  public static String CMD_REMOVE_ROLE_SUC = " successfully removed from ";
  public static String CMD_REMOVE_ROLE_WRONG_PATTERN = "Command Remove Role was wrong. Command RemoveRole: !remove role member";
  public static String CMD_REMOVE_ROLE_DONT_EXISTS = " role don´t exists.";
  public static String CMD_REMOVE_ROLE_MEMBER_DONT_EXISTS = " member don´t exists";
  public static String CMD_REMOVE_ROLE_MEMBER_HAS_ROLE = " member already has this role!";

  //!role
  public static String CMD_ROLE_ROLE_SUC = " successfully added to ";
  public static String CMD_ROLE_ROLE_WRONG_PATTERN = "Command Add Role was wrong. Command AddRole: !role role member";
  public static String CMD_ROLE_ROLE_DONT_EXISTS = " role don´t exist.";
  public static String CMD_ROLE_ROLE_MEMBER_DONT_EXISTS = " member don´t exist";
  public static String CMD_ROLE_MEMBER_HAS_ROLE = " member already has this role!";

  //!ban
  public static String CMD_BAN_SUC = " successfully banned.";
  public static String CMD_BAN_WRONG_PATTERN = "Command Ban was wrong. Command Ban: !ban member (reason)";
  public static String CMD_BAN_MEMBER_DONT_EXIST = " member don´t exist.";

  //permission
  public static String CMD_PERM = "You don´t have permission to use this command!";

  //membererror
  public static String CMD_MEMBER_ERROR = "Member is null!";
}
