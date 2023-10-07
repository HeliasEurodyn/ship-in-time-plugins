package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PnrDTO {
    private int numberOfPassengers;

    private String pnrTransDate;

    private String pnrCreationDate;

    private String lastTktDate;

    private BookingRefIDDTO bookingRefid;

    private PosDTO pos;

    private PassengerDTO[] passenger;

    @XmlAttribute(name = "NumberOfPassengers")
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @XmlAttribute(name = "PNR_TransDate")
    public String getPnrTransDate() {
        return pnrTransDate;
    }

    public void setPnrTransDate(String pnrTransDate) {
        this.pnrTransDate = pnrTransDate;
    }

    @XmlAttribute(name = "PNR_CreationDate")
    public String getPnrCreationDate() {
        return pnrCreationDate;
    }

    public void setPnrCreationDate(String pnrCreationDate) {
        this.pnrCreationDate = pnrCreationDate;
    }

    @XmlAttribute(name = "LastTktDate")
    public String getLastTktDate() {
        return lastTktDate;
    }

    public void setLastTktDate(String lastTktDate) {
        this.lastTktDate = lastTktDate;
    }

    @XmlElement(name = "BookingRefID")
    public BookingRefIDDTO getBookingRefid() {
        return bookingRefid;
    }

    public void setBookingRefid(BookingRefIDDTO bookingRefid) {
        this.bookingRefid = bookingRefid;
    }

    @XmlElement(name = "POS")
    public PosDTO getPos() {
        return pos;
    }

    public void setPos(PosDTO pos) {
        this.pos = pos;
    }

    @XmlElement(name = "Passenger")
    public PassengerDTO[] getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO[] passenger) {
        this.passenger = passenger;
    }
}
