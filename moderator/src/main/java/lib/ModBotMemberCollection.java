
package lib;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModBotMemberCollection {

  private Collection col = new Collection<String, String, ModBotMember>();

  public Collection getCol() {
    return col;
  }

  @XmlElement(name = "MemberCollection")
  public void setCol(Collection col) {
    this.col = col;
  }

}
