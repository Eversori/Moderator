package ModeratorBot.moderator;

public interface ILogMain
{
	// Log
	public static final String	NUM				= "Main_Log";
	public static final String	NAME			= "Main-Log";

	// Log-Cause
	public static final String	NICK_CHANGE		= "User-nickname change";
	public static final String	NAME_CHANGE		= "User-name change";
	public static final String	ROLE_CREATE		= "Role creation";
	public static final String	ROLE_DELETE		= "Role deletion";
	public static final String	TXT_CH_CREATE	= "TextChannel creation";
	public static final String	TXT_CH_DELETE	= "TextChannel deletion";
	public static final String	VC_CH_CREATE	= "VoiceChannel creation";
	public static final String	VC_CH_DELETE	= "VoiceChannel deletion";
	public static final String	MEMBER_JOIN		= "New Member join";
}
