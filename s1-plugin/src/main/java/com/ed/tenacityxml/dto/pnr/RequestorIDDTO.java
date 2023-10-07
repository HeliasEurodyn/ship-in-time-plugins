package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestorIDDTO {
    private String requestorid;

    private CompanyNameDTO companyName;

    @XmlAttribute(name = "ID")
    public String getRequestorid() {
        return requestorid;
    }

    public void setRequestorid(String requestorid) {
        this.requestorid = requestorid;
    }

    @XmlElement(name = "CompanyName")
    public CompanyNameDTO getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyNameDTO companyName) {
        this.companyName = companyName;
    }
}
