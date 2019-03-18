
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

	// public static boolean changeName(String oldName, String newName)
	// {
	// ModBotMember member = null;
	//
	// if (memberC.containsName(oldName))
	// {
	// if (!memberC.containsName(newName))
	// {
	// member = memberC.getMemberByName(oldName);
	// memberC.removeMember(member);
	// member.setName(newName);
	// memberC.addMember(member);
	// return true;
	// }
	// else
	// {
	// return false;
	// }
	// }
	// else
	// {
	// return false;
	// }
	// }

	public static ModBotMember getMemberByEName(String effectivName)
	{
		if (memberC.containsName(effectivName))
		{
			return memberC.getMemberByName(effectivName);
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

	public static boolean list(String[] args)
	{
		boolean bool = false;
		for (int i = 1; i < args.length; i++)
		{
			if (memberC.containsName(args[i]))
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
		ModBotMember mem = getMemberByID(member.getUser().getId());
		memberC.removeMember(mem);
	}

}
