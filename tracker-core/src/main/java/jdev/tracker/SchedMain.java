package jdev.tracker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;

/**
 * Created by Akv0603 14.10.22.
 */
@SpringBootApplication
public class SchedMain {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchedulingContext.class);
        SpringApplication.run(SchedMain.class, args);

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
