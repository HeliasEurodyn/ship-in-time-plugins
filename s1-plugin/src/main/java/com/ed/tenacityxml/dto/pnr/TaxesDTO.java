package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

@Setter
@Data
@NoArgsConstructor
public class TaxesDTO {

    private TaxDTO tax;

    @XmlElement(name = "Tax")
    public TaxDTO getTax() {
        return tax;
    }
}
