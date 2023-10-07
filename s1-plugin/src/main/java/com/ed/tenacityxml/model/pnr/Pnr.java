package com.ed.tenacityxml.model.pnr;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

import javax.persistence.*;

@Data
@DynamicUpdate
@DynamicInsert
@Entity(name = "Pnr")
@Table(name = "pnr")
public class Pnr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    public int numberOfPassengers;

    @Column
    public String pnrTransDate;

    @Column
    public String pnrCreationDate;

    @Column
    public String lastTktDate;


//    @OneToOne(
//            fetch = FetchType.LAZY,
//            cascade = { CascadeType.ALL },
//            orphanRemoval=true
//    )
//    @JoinColumn(name = "booking_ref_id")
//    private BookingRefID bookingRefID;

    @Column
    private String bookingRefid;

    @Column
    public int bookingRefCompanyNameTravelSector;

    @Column
    public String bookingRefCompanyNameCode;


//    @OneToOne(
//            fetch = FetchType.LAZY,
//            cascade = { CascadeType.ALL },
//            orphanRemoval=true
//    )
//    @JoinColumn(name = "pos_id")
//    private Pos pos;

    @Column
    public String posSourceAgentSine;

    @Column
    public String posSourcePseudoCityCode;

    @Column
    public String posSourceIsoCountry;

    @Column
    public String posSourceIsoCurrency;

    @Column
    public String posSourceAgentDutyCode;

    @Column
    public String posSourceAirlineVendorID;

    @Column
    public String posSourceAirportCode;

    @Column
    public String posSourceRequestorid;

    @Column
    public int posSourceRequestorCompanyTravelSector;

    @Column
    public String posSourceRequestorCompanyCode;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL },
            orphanRemoval=true
    )
    @JoinColumn(name = "pnr_id")
    private List<Passenger> passengerList;
}
