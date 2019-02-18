package factories;

import java.awt.Color;
import java.util.HashMap;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.managers.GuildController;

public class RoleFactory
{
	private static HashMap<String, Role> roleC = new HashMap<String, Role>();

	public static void mapAllRoles(Guild guild)
	{

		for (Role r : guild.getRoles())
		{
			roleC.put(r.getId(), r);
		}
	}

	public static Role getRole(String id)
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
		roleC.put(role.getId(), role);

		return role;
	}

}
