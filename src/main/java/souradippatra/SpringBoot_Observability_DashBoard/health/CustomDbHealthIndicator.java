package souradippatra.SpringBoot_Observability_DashBoard.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomDbHealthIndicator implements HealthIndicator {

    private final JdbcTemplate jdbcTemplate;

    public CustomDbHealthIndicator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Health health() {
        try {
            // Lightweight query to check DB connectivity
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return Health.up().withDetail("database", "PostgreSQL is reachable").build();
        } catch (Exception e) {
            return Health.down(e).withDetail("database", "PostgreSQL connection failed").build();
        }
    }
}
