
package commands;

public interface ILogCommand {
  public static String LOG_ID = "Command";
  public static String NAME = "Logname";

  //Cause
  public static String CMD_EXE = "Command executed";

  //Messages
  public static String CMD_KICK_SUCCESS = "Command Kick Member was successfull.";
  public static String CMD_KICK_FAILED = "Command Kick Member Failed.";
  public static String CMD_MOVE_SUCCESS = "Command Move Member was successfull.";
  public static String CMD_MOVE_FAILED = "Command Move Member Failed.";
  public static String CMD_ADD_ROLE_TO_MEMBER_SUCCESS = "Command Add Role To Member was successfull.";
  public static String CMD_ADD_ROLE_TO_MEMBER_FAILED = "Command Add Role To Member Failed.";
}
