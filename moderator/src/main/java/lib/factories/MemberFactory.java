
package lib.factories;

import java.util.HashMap;

import lib.ModBotMember;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;

public class MemberFactory
{
	private static HashMap<String, ModBotMember> memberC = new HashMap<>();

	public static void mapAllMember(Guild guild)
	{
		for (Member member : guild.getMembers())
		{
			String id = member.getUser().getId();
			if (!memberC.containsKey(id))
			{
				ModBotMember mbm = new ModBotMember(member);
				memberC.put(id,mbm);
			}
		}
	}

	public static ModBotMember getMemberByID(String id)
	{
		if (memberC.containsKey(id))
		{
			return memberC.get(id);
		}
		else
		{
			return null;
		}
	}


	public static boolean addMember(Member member)
	{
		ModBotMember mbm = new ModBotMember(member);
		String id = member.getUser().getId();
		if(!memberC.containsKey(id))
		{
			memberC.put(id, mbm);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean contains(Member member)
	{
		String userId = member.getUser().getId();

		if (memberC.containsKey(userId))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean list(String[] args)
	{
		boolean bool = false;
		for (int i = 1; i < args.length; i++)
		{
			if (memberC.containsKey(args[i]))
			{
				bool = true;
			}
			else
			{
				bool = false;
				break;
			}
		}
		return bool;
	}

	public static void removeMember(Member member)
	{
		memberC.remove(member.getUser().getId());
	}

}
