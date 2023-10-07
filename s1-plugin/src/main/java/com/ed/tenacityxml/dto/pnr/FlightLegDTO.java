package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.time.Instant;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightLegDTO {

    private String carrierCode;

    private String flightNumber;

    private String departureDateTimeStr;

    private String arrivalDateTimeStr;

    private String dateChangeNbr;

    private DepartureAirportDTO departureAirport;

    private ArrivalAirportDTO arrivalAirport;

    @XmlAttribute(name = "CarrierCode")
    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    @XmlAttribute(name = "FlightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @XmlAttribute(name = "DepartureDateTime")
    public String getDepartureDateTimeStr() {
        return departureDateTimeStr;
    }

    public void setDepartureDateTimeStr(String departureDateTimeStr) {
        this.departureDateTimeStr = departureDateTimeStr;
    }

    @XmlAttribute(name = "ArrivalDateTime")
    public String getArrivalDateTimeStr() {
        return arrivalDateTimeStr;
    }

    public void setArrivalDateTimeStr(String arrivalDateTimeStr) {
        this.arrivalDateTimeStr = arrivalDateTimeStr;
    }

    @XmlAttribute(name = "DateChangeNbr")
    public String getDateChangeNbr() {
        return dateChangeNbr;
    }

    public void setDateChangeNbr(String dateChangeNbr) {
        this.dateChangeNbr = dateChangeNbr;
    }

    @XmlElement(name = "DepartureAirport")
    public DepartureAirportDTO getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(DepartureAirportDTO departureAirport) {
        this.departureAirport = departureAirport;
    }

    @XmlElement(name = "ArrivalAirport")
    public ArrivalAirportDTO getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(ArrivalAirportDTO arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
