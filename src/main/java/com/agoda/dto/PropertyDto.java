package com.agoda.dto;

import com.agoda.entity.Country;
import com.agoda.entity.Location;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PropertyDto {
    private Long id;

    private Integer noGuests;

    private Integer noBedrooms;

    private Integer noBathrooms;

    private String name;

    private Integer price;

    private Location location;

    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoBathrooms() {
        return noBathrooms;
    }

    public void setNoBathrooms(Integer noBathrooms) {
        this.noBathrooms = noBathrooms;
    }

    public Integer getNoBedrooms() {
        return noBedrooms;
    }

    public void setNoBedrooms(Integer noBedrooms) {
        this.noBedrooms = noBedrooms;
    }

    public Integer getNoGuests() {
        return noGuests;
    }

    public void setNoGuests(Integer noGuests) {
        this.noGuests = noGuests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
