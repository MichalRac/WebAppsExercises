package pl.gda.pg.eti.kask.aui.rest.entities;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlType(name = "city")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "city")
public class City implements Serializable {

    @XmlAttribute(name = "id")
    private Integer id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "latitude")
    private float latitude;

    @XmlAttribute(name = "longitude")
    private float longitude;

    public City() { }

    public City(Integer id, String name, float latitude, float longitude)
    {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude()
    {
        return latitude;
    }

    public float getLongitude()
    {
        return longitude;
    }
}
