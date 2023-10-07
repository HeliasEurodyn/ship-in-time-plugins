package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Setter
@Data
@NoArgsConstructor
public class TicketDocumentDTO {

    private boolean primaryDocInd;

    private String ticketLocation;

    private String dateOfIssue;

    private String type;

    private String ticketDocumentNbr;

    private TotalFareDTO totalFare;

    private PricingInfoDTO pricingInfo;

    private TaxesDTO taxes;

    private PaymentInfoDTO paymentInfo;

    @XmlAttribute(name = "PrimaryDocInd")
    public boolean isPrimaryDocInd() {
        return primaryDocInd;
    }

    @XmlAttribute(name = "TicketLocation")
    public String getTicketLocation() {
        return ticketLocation;
    }

    @XmlAttribute(name = "DateOfIssue")
    public String getDateOfIssue() {
        return dateOfIssue;
    }

    @XmlAttribute(name = "Type")
    public String getType() {
        return type;
    }

    @XmlAttribute(name = "TicketDocumentNbr")
    public String getTicketDocumentNbr() {
        return ticketDocumentNbr;
    }

    @XmlElement(name = "TotalFare")
    public TotalFareDTO getTotalFare() {
        return totalFare;
    }

    @XmlElement(name = "PricingInfo")
    public PricingInfoDTO getPricingInfo() {
        return pricingInfo;
    }

    @XmlElement(name = "Taxes")
    public TaxesDTO getTaxes() {
        return taxes;
    }

    @XmlElement(name = "PaymentInfo")
    public PaymentInfoDTO getPaymentInfo() {
        return paymentInfo;
    }

    public void setPrimaryDocInd(boolean primaryDocInd) {
        this.primaryDocInd = primaryDocInd;
    }

    public void setTicketLocation(String ticketLocation) {
        this.ticketLocation = ticketLocation;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTicketDocumentNbr(String ticketDocumentNbr) {
        this.ticketDocumentNbr = ticketDocumentNbr;
    }

    public void setTotalFare(TotalFareDTO totalFare) {
        this.totalFare = totalFare;
    }

    public void setPricingInfo(PricingInfoDTO pricingInfo) {
        this.pricingInfo = pricingInfo;
    }

    public void setTaxes(TaxesDTO taxes) {
        this.taxes = taxes;
    }

    public void setPaymentInfo(PaymentInfoDTO paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
}
