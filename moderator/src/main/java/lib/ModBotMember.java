
package lib;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import net.dv8tion.jda.core.entities.Role;

@XmlAccessorType(XmlAccessType.FIELD)
public class ModBotMember {
  @XmlElement
  private String id;
  @XmlElement
  private List<Role> roleList = new ArrayList<Role>();
  @XmlElement
  private String name;

  public ModBotMember(String id, List<Role> roleList, String name) {
    super();
    this.id = id;
    this.roleList = roleList;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Role> getRoleList() {
    return roleList;
  }

  public void setRoleList(ArrayList<Role> roleList) {
    this.roleList = roleList;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
