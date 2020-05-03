package az.mm.metrics.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Mushfiq on 5/3/2020
 */

@Configuration
public class DatabaseConfig {

    @Primary
    @Bean("oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle-db")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mySqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql-db")
    public DataSource mySqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("h2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.h2-db")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }
}
