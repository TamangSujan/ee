package pro.sujan.ee.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.util.JAXBResult;
import pro.sujan.ee.database.entity.UserEntity;
import pro.sujan.ee.xml.XmlEntity;

import javax.xml.transform.Result;
import java.io.StringWriter;

@Path("/test/xml")
public class XmlController {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() throws JAXBException {
        XmlEntity xmlEntity = new XmlEntity();
        xmlEntity.setId(1);
        xmlEntity.setName("Java");
        JAXBContext xmlContext = JAXBContext.newInstance(XmlEntity.class);
        Marshaller xmlMarshaller = xmlContext.createMarshaller();
        xmlMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter result = new StringWriter();
        xmlMarshaller.marshal(xmlEntity, result);
        return result.toString();
    }
}
