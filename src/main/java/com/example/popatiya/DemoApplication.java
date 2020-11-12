package com.example.popatiya;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.example.popatiya.datafetch.dataget;
import com.example.popatiya.repository.myrepo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    // @Autowired
    // private static dataget Data;
    // @Autowired
    // private static myrepo myRepo;

    public static void main(String[] arg) throws IOException {
        // myrepo myRepo = new myrepo();
        dataget Data = new dataget();
        Data.runMethod();
        // SpringApplication.run(DemoApplication.class, arg);

    }

    // @PostConstruct
    // private void init() {
    // Data.runMethod();
    // // ...
    // }
}
