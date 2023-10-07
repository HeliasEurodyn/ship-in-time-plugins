package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class FareInfoDTO {

    private String fareBasis;

    private String discountedFareClassType;

    private String countryCode;

    private int discountPercent;

    private String discountedFareType;

    private String ptcCode;

    @XmlAttribute(name = "FareBasis")
    public String getFareBasis() {
        return fareBasis;
    }

    @XmlAttribute(name = "DiscountedFareClassType")
    public String getDiscountedFareClassType() {
        return discountedFareClassType;
    }

    @XmlAttribute(name = "CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @XmlAttribute(name = "DiscountPercent")
    public int getDiscountPercent() {
        return discountPercent;
    }

    @XmlAttribute(name = "DiscountedFareType")
    public String getDiscountedFareType() {
        return discountedFareType;
    }

    @XmlAttribute(name = "PTC_Code")
    public String getPtcCode() {
        return ptcCode;
    }
}
