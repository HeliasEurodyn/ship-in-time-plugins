package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class DocoDTO {

    private String birthLocation;

    private String travelDocType;

    private String travelDocNbr;

    private String  placeofIssue;

    private String  dateofIssue;

    private String countryState;

    @XmlAttribute(name = "BirthLocation")
    public String getBirthLocation() {
        return birthLocation;
    }

    @XmlAttribute(name = "TravelDocType")
    public String getTravelDocType() {
        return travelDocType;
    }

    @XmlAttribute(name = "TravelDocNbr")
    public String getTravelDocNbr() {
        return travelDocNbr;
    }

    @XmlAttribute(name = "PlaceOfIssue")
    public String getPlaceofIssue() {
        return placeofIssue;
    }

    @XmlAttribute(name = "DateofIssue")
    public String getDateofIssue() {
        return dateofIssue;
    }

    @XmlAttribute(name = "CountryState")
    public String getCountryState() {
        return countryState;
    }
}
