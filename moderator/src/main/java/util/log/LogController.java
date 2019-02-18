package util.log;

import java.util.HashMap;

public class LogController
{
	private static HashMap<String, Logger> loggerCollection = new HashMap<String, Logger>();

	/**
	 * Returns a logger for a specific log-id or creates a new one if there is no log yet
	 * 
	 * @param id
	 * @param name
	 * @return Logger
	 */
	public static Logger getLogger(String id, String name)
	{
		Logger logger = null;

		if (loggerCollection.containsKey(id))
		{
			logger = loggerCollection.get(id);
		}
		else
		{
			logger = new Logger(id, name);
			loggerCollection.put(id, logger);
		}

		return logger;
	}
}
