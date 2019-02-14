
package util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

public class XmlUtility {

  //Serialisieren der Klasse in eine File
  public static void marshallFile(File xmlFile, Object jaxbElement) {
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
  public static Object unmarshallFile(File xmlFile, Class<?> accessorClass) {
    return unmarshallSource(new StreamSource(xmlFile), accessorClass);
  }

  public static Object unmarshallSource(Source xmlSource, Class<?> accessorClass) {
    try {
      JAXBContext context = JAXBContext.newInstance(accessorClass);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      JAXBElement<?> result = unmarshaller.unmarshal(xmlSource, accessorClass);
      return result.getValue();
    } catch (JAXBException e) {
      e.printStackTrace();
      return null;
    }
  }
}
