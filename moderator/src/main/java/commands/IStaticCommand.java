
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
  public static String CMD_REMOVE_ROLE_DONT_EXISTS = " member don´t exists.";
}
