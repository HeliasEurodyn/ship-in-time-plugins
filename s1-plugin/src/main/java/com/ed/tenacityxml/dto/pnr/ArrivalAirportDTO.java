package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalAirportDTO {


    private String locationCode;

    @XmlAttribute(name = "LocationCode")
    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}


