package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import server.repo.CoordsRepository;
@SpringBootApplication
public class GetCoordsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GetCoordsApplication.class, args);
    }
}
