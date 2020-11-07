package com.example.popatiya;

import com.careerjet.webservice.api.Client;
import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] arg) {

        SpringApplication.run(DemoApplication.class, arg);
        runMethod();
    }

    static void runMethod() {

        Client client = new Client("en_GB");

        Map<String, String> args = new HashMap<>();

        args.put("keywords", "java");
        args.put("location", "london");

        args.put("affid", "b4737c7ce8a491388f964d68339a391f");

        args.put("user_ip", "117.199.203.226");
        args.put("user_agent", "Chrome");
        args.put("url", "https://www.youtube.com/");

        JSONObject results = (JSONObject) client.search(args);

        if (results.get("type").equals("JOBS")) {
            JSONArray jobs = (JSONArray) results.get("jobs");
            System.out.println("Number of results:" + results.get("hits"));
            System.out.println("hob size:" + jobs.size());
            int index = 0;
            while (index < jobs.size()) {
                JSONObject job = (JSONObject) jobs.get(index);
                System.out.println("URL         :" + job.get("url"));
                System.out.println("TITLE       :" + job.get("title"));
                System.out.println("COMPANY     :" + job.get("company"));
                System.out.println("SALARY      :" + job.get("salary"));
                System.out.println("DATE        :" + job.get("date"));
                System.out.println("DESCRIPTION :" + job.get("description"));
                System.out.println("SITE        :" + job.get("site"));
                System.out.println("LOCATIONS   :" + job.get("locations"));
                index++;
            }
        }
    }
}
