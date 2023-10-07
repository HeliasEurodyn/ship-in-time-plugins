package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
@Setter
@Data
@NoArgsConstructor
public class FlightInfoDTO {

    private String code;

    @XmlAttribute(name = "Code")
    public String getCode() {
        return code;
    }

}
