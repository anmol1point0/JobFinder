package com.example.popatiya.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @JsonProperty("date")
    private String date;

    @JsonProperty("site")
    private String site;

    @JsonProperty("description")
    private String description;

    @JsonProperty("locations")
    private String locations;

    @JsonProperty("company")
    private String company;

    @JsonProperty("title")
    private String title;

    @JsonProperty("salary")
    private String salary;

    @JsonProperty("url")
    private String url;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Job(@NonNull Long id, String date, String site, String description, String locations, String company,
            String title, String salary, String url) {
        Id = id;
        this.date = date;
        this.site = site;
        this.description = description;
        this.locations = locations;
        this.company = company;
        this.title = title;
        this.salary = salary;
        this.url = url;
    }

    public Job() {
    }
}
