package siit.proiectfinal.asociatie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DataConfig {

    @Bean
    public DataSource postgressqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/jdbcdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
//        dataSource.setSchema("");

        return dataSource;
    }


}
