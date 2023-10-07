package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OriginatorDTO {

    private String airlineCode;

    private String systemCode;

    private String airlineContactInfo;

    @XmlAttribute(name = "AirlineCode")
    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    @XmlAttribute(name = "SystemCode")
    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    @XmlAttribute(name = "AirlineContactInfo")
    public String getAirlineContactInfo() {
        return airlineContactInfo;
    }

    public void setAirlineContactInfo(String airlineContactInfo) {
        this.airlineContactInfo = airlineContactInfo;
    }
}
