package com.ed.tenacityxml.model.pnr;

import com.ed.tenacityxml.dto.pnr.DocSsrDTO;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@DynamicUpdate
@DynamicInsert
@Entity(name = "DocSsr")
@Table(name = "doc_ssr")
public class DocSsr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /* DOCA Fields*/

    @Column
    public String docaStatus;

    @Column
    public int docaServiceQuantity;

    @Column
    public String docaSsrCode;

    @Column
    public String docaFlightInfoCode;

    @Column
    private String docaAddressType;

    @Column
    private String docaAddress;

    @Column
    private String docaCityName;

    @Column
    private String docaPostalCode;

    @Column
    private String docaStateProvCounty;

    @Column
    private String docaCountry;


    /* DOCO Fields*/

    @Column
    public String docoStatus;

    @Column
    public int docoServiceQuantity;

    @Column
    public String docoSsrCode;

    @Column
    public String docoFlightInfoCode;


    @Column
    private String docoBirthLocation;

    @Column
    private String docoTravelDocType;

    @Column
    private String docoTravelDocNbr;

    @Column
    private String docoPlaceofIssue;

    @Column
    private String docoDateofIssue;

    @Column
    private String docoCountryState;

    /* DOCs Fields*/

    @Column
    public String docsStatus;

    @Column
    public int docsServiceQuantity;

    @Column
    public String docsSsrCode;

    @Column
    public String docsFlightInfoCode;


    @Column
    private String docsDateofBirth;

    @Column
    private String docsExpiryDate;

    @Column
    private String docsFirstGivenname;

    @Column
    private String docsFecondGivenname;

    @Column
    private String docsSurname;

    @Column
    private String docsGender;

    @Column
    private String docsIssuingLoc;

    @Column
    private String docsPaxNationality;

    @OneToOne
    @MapsId
    private Passenger passenger;
}
