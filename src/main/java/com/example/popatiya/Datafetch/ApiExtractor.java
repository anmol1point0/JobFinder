package com.example.popatiya.Datafetch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import com.careerjet.webservice.api.Client;

@Component
public class ApiExtractor {

    List<JSONObject> jsonList = new ArrayList<>();

    public List<JSONObject> FindDailyJobs(List<String> Cities) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        for (int i = 0; i < 9; i++) {
            Client client = new Client("en_GB");

            Map<String, String> args = new HashMap<>();
            String city = Cities.get(i);
            args.put("keywords", "Developer");
            args.put("location", city);

            args.put("affid", "b4737c7ce8a491388f964d68339a391f");

            args.put("user_ip", "117.199.234.226");
            args.put("user_agent", "Mozilla");
            args.put("url", "https://www.facebook.com/");

            JSONObject results = (JSONObject) client.search(args);
            if (results.get("type").equals("JOBS")) {
                JSONArray jobslist = (JSONArray) results.get("jobs");
                if (jobslist == null) {
                    continue;
                }
                int index = 0;
                while (index < jobslist.size()) {
                    JSONObject job = (JSONObject) jobslist.get(index);
                    String current_date = (String) job.get("date");
                    String[] values = current_date.split(" ");
                    String sdate = values[1] + " " + values[2] + " " + values[3];
                    LocalDate date = LocalDate.parse(sdate, formatter);
                    LocalDate today = LocalDate.now();
                    if (date.getYear() == today.getYear() && date.getMonth() == today.getMonth()
                            && date.getDayOfYear() == today.getDayOfYear()) {
                        jsonList.add(job);
                    }
                    index++;
                }
            }
        }
        return jsonList;
    }
}
