package be.abd.helbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@SpringBootApplication
public class DemoHelbApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoHelbApplication.class, args);

    }
}
