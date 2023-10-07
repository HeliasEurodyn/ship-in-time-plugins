package com.ed.tenacityxml.dto.pnr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PosDTO {


    private SourceDTO source;

    @XmlElement(name = "Source")
    public SourceDTO getSource() {
        return source;
    }

    public void setSource(SourceDTO source) {
        this.source = source;
    }
}
