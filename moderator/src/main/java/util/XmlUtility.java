
package util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class XmlUtility {

  //Serialisieren der Klasse in eine File
  public void marshallFile(File xmlFile, Object jaxbElement) {
    try {
      JAXBContext context = JAXBContext.newInstance(jaxbElement.getClass());
      Marshaller object = context.createMarshaller();
      object.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      object.marshal(jaxbElement, xmlFile);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  //Deserialisieren der Klasse von einer File
  public void unmarshallFile(File xmlFile, Class<?> accessorClass) {
    try {
      JAXBContext context = JAXBContext.newInstance(accessorClass);
      Unmarshaller unmarshal = context.createUnmarshaller();
      JAXBElement<?> result = unmarshal.unmarshal(new StreamSource(xmlFile), accessorClass);
    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
