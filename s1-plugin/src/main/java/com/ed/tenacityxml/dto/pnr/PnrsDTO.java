package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PnrsDTO {

    private int numberOfPnrs;

    private List<PnrDTO> pnr;

    @XmlAttribute(name = "NumberOfPnrs")
    public int getNumberOfPnrs() {
        return numberOfPnrs;
    }

    public void setNumberOfPnrs(int numberOfPnrs) {
        this.numberOfPnrs = numberOfPnrs;
    }

    @XmlElement(name = "PNR")
    public List<PnrDTO> getPnr() {
        return pnr;
    }

    public void setPnr(List<PnrDTO> pnr) {
        this.pnr = pnr;
    }
}
