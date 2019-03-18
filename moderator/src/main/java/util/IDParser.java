package util;

public class IDParser {
	
	public static String getIdFromMention(String mention)
	{
		// <@!id>
		int subBegin = 3;
		int subEnd = mention.length() - 1;
		
		return mention.substring(subBegin, subEnd);
	}
	
}
