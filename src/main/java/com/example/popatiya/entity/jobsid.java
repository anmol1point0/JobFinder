package com.example.popatiya.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.NonNull;

@Embeddable
public class jobsid implements Serializable {

    /**
     *
     */
    public static final long serialVersionUID = 1L;

    @NonNull
    public LocalDate date;

    @NonNull
    public String location;

    public jobsid() {
        super();
    }

    public jobsid(LocalDate curr_date, String loc) {
        super();
        date = curr_date;
        location = loc;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
