package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRefIDDTO {


    private String bookingRefid;


    private CompanyNameDTO companyName;

    @XmlAttribute(name = "ID")
    public String getBookingRefid() {
        return bookingRefid;
    }

    public void setBookingRefid(String bookingRefid) {
        this.bookingRefid = bookingRefid;
    }
    @XmlElement(name = "CompanyName")
    public CompanyNameDTO getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyNameDTO companyName) {
        this.companyName = companyName;
    }
}
