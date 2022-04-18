package com.example.lab4_clase.entity;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Locations {

    @Id
    @Column(name = "location_id")
    private int id;
    @Column(name = "street_address")
    private String streetaddress;
    @Column(name = "postal_code")
    private String postalcode;
    @Column(nullable = false)
    private String city;
    @Column(name = "state_province")
    private String stateprovince;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private com.example.lab4_clase.entity.Countries countryid;

    public int getid() {
        return id;
    }

    public void setLocationid(int id) {
        this.id = id;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateprovince() {
        return stateprovince;
    }

    public void setStateprovince(String stateprovince) {
        this.stateprovince = stateprovince;
    }

    public com.example.lab4_clase.entity.Countries getCountryid() {
        return countryid;
    }

    public void setCountryid(com.example.lab4_clase.entity.Countries countryid) {
        this.countryid = countryid;
    }
}
