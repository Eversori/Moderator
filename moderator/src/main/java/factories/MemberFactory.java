
package factories;

import lib.ModBotMember;
import lib.ModBotMemberCollection;
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
				ModBotMember mbm = new ModBotMember(id, member.getRoles(), member.getEffectiveName());
				memberC.addMember(mbm);
			}
		}
	}

	public static ModBotMember getMember(String id)
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
			memberC.removeMember(id);
			memberC.addMember(member);
			return true;
		}
		else
		{
			return false;
		}
	}
}
