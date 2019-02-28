
package lib;

import java.util.ArrayList;
import java.util.List;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;

public class ModBotMember
{

	private List<Role>	roleList	= null;
	private String		name;
	private Member		member;

	public ModBotMember(Member member)
	{
		super();
		this.member = member;
		this.roleList = member.getRoles();
		this.name = member.getEffectiveName();
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
		return roleList;
	}

	public void setRoleList(ArrayList<Role> roleList)
	{
		this.roleList = roleList;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
