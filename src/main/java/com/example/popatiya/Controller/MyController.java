package com.example.popatiya.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.popatiya.Datafetch.ApiExtractor;
import com.example.popatiya.Repository.MyRepo;
import com.example.popatiya.entity.Job;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MyController {

    @Autowired
    private ApiExtractor apiExtractor;

    @Autowired
    private MyRepo myRepo;

    @GetMapping("/jobs")
    public List<JSONObject> runMethod() throws IOException {
        List<String> cities = new ArrayList<>();
        cities.add("jaipur");
        cities.add("pune");
        cities.add("mumbai");
        cities.add("bangalore");
        cities.add("chennai");
        cities.add("hyderabad");
        cities.add("lucknow");
        cities.add("ranchi");
        cities.add("patna");
        cities.add("bhopal");
        cities.add("kerala");
        List<JSONObject> jobs = apiExtractor.FindDailyJobs(cities);
        Gson gson = new Gson();
        ObjectMapper obj = new ObjectMapper();
        for (int i = 0; i < jobs.size(); i++) {
            String json_String = gson.toJson(jobs.get(i));
            Job myJob = obj.readValue(json_String, Job.class);
            System.out.println(myJob.getCompany() + " " + myJob.getLocations());
            myRepo.save(myJob);
        }
        return jobs;
    }
}
