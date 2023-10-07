package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

    private int rph;

    private String surnameRefNumber;

    private int boardingStatus;

    private String givenName;

    private String surname;

    private CustLoyaltyDTO custLoyalty;

    private ExcessBaggageDTO excessBaggage;

    private FareInfoDTO fareInfo;

    private SsrDTO ssr;

    private TicketDocumentDTO ticketDocument;

    private DocSsrDTO[] docssr;

    private DocSsrDTO docaDocssr;

    private DocSsrDTO docoDocssr;

    private DocSsrDTO docsDocssr;

    @XmlAttribute(name = "RPH")
    public int getRph() {
        return rph;
    }

    public void setRph(int rph) {
        this.rph = rph;
    }

    @XmlAttribute(name = "SurnameRefNumber")
    public String getSurnameRefNumber() {
        return surnameRefNumber;
    }

    public void setSurnameRefNumber(String surnameRefNumber) {
        this.surnameRefNumber = surnameRefNumber;
    }

    @XmlAttribute(name = "BoardingStatus")
    public int getBoardingStatus() {
        return boardingStatus;
    }

    public void setBoardingStatus(int boardingStatus) {
        this.boardingStatus = boardingStatus;
    }

    @XmlElement(name = "GivenName")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @XmlElement(name = "Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement(name = "CustLoyalty")
    public CustLoyaltyDTO getCustLoyalty() {
        return custLoyalty;
    }

    public void setCustLoyalty(CustLoyaltyDTO custLoyalty) {
        this.custLoyalty = custLoyalty;
    }

    @XmlElement(name = "ExcessBaggage")
    public ExcessBaggageDTO getExcessBaggage() {
        return excessBaggage;
    }

    public void setExcessBaggage(ExcessBaggageDTO excessBaggage) {
        this.excessBaggage = excessBaggage;
    }

    @XmlElement(name = "FareInfo")
    public FareInfoDTO getFareInfo() {
        return fareInfo;
    }

    @XmlElement(name = "SSR")
    public SsrDTO getSsr() {
        return ssr;
    }

    @XmlElement(name = "TicketDocument")
    public TicketDocumentDTO getTicketDocument() {
        return ticketDocument;
    }

    @XmlElement(name = "DOC_SSR")
    public DocSsrDTO[] getDocssr() {
        return docssr;
    }

    public DocSsrDTO getDocaDocssr() {
        return docaDocssr;
    }

    public DocSsrDTO getDocoDocssr() {
        return docoDocssr;
    }

    public DocSsrDTO getDocsDocssr() {
        return docsDocssr;
    }
}
