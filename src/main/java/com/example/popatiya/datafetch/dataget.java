package com.example.popatiya.datafetch;

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

import com.careerjet.webservice.api.Client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class dataget {

    public void runMethod() throws IOException {

        FileWriter fw = null;
        FileWriter fw1 = null;
        BufferedWriter bw = null;
        BufferedWriter bw1 = null;
        PrintWriter pw = null;
        PrintWriter pw1 = null;
        // List<jobs> jobsTosave = new ArrayList<>();
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
        // SimpleDateFormat targetFormat = new SimpleDateFormat("yyyyMMdd");
        // LocalDate curr_date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        fw = new FileWriter("jobslogs-20-Dec.txt", true);
        fw1 = new FileWriter("Weekly-Report.txt", true);
        bw1 = new BufferedWriter(fw1);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
        pw1 = new PrintWriter(bw1);
        pw.println("Date:" + LocalDate.now());
        // DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 9; i++) {
            Client client = new Client("en_GB");

            Map<String, String> args = new HashMap<>();
            String city = cities.get(i);
            args.put("keywords", "Developer");
            args.put("location", city);

            args.put("affid", "b4737c7ce8a491388f964d68339a391f");

            args.put("user_ip", "117.199.234.226");
            args.put("user_agent", "Mozilla");
            args.put("url", "https://www.facebook.com/");

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
                        pw.println(job);
                        // System.out.println(
                        // "shdcposted!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        // System.out.println("URL :" + job.get("url"));
                        // System.out.println("TITLE :" + job.get("title"));
                        // System.out.println("COMPANY :" + job.get("company"));
                        // System.out.println("SALARY :" + job.get("salary"));
                        // System.out.println("DATE :" + job.get("date"));
                        // System.out.println("DESCRIPTION :" + job.get("description"));
                        // System.out.println("SITE :" + job.get("site"));
                        // System.out.println("LOCATIONS :" + job.get("locations"));
                        // pw.print("URL :" + job.get("url") + " ");
                        // pw.print("TITLE :" + job.get("title") + " ");
                        // pw.print("COMPANY :" + job.get("company") + " ");
                        // pw.print("SALARY :" + job.get("salary") + " ");
                        // pw.print("DATE :" + job.get("date") + " ");
                        // pw.print("DESCRIPTION :" + job.get("description") + " ");
                        // pw.print(job.get("SITE :" + "site") + " ");
                        // pw.println(job.get("LOCATIONS :" + "locations"));
                    }
                    // pw.println("printed");
                    index++;
                }
            }
            pw1.println(LocalDate.now() + " " + city + " " + count);
            // jobsid id = new jobsid(LocalDate.now(), city);
            // jobs myjob = new jobs(id, count);
            // jobsTosave.add(myjob);
        }
        pw.close();
        pw1.close();
        // System.out.println("HEY thos is first " + jobsTosave.get(0).getCount() + " "
        // + " "
        // + jobsTosave.get(0).jobsId.getLocation());
        // myRepo.saveAll(jobsTosave);
    }
}
