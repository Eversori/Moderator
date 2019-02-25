
package lib.collections;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lib.ModBotMember;

@XmlRootElement
public class ModBotMemberCollection {

  private Collection<String, String, ModBotMember> col = null;

  public ModBotMemberCollection() {
    col = new Collection<String, String, ModBotMember>();
  }

  @XmlElement(name = "MemberCollection")
  public void setCol(Collection<String, String, ModBotMember> col) {
    this.col = col;
  }

  /**
   * Adds a member to the collection
   * The keys used are: The effective Name of the Member and the Discord-id of the User
   * 
   * @param member
   * @return
   */
  public boolean addMember(ModBotMember member) {
    String name = member.getName();
    String id = member.getMember().getUser().getId();

    if (!col.containsFirstKey(id) || !col.containsSecondKey(name)) {
      col.add(member, id, name);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the ModBotMember for a specific id or null if the id was not found
   * 
   * @param id
   * @return
   */
  public ModBotMember getMemberById(String id) {
    if (col.containsFirstKey(id)) {
      return col.getByFirstKey(id);
    } else {
      return null;
    }
  }

  /**
   * Returns the ModBotMember for a specific id or null if the id was not found
   * 
   * @param name
   * @return
   */
  public ModBotMember getMemberByName(String name) {
    if (col.containsSecondKey(name)) {
      return col.getBySecondKey(name);
    } else {
      return null;
    }
  }

  public boolean containsId(String id) {
    return col.containsFirstKey(id);
  }

  public boolean containsName(String name) {
    return col.containsSecondKey(name);
  }

  public void removeMember(ModBotMember member) {
    if (col.containsFirstKey(member.getMember().getUser().getId())) {
      col.remove(member.getMember().getUser().getId(), member.getName());
    }
  }
}
