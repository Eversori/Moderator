package util.log;

import java.util.ArrayList;

public class Log
{
	private int						logObjNumber	= 0;
	private String					logName;
	private String					logID;
	private ArrayList<LogObject>	logEntries		= null;

	protected Log(String logID, String logName)
	{
		this.logID = logID;
		this.logName = logName;

		logEntries = new ArrayList<LogObject>();
	}

	/**
	 * Adds a new logObject to the Log
	 * 
	 * @param msg
	 * @param type
	 * @param object
	 * @param cause
	 */
	protected void addLogObject(String msg, ELogMsgType type, String object, String cause)
	{
		if (logEntries != null)
		{
			logEntries.add(createLogEntry(msg, type, object, cause));
		}
	}

	/**
	 * Creates a new LogObject
	 * 
	 * @param msg
	 * @param type
	 * @param object
	 * @param cause
	 * @return
	 */
	private LogObject createLogEntry(String msg, ELogMsgType type, String object, String cause)
	{
		LogObject lo = new LogObject(logObjNumber++);

		lo.setObject(object);
		lo.setCause(cause);
		lo.setMsgType(type);
		lo.setMessage(msg);

		return lo;
	}

	public void printLog()
	{
		// TODO: Not implemented
	}

}
