package util.log;

public class LogObject
{
	private int			objectID;
	private String		message;
	private ELogMsgType	msgType;
	private String		object;
	private String		cause;

	protected LogObject(int id)
	{
		this.objectID = id;
	}

	protected int getObjectID()
	{
		return objectID;
	}

	protected void setObjectID(int objectID)
	{
		this.objectID = objectID;
	}

	protected String getMessage()
	{
		return message;
	}

	protected void setMessage(String message)
	{
		this.message = message;
	}

	protected ELogMsgType getMsgType()
	{
		return msgType;
	}

	protected void setMsgType(ELogMsgType msgType)
	{
		this.msgType = msgType;
	}

	protected String getObject()
	{
		return object;
	}

	protected void setObject(String object)
	{
		this.object = object;
	}

	protected String getCause()
	{
		return cause;
	}

	protected void setCause(String cause)
	{
		this.cause = cause;
	}

}
