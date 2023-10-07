package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@Setter
@Data
@NoArgsConstructor
public class SsrDTO {

    private String ssrCode;

    private int serviceQuantity;

    private String status;

    private FlightInfoDTO flightInfo;

    private DocaDTO doca;

    @XmlAttribute(name = "SSR_Code")
    public String getSsrCode() {
        return ssrCode;
    }

    @XmlAttribute(name = "ServiceQuantity")
    public int getServiceQuantity() {
        return serviceQuantity;
    }

    @XmlAttribute(name = "Status")
    public String getStatus() {
        return status;
    }

    @XmlElement(name = "FlightInfo")
    public FlightInfoDTO getFlightInfo() {
        return flightInfo;
    }

    @XmlElement(name = "DOCA")
    public DocaDTO getDoca() {
        return doca;
    }
}
