package jdev.tracker;

import jdev.tracker.services.GPSService;
import jdev.tracker.services.SendService;
import jdev.tracker.services.StorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

/**
 * Created by Akv0603 14.10.22.
 * Создание контекста
 */
@Configuration
@EnableScheduling
@PropertySource("classpath:/app.properties")
public class SchedulingContext {
    @Bean
    public GPSService gpsService(){
        return new GPSService();
    }

    @Bean
    public SendService sendService(){
        return new SendService();
    }

    //контейнер исполняющих потоков. Возможно исполнение до 20 потоков.
    @Bean
    public TaskScheduler poolScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }
}
