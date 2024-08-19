package pro.sujan.ee.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlEntity {
    @XmlAttribute
    private int id;
    @XmlAttribute(name = "n")
    private String name;
    public XmlEntity(){}
    public int getId(){return id;}
    public String getName(){return name;}
    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
}
