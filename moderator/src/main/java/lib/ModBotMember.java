
package lib;

import java.util.List;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;

public class ModBotMember
{

	private Member member;

	public ModBotMember(Member member)
	{
		super();
		this.member = member;
	}

	public Member getMember()
	{
		return member;
	}

	public void setMember(Member member)
	{
		this.member = member;
	}

	public List<Role> getRoleList()
	{
		return member.getRoles();
	}

	public boolean hasRole(Role testRole)
	{
		String testId = testRole.getId();
		boolean hasRole = false;

		for (Role role : member.getRoles())
		{
			String roleId = role.getId();
			if (roleId.equals(testId))
			{
				hasRole = true;
				break;
			}
			else
			{
				hasRole = false;
			}
		}
		return hasRole;
	}

	public String getName()
	{
		return member.getUser().getName();
	}

	public String getDiscriminator()
	{
		return member.getUser().getDiscriminator();
	}

}
