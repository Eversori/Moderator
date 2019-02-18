
package ModeratorBot.moderator;

import java.util.HashMap;

import commands.Command;

public class CommandHandler {
  public static HashMap<String, Command> commands = new HashMap<String, Command>();

  /**
   * Handles the command usage
   * 
   * @param cmdprs
   */
  public static void handleCommand(CommandParser cmdprs) {
    if (commands.containsKey(cmdprs.getInvoke())) {
      Command cmd = commands.get(cmdprs.getInvoke());
      boolean safe = cmd.called(cmdprs.getArgs(), cmdprs.getEvent());

      if (safe) {
        cmd.action(cmdprs.getArgs(), cmdprs.getEvent());
        cmd.executed(safe, cmdprs.getEvent());
      } else {
        cmd.executed(safe, cmdprs.getEvent());
      }
    } else {
      /**
       * TODO: Log ERROR
       */
    }
  }
}
