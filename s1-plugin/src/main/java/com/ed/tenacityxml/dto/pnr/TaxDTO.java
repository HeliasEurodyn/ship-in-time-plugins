package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class TaxDTO {

    private String currencyCode;

    private double amount;

    private String taxType;

    private String isoCountry;


    @XmlAttribute(name = "CurrencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @XmlAttribute(name = "Amount")
    public double getAmount() {
        return amount;
    }

    @XmlAttribute(name = "TaxType")
    public String getTaxType() {
        return taxType;
    }

    @XmlAttribute(name = "ISOCountry")
    public String getIsoCountry() {
        return isoCountry;
    }
}
