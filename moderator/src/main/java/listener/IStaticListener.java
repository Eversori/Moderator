package listener;

public interface IStaticListener
{
	public final static String	NICK_CHANGE_USER				= "The member ";
	public final static String	NICK_CHANGE_CALLS_HIMSELF		= " calls himself ";
	public final static String	NICK_CHANGE_NICK				= "The nickname ";
	public final static String	NICK_CHANGE_IN_USE				= " is already in use";
	public final static String	NICK_CHANGE_TAKE_OTHER			= "Please select an other nickname";
	public final static String	NAME_CHANGE_SUC					= " changed his name to ";
	public final static String	NAME_CHANGE_IN_USE				= " is already in use";
	public final static String	NAME_CHANGE_TAKE_OTHER			= "Please select an other name";
	public final static String	ROLE_CREATION_ADD_SUC			= "Role has been added to the map";
	public final static String	ROLE_CREATION_ADD_FAIL			= "Role has not been added to the map.";
	public final static String	ROLE_DELETION_RM_SUC			= "Role has been removed from the map";
	public final static String	ROLE_DELETION_RM_FAIL			= "Role has not been removed from the map";
	public final static String	TEXT_CHANNEL_CREATION_ADD_SUC	= "TextChannel has been added to the map";
	public final static String	TEXT_CHANNEL_CREATION_ADD_FAIL	= "TextChannel has not been added to the map";
	public final static String	TEXT_CHANNEL_DELETION_RM_SUC	= "TextChannel has been removed from the map";
	public final static String	TEXT_CHANNEL_DELETION_RM_FAIL	= "TextChannel has not been removed from the map";
}
