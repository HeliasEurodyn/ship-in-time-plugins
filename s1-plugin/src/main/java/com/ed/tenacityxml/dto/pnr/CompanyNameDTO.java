package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyNameDTO {

    private int travelSector;

    private String code;

    @XmlAttribute(name = "TravelSector")
    public int getTravelSector() {
        return travelSector;
    }

    public void setTravelSector(int travelSector) {
        this.travelSector = travelSector;
    }

    @XmlAttribute(name = "Code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
