package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@Data
@NoArgsConstructor
public class PaymentInfoDTO {

    private String cardHolderName;

    private String paymentType;

    private String paymentUse;

    private String paymentAmount;

    private String vendorCode;

    private String accountNbr;

    private String expiryDate;

    @XmlAttribute(name = "CardHolderName")
    public String getCardHolderName() {
        return cardHolderName;
    }

    @XmlAttribute(name = "PaymentType")
    public String getPaymentType() {
        return paymentType;
    }

    @XmlAttribute(name = "PaymentUse")
    public String getPaymentUse() {
        return paymentUse;
    }

    @XmlAttribute(name = "PaymentAmount")
    public String getPaymentAmount() {
        return paymentAmount;
    }

    @XmlAttribute(name = "VendorCode")
    public String getVendorCode() {
        return vendorCode;
    }

    @XmlAttribute(name = "AccountNbr")
    public String getAccountNbr() {
        return accountNbr;
    }

    @XmlAttribute(name = "ExpiryDate")
    public String getExpiryDate() {
        return expiryDate;
    }
}
