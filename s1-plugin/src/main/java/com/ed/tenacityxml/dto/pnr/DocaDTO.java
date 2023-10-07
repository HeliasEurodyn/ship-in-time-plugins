package com.ed.tenacityxml.dto.pnr;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
@Setter
@Data
@NoArgsConstructor
public class DocaDTO {

    private String addressType;

    private String address;

    private String cityName;

    private String postalCode;

    private String stateProvCounty;

    private String country;

    @XmlAttribute(name = "AddressType")
    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @XmlAttribute(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlAttribute(name = "CityName")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlAttribute(name = "PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @XmlAttribute(name = "StateProvCounty")
    public String getStateProvCounty() {
        return stateProvCounty;
    }

    public void setStateProvCounty(String stateProvCounty) {
        this.stateProvCounty = stateProvCounty;
    }

    @XmlAttribute(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
