package az.mm.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
public class HikariConnectionPoolMetricsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HikariConnectionPoolMetricsApplication.class, args);
    }

}
