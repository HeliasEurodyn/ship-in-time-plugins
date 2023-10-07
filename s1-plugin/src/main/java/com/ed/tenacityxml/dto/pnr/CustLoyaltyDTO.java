package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustLoyaltyDTO {

    private String programID;

    private String membershipID;

    @XmlAttribute(name = "ProgramID")
    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    @XmlAttribute(name = "MembershipID")
    public String getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(String membershipID) {
        this.membershipID = membershipID;
    }
}
