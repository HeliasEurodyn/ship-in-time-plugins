package com.ed.tenacityxml.model.pnr;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.mapstruct.Mapping;

import javax.persistence.*;
import java.util.List;

@Data
@DynamicUpdate
@DynamicInsert
@Entity(name = "Passenger")
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    public int rph;

    @Column
    public String surnameRefNumber;

    @Column
    public int boardingStatus;

    @Column
    public String givenName;

    @Column
    public String surname;

    @Column
    public String custLoyaltyProgramID;

    @Column
    public String custLoyaltyMembershipID;

    @Column
    public String excessBaggageIssuerCode;

    @Column
    public String excessBaggageSerialNumber;

    @Column
    public int excessBaggageSequenceCount;

    @Column
    public String excessBaggageBaggagePool;

    @Column
    public int excessBaggageUnitOfMeasureQuantity;

    @Column
    public String excessBaggageUnitOfMeasureCode;

    @Column
    public String fareInfoFareBasis;

    @Column
    public String fareInfoDiscountedFareClassType;

    @Column
    public String fareInfoCountryCode;

    @Column
    public int fareInfoDiscountPercent;

    @Column
    public String fareInfoDiscountedFareType;

    @Column
    public String fareInfoPtcCode;

    //SsrDTO
    @Column
    public String ssrSsrCode;

    @Column
    public int ssrServiceQuantity;

    @Column
    public String ssrStatus;

    //FlightInfoDTO
    @Column
    public String ssrFlightInfoCode;

    //DocaDTO
    @Column
    public String ssrDocaAddressType;

    @Column
    public String ssrDocaAddress;

    @Column
    public String ssrDocaCityName;

    @Column
    public String ssrDocaPostalCode;

    @Column
    public String ssrDocaStateProvCounty;

    @Column
    public String ssrDocaCountry;

    //TicketDocumentDTO
    @Column
    public boolean ticketDocumentPrimaryDocInd;

    @Column
    public String ticketDocumentTicketLocation;

    @Column
    public String ticketDocumentDateOfIssue;

    @Column
    public String ticketDocumentType;

    @Column
    public String ticketDocumentTicketDocumentNbr;

    @Column
    public String ticketDocumentTotalFareCurrencyCode;

    @Column
    public double ticketDocumentTotalFareAmount;

    @Column
    public String  ticketDocumentPricingInfoLocationCode;

    @Column
    public boolean ticketDocumentPricingInfoPenaltyRestrictionInd;

    @Column
    public boolean ticketDocumentPricingInfoNonRefundableInd;

    @Column
    public boolean ticketDocumentPricingInfoNonEndorsableInd;

    @Column
    public String ticketDocumentPricingInfoIsoCountryCode;

    @Column
    public String ticketDocumentPricingInfoTime;

    @Column
    public String ticketDocumentPricingInfoDate;

    @Column
    public String ticketDocumentTaxesTaxCurrencyCode;

    @Column
    public double ticketDocumentTaxesTaxAmount;

    @Column
    public String ticketDocumentTaxesTaxTaxType;

    @Column
    public String ticketDocumentTaxesTaxIsoCountry;

    @Column
    public String ticketDocumentPaymentInfoCardHolderName;

    @Column
    public String ticketDocumentPaymentInfoPaymentType;

    @Column
    public String ticketDocumentPaymentInfoPaymentUse;

    @Column
    public String ticketDocumentPaymentInfoPaymentAmount;

    @Column
    public String ticketDocumentPaymentInfoVendorCode;

    @Column
    public String  ticketDocumentPaymentInfoAccountNbr;

    @Column
    public String ticketDocumentPaymentInfoExpiryDate;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL },
            orphanRemoval=true,
            mappedBy = "passenger"
    )
    private DocSsr docSsr;

}
