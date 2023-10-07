package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcessBaggageDTO {


    private  String issuerCode;

    private  String serialNumber;

    private  int sequenceCount;

    private  String baggagePool;

    private int unitOfMeasureQuantity;

    private String unitOfMeasureCode;

    @XmlAttribute(name = "IssuerCode")
    public String getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }

    @XmlAttribute(name = "SerialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @XmlAttribute(name = "SequenceCount")
    public int getSequenceCount() {
        return sequenceCount;
    }

    public void setSequenceCount(int sequenceCount) {
        this.sequenceCount = sequenceCount;
    }

    @XmlAttribute(name = "BaggagePool")
    public String getBaggagePool() {
        return baggagePool;
    }

    public void setBaggagePool(String baggagePool) {
        this.baggagePool = baggagePool;
    }

    @XmlAttribute(name = "UnitOfMeasureQuantity")
    public int getUnitOfMeasureQuantity() {
        return unitOfMeasureQuantity;
    }

    public void setUnitOfMeasureQuantity(int unitOfMeasureQuantity) {
        this.unitOfMeasureQuantity = unitOfMeasureQuantity;
    }

    @XmlAttribute(name = "UnitOfMeasureCode")
    public String getUnitOfMeasureCode() {
        return unitOfMeasureCode;
    }

    public void setUnitOfMeasureCode(String unitOfMeasureCode) {
        this.unitOfMeasureCode = unitOfMeasureCode;
    }
}
