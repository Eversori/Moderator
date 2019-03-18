
package lib.factories;

import java.awt.Color;
import java.util.HashMap;

import lib.collections.RoleCollection;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.managers.GuildController;

public class RoleFactory
{
	private static HashMap<String, Role> roleC = new HashMap<>();

	public static void mapAllRoles(Guild guild)
	{
		for (Role r : guild.getRoles())
		{
			roleC.put(r.getId(),r);
		}
	}

	public static Role getRoleById(String id)
	{
		if (roleC.containsKey(id))
		{
			return roleC.get(id);
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
		roleC.put(role.getId(),role);

		return role;
	}

	public static boolean addRole(Role role)
	{
		if(!roleC.containsKey(role.getId()))
		{
			roleC.put(role.getId(), role);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public static boolean removeRole(Role role)
	{
		if (roleC.containsKey(role.getId()))
		{
			roleC.remove(role.getId());
			return true;
		}
		else
		{
			return false;
		}
	}

}
