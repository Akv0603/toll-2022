package jdev.tracker;

import dao.Coords;
import dao.repo.CoordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

@EnableJpaRepositories("dao.repo")
@EntityScan(basePackageClasses = dao.Coords.class)
@ComponentScan({"jdev.tracker.services", "jdev.tracker"})

public class SchedMain {
    public static void main(String[] args) throws InterruptedException {
        //ApplicationContext context = new AnnotationConfigApplicationContext(SchedulingContext.class);
        SpringApplication.run(SchedMain.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
