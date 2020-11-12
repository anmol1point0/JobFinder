package com.example.popatiya.datafetch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.careerjet.webservice.api.Client;
import com.example.popatiya.entity.jobs;
import com.example.popatiya.entity.jobsid;
import com.example.popatiya.repository.myrepo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class dataget {

    public void runMethod() throws IOException {

        // FileWriter fw = null;
        // BufferedWriter bw = null;
        // PrintWriter pw = null;

        // fw = new FileWriter("/home/nmole/Documents/final-project/", true);
        // bw = new BufferedWriter(fw);
        // pw = new PrintWriter(bw);
        // List<jobs> jobsTosave = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        cities.add("jaipur");
        cities.add("mumbai");
        cities.add("bangalore");
        cities.add("chennai");
        cities.add("hyderabad");
        cities.add("lucknow");
        cities.add("ranchi");
        cities.add("patna");
        cities.add("bhopal");
        cities.add("kerala");
        // SimpleDateFormat targetFormat = new SimpleDateFormat("yyyyMMdd");
        // LocalDate curr_date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        // DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 9; i++) {
            Client client = new Client("en_GB");

            Map<String, String> args = new HashMap<>();
            String city = cities.get(i);
            args.put("keywords", "Developer");
            args.put("location", city);

            args.put("affid", "b4737c7ce8a491388f964d68339a391f");

            args.put("user_ip", "117.199.203.226");
            args.put("user_agent", "Chrome");
            args.put("url", "https://www.youtube.com/");

            JSONObject results = (JSONObject) client.search(args);
            int count = 0;
            if (results.get("type").equals("JOBS")) {
                JSONArray jobslist = (JSONArray) results.get("jobs");
                // System.out.println("Number of results:" + results.get("hits"));
                if (jobslist == null) {
                    continue;
                }

                // ObjectMapper mapper = new ObjectMapper();
                // List<jobs> company_jobs = mapper.readValue(,)
                // System.out.println("job size:" + jobs.size());
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
                        count++;
                    }
                    System.out.println("URL :" + job.get("url"));
                    System.out.println("TITLE :" + job.get("title"));
                    System.out.println("COMPANY :" + job.get("company"));
                    System.out.println("SALARY :" + job.get("salary"));
                    System.out.println("DATE :" + job.get("date"));
                    System.out.println("DESCRIPTION :" + job.get("description"));
                    System.out.println("SITE :" + job.get("site"));
                    System.out.println("LOCATIONS :" + job.get("locations"));
                    // pw.println("URL :" + job.get("url"));
                    // pw.println("TITLE :" + job.get("title"));
                    // pw.println("COMPANY :" + job.get("company"));
                    // pw.println("SALARY :" + job.get("salary"));
                    // pw.println("DATE :" + job.get("date"));
                    // pw.println("DESCRIPTION :" + job.get("description"));
                    // pw.println("SITE :" + job.get("site"));
                    // pw.println("LOCATIONS :" + job.get("locations"));
                    index++;
                }
            }
            System.out.println(LocalDate.now() + " " + city + " " + count);
            // jobsid id = new jobsid(LocalDate.now(), city);
            // jobs myjob = new jobs(id, count);
            // jobsTosave.add(myjob);
        }
        // System.out.println("HEY thos is first " + jobsTosave.get(0).getCount() + " "
        // + " "
        // + jobsTosave.get(0).jobsId.getLocation());
        // myRepo.saveAll(jobsTosave);
    }
}
