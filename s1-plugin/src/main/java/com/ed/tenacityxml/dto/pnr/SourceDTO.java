package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SourceDTO {

    private String agentSine;

    private String pseudoCityCode;

    private String isoCountry;

    private String isoCurrency;

    private String agentDutyCode;

    private String airlineVendorID;

    private String airportCode;

    private RequestorIDDTO requestorIdentity;

    @XmlAttribute(name = "AgentSine")
    public String getAgentSine() {
        return agentSine;
    }

    public void setAgentSine(String agentSine) {
        this.agentSine = agentSine;
    }

    @XmlAttribute(name = "PseudoCityCode")
    public String getPseudoCityCode() {
        return pseudoCityCode;
    }

    public void setPseudoCityCode(String pseudoCityCode) {
        this.pseudoCityCode = pseudoCityCode;
    }

    @XmlAttribute(name = "ISOCOuntry")
    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    @XmlAttribute(name = "ISOCurrency")
    public String getIsoCurrency() {
        return isoCurrency;
    }

    public void setIsoCurrency(String isoCurrency) {
        this.isoCurrency = isoCurrency;
    }

    @XmlAttribute(name = "AgentDutyCode")
    public String getAgentDutyCode() {
        return agentDutyCode;
    }

    public void setAgentDutyCode(String agentDutyCode) {
        this.agentDutyCode = agentDutyCode;
    }

    @XmlAttribute(name = "AirlineVendorID")
    public String getAirlineVendorID() {
        return airlineVendorID;
    }

    public void setAirlineVendorID(String airlineVendorID) {
        this.airlineVendorID = airlineVendorID;
    }

    @XmlAttribute(name = "AirportCode")
    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @XmlElement(name = "RequestorID")
    public RequestorIDDTO getRequestorIdentity() {
        return requestorIdentity;
    }

    public void setRequestorIdentity(RequestorIDDTO requestorIdentity) {
        this.requestorIdentity = requestorIdentity;
    }
}
