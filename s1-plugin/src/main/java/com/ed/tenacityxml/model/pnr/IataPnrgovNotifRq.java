package com.ed.tenacityxml.model.pnr;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

import java.time.Instant;
import java.util.List;

@Data
@Entity(name = "IataPnrgovNotifRq")
@Table(name = "iata_pnrgov_notif_rq")
public class IataPnrgovNotifRq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originatorAirlineCode;

    @Column
    private String originatorSystemCode;

    @Column
    private String originatorAirlineContactInfo;

    @Column
    private String flightLegCarrierCode;

    @Column
    private String flightLegFlightNumber;

    @Column
    private String flightLegDepartureDateTimeStr;

    @Column
    private String flightLegArrivalDateTimeStr;

    @Column
    private Instant flightLegDepartureDateTime;

    @Column
    private Instant flightLegArrivalDateTime;

    @Column
    private String flightLegDateChangeNbr;

    @Column
    private String flightLegDepartureAirpLocationCode;

    @Column
    private String flightLegArrivalAirpLocationCode;

    @Column
    public int numberOfPnrs;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL },
            orphanRemoval=true
    )
    @JoinColumn(name = "iata_pnrgov_notif_rq_id")
    private List<Pnr> pnrList;

    @CreatedDate
    @Column(name = "created_on", updatable = false, nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdOn;

    @LastModifiedDate
    @Column(name = "modified_on", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant modifiedOn;


    @CreatedDate
    @Column(name = "created_by", columnDefinition = "VARCHAR(36)")
    private String createdBy;

    @LastModifiedDate
    @Column(name = "modified_by", columnDefinition = "VARCHAR(36)")
    private String modifiedBy;

}

