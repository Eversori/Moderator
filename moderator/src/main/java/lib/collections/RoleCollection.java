
package lib.collections;

import net.dv8tion.jda.core.entities.Role;

public class RoleCollection {
  private Collection<String, String, Role> col = null;

  public RoleCollection() {
    col = new Collection<>();
  }

  public boolean addRole(Role role) {
    if (role != null) {
      if (!col.containsFirstKey(role.getId()) || !col.containsSecondKey(role.getName())) {
        col.add(role, role.getId(), role.getName());
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public Role getRoleById(String id) {
    if (col.containsFirstKey(id)) {
      return col.getByFirstKey(id);
    } else {
      return null;
    }
  }

  public Role getRoleByName(String name) {
    if (col.containsSecondKey(name)) {
      return col.getBySecondKey(name);
    } else {
      return null;
    }
  }

  public boolean containsId(String id) {
    if (col.containsFirstKey(id)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean containsName(String name) {
    if (col.containsSecondKey(name)) {
      return true;
    } else {
      return false;
    }
  }
}
