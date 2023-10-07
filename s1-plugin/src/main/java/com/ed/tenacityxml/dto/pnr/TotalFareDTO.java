package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class TotalFareDTO {

    private String currencyCode;

    private double amount;

    @XmlAttribute(name = "CurrencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }
    @XmlAttribute(name = "Amount")
    public double getAmount() {
        return amount;
    }
}
