
package factories;

import java.awt.Color;
import lib.collections.RoleCollection;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.managers.GuildController;

public class RoleFactory
{
	private static RoleCollection roleC = new RoleCollection();

	public static void mapAllRoles(Guild guild)
	{
		for (Role r : guild.getRoles())
		{
			roleC.addRole(r);
		}
	}

	public static Role getRoleById(String id)
	{
		if (roleC.containsId(id))
		{
			return roleC.getRoleById(id);
		}
		else
		{
			return null;
		}
	}

	public static Role getRoleByName(String name)
	{
		if (roleC.containsName(name))
		{
			return roleC.getRoleByName(name);
		}
		else
		{
			return null;
		}
	}

	public static Role createRole(String name, GuildController controller, Color color) throws Exception
	{
		Role role = null;

		role = controller.createRole().setName(name).setColor(color).complete();
		roleC.addRole(role);

		return role;
	}

	public static boolean addRole(Role role)
	{
		if (roleC.containsId(role.getId()) && roleC.containsName(role.getName()))
		{
			return false;
		}
		else
		{
			roleC.addRole(role);
			return true;
		}
	}

	public static boolean removeRole(Role role)
	{
		if (roleC.containsId(role.getId()) && roleC.containsName(role.getName()))
		{
			roleC.removeRole(role);
			return true;
		}
		else
		{
			return false;
		}
	}

}
