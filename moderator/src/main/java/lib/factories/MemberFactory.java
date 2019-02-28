
package lib.factories;

import lib.ModBotMember;
import lib.collections.ModBotMemberCollection;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;

public class MemberFactory
{
	private static ModBotMemberCollection memberC = new ModBotMemberCollection();

	public static void mapAllMember(Guild guild)
	{
		for (Member member : guild.getMembers())
		{
			String id = member.getUser().getId();
			if (!memberC.containsId(id))
			{
				ModBotMember mbm = new ModBotMember(member);
				memberC.addMember(mbm);
			}
		}
	}

	public static ModBotMember getMemberByID(String id)
	{
		if (memberC.containsId(id))
		{
			return memberC.getMemberById(id);
		}
		else
		{
			return null;
		}
	}

	public static boolean changeName(String id, String newName)
	{
		ModBotMember member = null;

		if (memberC.containsId(id))
		{
			member = memberC.getMemberById(id);
			member.setName(newName);
			memberC.removeMember(member);
			memberC.addMember(member);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static ModBotMember getMemberByEName(String effectivName)
	{
		if (memberC.containsId(effectivName))
		{
			return memberC.getMemberById(effectivName);
		}
		else
		{
			return null;
		}
	}

	public static boolean addMember(Member member)
	{
		ModBotMember mbm = new ModBotMember(member);
		return memberC.addMember(mbm);
	}

	public static boolean contains(Member member)
	{
		String userId = member.getUser().getId();
		String userName = member.getEffectiveName();

		if (memberC.containsId(userId) && memberC.containsName(userName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
