package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class DocsDTO {

    private String dateofBirth;
    private String expiryDate;
    private String firstGivenname;
    private String secondGivenname;
    private String surname;
    private String gender;
    private String issuingLoc;
    private String paxNationality;

    @XmlAttribute(name = "DateOfBirth")
    public String getDateofBirth() {
        return dateofBirth;
    }

    @XmlAttribute(name = "ExpiryDate")
    public String getExpiryDate() {
        return expiryDate;
    }

    @XmlAttribute(name = "FirstGivenName")
    public String getFirstGivenname() {
        return firstGivenname;
    }

    @XmlAttribute(name = "SecondGivenName")
    public String getSecondGivenname() {
        return secondGivenname;
    }

    @XmlAttribute(name = "Surname")
    public String getSurname() {
        return surname;
    }

    @XmlAttribute(name = "Gender")
    public String getGender() {
        return gender;
    }

    @XmlAttribute(name = "IssuingLoc")
    public String getIssuingLoc() {
        return issuingLoc;
    }

    @XmlAttribute(name = "PaxNationality")
    public String getPaxNationality() {
        return paxNationality;
    }

}
