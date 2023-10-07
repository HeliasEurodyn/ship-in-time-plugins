package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class PricingInfoDTO {

    private String locationCode;

    private boolean penaltyRestrictionInd;

    private boolean nonRefundableInd;

    private boolean nonEndorsableInd;

    private String isoCountryCode;

    private String time;

    private String date;


    @XmlAttribute(name = "LocationCode")
    public String getLocationCode() {
        return locationCode;
    }

    @XmlAttribute(name = "PenaltyRestrictionInd")
    public boolean isPenaltyRestrictionInd() {
        return penaltyRestrictionInd;
    }

    @XmlAttribute(name = "NonRefundableInd")
    public boolean isNonRefundableInd() {
        return nonRefundableInd;
    }

    @XmlAttribute(name = "ISOCountryCode")
    public boolean isNonEndorsableInd() {
        return nonEndorsableInd;
    }

    @XmlAttribute(name = "Time")
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    @XmlAttribute(name = "Time")
    public String getTime() {
        return time;
    }

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }
}
