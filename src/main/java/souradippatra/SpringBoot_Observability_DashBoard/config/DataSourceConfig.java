package souradippatra.SpringBoot_Observability_DashBoard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/observability_db")
                .username("diamondback")
                .password("diamondback")
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}

