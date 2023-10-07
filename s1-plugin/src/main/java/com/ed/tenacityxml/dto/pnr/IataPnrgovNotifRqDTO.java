package com.ed.tenacityxml.dto.pnr;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "IATA_PNRGOV_NotifRQ")
public class IataPnrgovNotifRqDTO {
    private OriginatorDTO originator;

    private FlightLegDTO flightLeg;

    @XmlElement(name = "PNRs")
    public PnrsDTO pnrs;

    @XmlElement(name = "Originator")
    public OriginatorDTO getOriginator() {
        return originator;
    }

    @XmlElement(name = "FlightLeg")
    public FlightLegDTO getFlightLeg() {
        return flightLeg;
    }

}
