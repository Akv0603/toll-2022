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
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Akv0603 14.10.22.
 * Создание контекста
 */
@Configuration
@EnableScheduling
@EnableJpaRepositories("dao.repo")
@PropertySource("classpath:/application.properties")

public class SchedulingContext {
    @Bean
    public GPSService gpsService(){
        return new GPSService();
    }

    @Bean
    public SendService sendService(){
        return new SendService();
    }

    @Bean
    public StorageService getStorage() {
        return new StorageService();
    }

    //контейнер исполняющих потоков. Возможно исполнение до 20 потоков.
    @Bean
    public TaskScheduler poolScheduler(){
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("poolScheduler");
        scheduler.setPoolSize(20);
        return scheduler;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
