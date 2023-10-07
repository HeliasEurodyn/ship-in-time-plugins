package com.ed.tenacityxml.controller.user.mapper;

import com.ed.tenacityxml.dto.pnr.DocSsrDTO;
import com.ed.tenacityxml.dto.pnr.IataPnrgovNotifRqDTO;
import com.ed.tenacityxml.dto.pnr.PassengerDTO;
import com.ed.tenacityxml.dto.pnr.PnrDTO;
import com.ed.tenacityxml.model.pnr.IataPnrgovNotifRq;
import com.ed.tenacityxml.model.pnr.Passenger;
import com.ed.tenacityxml.model.pnr.Pnr;
import org.mapstruct.*;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class IataPnrgovNotifRqMapper {

    public IataPnrgovNotifRq map(IataPnrgovNotifRqDTO dto){
        IataPnrgovNotifRq entity = this.mapDTO(dto);

        List<Pnr> pnrList = new ArrayList<>();
        for (PnrDTO pnrDTO : dto.pnrs.getPnr()) {
            Pnr pnr = this.mapPnr(pnrDTO);
            pnrList.add(pnr);
        }
        entity.setPnrList(pnrList);

        return entity;
    }

    public Pnr mapPnr(PnrDTO dto){
        Pnr entity = this.mapPnrDTO(dto);

        PassengerDTO[] passengerDtoArray = dto.getPassenger();
        if(passengerDtoArray == null){
            passengerDtoArray = new PassengerDTO[0];
        }
        List<Passenger> passengerList = new ArrayList<>();
        for (PassengerDTO passengerDTO : passengerDtoArray) {
            Passenger passenger = this.mapPassenger(passengerDTO);
            passengerList.add(passenger);
        }
        entity.setPassengerList(passengerList);

        return entity;
    }

    public Passenger mapPassenger(PassengerDTO dto){
        DocSsrDTO[] docssrDtoArray = dto.getDocssr();
        if(docssrDtoArray == null){
            docssrDtoArray = new DocSsrDTO[0];
        }

        for (DocSsrDTO docSsrDTO : docssrDtoArray) {
            if(docSsrDTO.getSsrCode().equals("DOCA")){
                dto.setDocaDocssr(docSsrDTO);
            }else if(docSsrDTO.getSsrCode().equals("DOCO")){
                dto.setDocoDocssr(docSsrDTO);
            }else if(docSsrDTO.getSsrCode().equals("DOCS")){
                dto.setDocsDocssr(docSsrDTO);
            }
        }

        Passenger entity = this.mapPassengerDTO(dto);

        if(entity.getDocSsr() != null){
            entity.getDocSsr().setPassenger(entity);
        }

        return entity;
    }

    @Mapping(target = "rph", source = "dto.rph")
    @Mapping(target = "surnameRefNumber", source = "dto.surnameRefNumber")
    @Mapping(target = "boardingStatus", source = "dto.boardingStatus")
    @Mapping(target = "givenName", source = "dto.givenName")
    @Mapping(target = "surname", source = "dto.surname")
    @Mapping(target = "custLoyaltyProgramID", source = "dto.custLoyalty.programID")
    @Mapping(target = "custLoyaltyMembershipID", source = "dto.custLoyalty.membershipID")
    @Mapping(target = "excessBaggageIssuerCode", source = "dto.excessBaggage.issuerCode")
    @Mapping(target = "excessBaggageSerialNumber", source = "dto.excessBaggage.serialNumber")
    @Mapping(target = "excessBaggageSequenceCount", source = "dto.excessBaggage.sequenceCount")
    @Mapping(target = "excessBaggageBaggagePool", source = "dto.excessBaggage.baggagePool")
    @Mapping(target = "excessBaggageUnitOfMeasureQuantity", source = "dto.excessBaggage.unitOfMeasureQuantity")
    @Mapping(target = "excessBaggageUnitOfMeasureCode", source = "dto.excessBaggage.unitOfMeasureCode")
    @Mapping(target = "fareInfoFareBasis", source = "dto.fareInfo.fareBasis")
    @Mapping(target = "fareInfoDiscountedFareClassType", source = "dto.fareInfo.discountedFareClassType")
    @Mapping(target = "fareInfoCountryCode", source = "dto.fareInfo.countryCode")
    @Mapping(target = "fareInfoDiscountPercent", source = "dto.fareInfo.discountPercent")
    @Mapping(target = "fareInfoDiscountedFareType", source = "dto.fareInfo.discountedFareType")
    @Mapping(target = "fareInfoPtcCode", source = "dto.fareInfo.ptcCode")
    @Mapping(target = "ssrSsrCode", source = "dto.ssr.ssrCode")
    @Mapping(target = "ssrServiceQuantity", source = "dto.ssr.serviceQuantity")
    @Mapping(target = "ssrStatus", source = "dto.ssr.status")
    @Mapping(target = "ssrFlightInfoCode", source = "dto.ssr.flightInfo.code")
    @Mapping(target = "ticketDocumentPrimaryDocInd", source = "dto.ticketDocument.primaryDocInd")
    @Mapping(target = "ticketDocumentTicketLocation", source = "dto.ticketDocument.ticketLocation")
    @Mapping(target = "ticketDocumentDateOfIssue", source = "dto.ticketDocument.dateOfIssue")
    @Mapping(target = "ticketDocumentType", source = "dto.ticketDocument.type")
    @Mapping(target = "ticketDocumentTicketDocumentNbr", source = "dto.ticketDocument.ticketDocumentNbr")
    @Mapping(target = "ticketDocumentTotalFareCurrencyCode", source = "dto.ticketDocument.totalFare.currencyCode")
    @Mapping(target = "ticketDocumentTotalFareAmount", source = "dto.ticketDocument.totalFare.amount")
    @Mapping(target = "ticketDocumentPricingInfoLocationCode", source = "dto.ticketDocument.pricingInfo.locationCode")
    @Mapping(target = "ticketDocumentPricingInfoPenaltyRestrictionInd", source = "dto.ticketDocument.pricingInfo.penaltyRestrictionInd")
    @Mapping(target = "ticketDocumentPricingInfoNonRefundableInd", source = "dto.ticketDocument.pricingInfo.nonRefundableInd")
    @Mapping(target = "ticketDocumentPricingInfoNonEndorsableInd", source = "dto.ticketDocument.pricingInfo.nonEndorsableInd")
    @Mapping(target = "ticketDocumentPricingInfoIsoCountryCode", source = "dto.ticketDocument.pricingInfo.isoCountryCode")
    @Mapping(target = "ticketDocumentPricingInfoTime", source = "dto.ticketDocument.pricingInfo.time")
    @Mapping(target = "ticketDocumentPricingInfoDate", source = "dto.ticketDocument.pricingInfo.date")
    @Mapping(target = "ticketDocumentTaxesTaxCurrencyCode", source = "dto.ticketDocument.taxes.tax.currencyCode")
    @Mapping(target = "ticketDocumentTaxesTaxAmount", source = "dto.ticketDocument.taxes.tax.amount")
    @Mapping(target = "ticketDocumentTaxesTaxTaxType", source = "dto.ticketDocument.taxes.tax.taxType")
    @Mapping(target = "ticketDocumentTaxesTaxIsoCountry", source = "dto.ticketDocument.taxes.tax.isoCountry")
    @Mapping(target = "ticketDocumentPaymentInfoCardHolderName", source = "dto.ticketDocument.paymentInfo.cardHolderName")

    @Mapping(target = "ticketDocumentPaymentInfoPaymentType", source = "dto.ticketDocument.paymentInfo.paymentType")
    @Mapping(target = "ticketDocumentPaymentInfoPaymentUse", source = "dto.ticketDocument.paymentInfo.paymentUse")
    @Mapping(target = "ticketDocumentPaymentInfoPaymentAmount", source = "dto.ticketDocument.paymentInfo.paymentAmount")
    @Mapping(target = "ticketDocumentPaymentInfoVendorCode", source = "dto.ticketDocument.paymentInfo.vendorCode")
    @Mapping(target = "ticketDocumentPaymentInfoAccountNbr", source = "dto.ticketDocument.paymentInfo.accountNbr")
    @Mapping(target = "ticketDocumentPaymentInfoExpiryDate", source = "dto.ticketDocument.paymentInfo.expiryDate")

    @Mapping(target = "docSsr.docaStatus", source = "dto.docaDocssr.status")
    @Mapping(target = "docSsr.docaServiceQuantity", source = "dto.docaDocssr.serviceQuantity")
    @Mapping(target = "docSsr.docaSsrCode", source = "dto.docaDocssr.ssrCode")
    @Mapping(target = "docSsr.docaFlightInfoCode", source = "dto.docaDocssr.flightInfo.code")
    @Mapping(target = "docSsr.docaAddressType", source = "dto.docaDocssr.doca.addressType")
    @Mapping(target = "docSsr.docaAddress", source = "dto.docaDocssr.doca.address")
    @Mapping(target = "docSsr.docaCityName", source = "dto.docaDocssr.doca.cityName")
    @Mapping(target = "docSsr.docaPostalCode", source = "dto.docaDocssr.doca.postalCode")
    @Mapping(target = "docSsr.docaStateProvCounty", source = "dto.docaDocssr.doca.stateProvCounty")
    @Mapping(target = "docSsr.docaCountry", source = "dto.docaDocssr.doca.country")

    @Mapping(target = "docSsr.docoStatus", source = "dto.docoDocssr.status")
    @Mapping(target = "docSsr.docoServiceQuantity", source = "dto.docoDocssr.serviceQuantity")
    @Mapping(target = "docSsr.docoSsrCode", source = "dto.docoDocssr.ssrCode")
    @Mapping(target = "docSsr.docoFlightInfoCode", source = "dto.docoDocssr.flightInfo.code")
    @Mapping(target = "docSsr.docoBirthLocation", source = "dto.docoDocssr.doco.birthLocation")
    @Mapping(target = "docSsr.docoTravelDocType", source = "dto.docoDocssr.doco.travelDocType")
    @Mapping(target = "docSsr.docoTravelDocNbr", source = "dto.docoDocssr.doco.travelDocNbr")
    @Mapping(target = "docSsr.docoPlaceofIssue", source = "dto.docoDocssr.doco.placeofIssue")
    @Mapping(target = "docSsr.docoDateofIssue", source = "dto.docoDocssr.doco.dateofIssue")
    @Mapping(target = "docSsr.docoCountryState", source = "dto.docoDocssr.doco.countryState")

    @Mapping(target = "docSsr.docsStatus", source = "dto.docsDocssr.status")
    @Mapping(target = "docSsr.docsServiceQuantity", source = "dto.docsDocssr.serviceQuantity")
    @Mapping(target = "docSsr.docsSsrCode", source = "dto.docsDocssr.ssrCode")
    @Mapping(target = "docSsr.docsFlightInfoCode", source = "dto.docsDocssr.flightInfo.code")
    @Mapping(target = "docSsr.docsDateofBirth", source = "dto.docsDocssr.docs.dateofBirth")
    @Mapping(target = "docSsr.docsExpiryDate", source = "dto.docsDocssr.docs.expiryDate")
    @Mapping(target = "docSsr.docsFirstGivenname", source = "dto.docsDocssr.docs.firstGivenname")
    @Mapping(target = "docSsr.docsFecondGivenname", source = "dto.docsDocssr.docs.secondGivenname")
    @Mapping(target = "docSsr.docsSurname", source = "dto.docsDocssr.docs.surname")
    @Mapping(target = "docSsr.docsGender", source = "dto.docsDocssr.docs.gender")
    @Mapping(target = "docSsr.docsIssuingLoc", source = "dto.docsDocssr.docs.issuingLoc")
    @Mapping(target = "docSsr.docsPaxNationality", source = "dto.docsDocssr.docs.paxNationality")
    public abstract Passenger mapPassengerDTO(PassengerDTO dto);

    @Mapping(target = "numberOfPassengers", source = "dto.numberOfPassengers")
    @Mapping(target = "pnrTransDate", source = "dto.pnrTransDate")
    @Mapping(target = "pnrCreationDate", source = "dto.pnrCreationDate")
    @Mapping(target = "lastTktDate", source = "dto.lastTktDate")
    @Mapping(target = "posSourceAgentSine", source = "dto.pos.source.agentSine")
    @Mapping(target = "posSourcePseudoCityCode", source = "dto.pos.source.pseudoCityCode")
    @Mapping(target = "posSourceIsoCountry", source = "dto.pos.source.isoCountry")
    @Mapping(target = "posSourceIsoCurrency", source = "dto.pos.source.isoCurrency")
    @Mapping(target = "posSourceAgentDutyCode", source = "dto.pos.source.agentDutyCode")
    @Mapping(target = "posSourceAirlineVendorID", source = "dto.pos.source.airlineVendorID")
    @Mapping(target = "posSourceAirportCode", source = "dto.pos.source.airportCode")
    @Mapping(target = "posSourceRequestorid", source = "dto.pos.source.requestorIdentity.requestorid")
    @Mapping(target = "posSourceRequestorCompanyTravelSector", source = "dto.pos.source.requestorIdentity.companyName.travelSector")
    @Mapping(target = "bookingRefid", source = "dto.bookingRefid.bookingRefid")
    @Mapping(target = "bookingRefCompanyNameTravelSector", source = "dto.bookingRefid.companyName.travelSector")
    @Mapping(target = "bookingRefCompanyNameCode", source = "dto.bookingRefid.companyName.code")
    public abstract Pnr mapPnrDTO(PnrDTO dto);

    @Mapping(target = "originatorAirlineCode", source = "dto.originator.airlineCode")
    @Mapping(target = "originatorSystemCode", source = "dto.originator.systemCode")
    @Mapping(target = "originatorAirlineContactInfo", source = "dto.originator.airlineContactInfo")
    @Mapping(target = "flightLegCarrierCode", source = "dto.flightLeg.carrierCode")
    @Mapping(target = "flightLegFlightNumber", source = "dto.flightLeg.flightNumber")
    @Mapping(target = "flightLegDepartureDateTimeStr", source = "dto.flightLeg.departureDateTimeStr")
    @Mapping(target = "flightLegArrivalDateTimeStr", source = "dto.flightLeg.arrivalDateTimeStr")
    @Mapping(target = "flightLegDateChangeNbr", source = "dto.flightLeg.dateChangeNbr")
    @Mapping(target = "flightLegDepartureAirpLocationCode", source = "dto.flightLeg.departureAirport.locationCode")
    @Mapping(target = "flightLegArrivalAirpLocationCode", source = "dto.flightLeg.arrivalAirport.locationCode")
    @Mapping(target = "numberOfPnrs", source = "dto.pnrs.numberOfPnrs")
    public abstract IataPnrgovNotifRq mapDTO(IataPnrgovNotifRqDTO dto);

    public abstract IataPnrgovNotifRqDTO mapEntity(IataPnrgovNotifRq entity);
}
