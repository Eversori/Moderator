package util.log;

public class Logger
{
	private Log log;

	protected Logger(String id, String name)
	{
		log = new Log(id, name);
	}

	/**
	 * Adds any logMessage
	 * 
	 * @param msg
	 * @param type
	 * @param object
	 * @param cause
	 */
	public void addLogMessage(String msg, ELogMsgType type, String object, String cause)
	{
		if (log != null)
		{
			log.addLogObject(msg, type, object, cause);
		}
	}

	/**
	 * Adds a statement to the log
	 * 
	 * @param msg
	 * @param object
	 */
	public void addState(String msg, String object)
	{
		if (log != null)
		{
			log.addLogObject(msg, ELogMsgType.STATE, object, ILogStatic.CAUSE_STATE);
		}
	}

	/**
	 * Adds an exception to the log
	 * 
	 * @param msg
	 * @param object
	 * @param cause
	 */
	public void addException(String msg, String object, String cause)
	{
		if (log != null)
		{
			log.addLogObject(msg, ELogMsgType.EXCEPTION, object, cause);
		}
	}
}
