
package commands;

public interface ILogCommand {
  public static String LOG_ID = "Command";
  public static String NAME = "Logname";

  //Cause
  public static String CMD_EXE = "Command executed.";

  //Messages
  public static String CMD_KICK_SUCCESS = "Command Kick Member was successfull.";
  public static String CMD_KICK_FAILED = "Command Kick Member failed.";

  public static String CMD_MOVE_SUCCESS = "Command Move Member was successfull.";
  public static String CMD_MOVE_FAILED = "Command Move Member failed.";

  public static String CMD_ADD_ROLE_TO_MEMBER_SUCCESS = "Command Add Role To Member was successfull.";
  public static String CMD_ADD_ROLE_TO_MEMBER_FAILED = "Command Add Role To Member failed.";

  public static String CMD_REMOVE_ROLE_FROM_MEMBER_SUCCESS = "Command Remove Role From Member was successfull.";
  public static String CMD_REMOVE_ROLE_FROM_MEMBER_FAILED = "Command Remove Role From Member failed.";

  public static String CMD_BAN_SUCCESS = "Command Ban was successfull.";
  public static String CMD_BAN_FAILED = "Command Ban failed.";

  public static String CMD_MUTE_SUCCESS = "Command Mute was successfull.";
  public static String CMD_MUTE_FAILED = "Command Mute failed.";

  public static String CMD_DEAF_SUCCESS = "Command Deaf was successfull.";
  public static String CMD_DEAF_FAILED = "Command Deaf failed.";
}
