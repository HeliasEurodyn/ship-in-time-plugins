package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocSsrDTO {

    private String status;

    private int serviceQuantity;

    private String ssrCode;

    private FlightInfoDTO flightInfo;

    private DocaDTO doca;

    private DocoDTO doco;

    private DocsDTO docs;

    @XmlAttribute(name = "Status")
    public String getStatus() {
        return status;
    }

    @XmlAttribute(name = "ServiceQuantity")
    public int getServiceQuantity() {
        return serviceQuantity;
    }

    @XmlAttribute(name = "SSR_Code")
    public String getSsrCode() {
        return ssrCode;
    }

    @XmlElement(name = "FlightInfo")
    public FlightInfoDTO getFlightInfo() {
        return flightInfo;
    }

    @XmlElement(name = "DOCA")
    public DocaDTO getDoca() {
        return doca;
    }

    @XmlElement(name = "DOCO")
    public DocoDTO getDoco() {
        return doco;
    }

    @XmlElement(name = "DOCS")
    public DocsDTO getDocs() {
        return docs;
    }
}
