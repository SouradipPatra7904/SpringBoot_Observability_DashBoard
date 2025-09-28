package souradippatra.SpringBoot_Observability_DashBoard.health;

import io.micrometer.core.instrument.Counter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UnifiedHealthIndicator implements HealthIndicator {

    private final JdbcTemplate jdbcTemplate;
    private final Counter requestCounter;
    private final AtomicInteger activeUsers;

    public UnifiedHealthIndicator(JdbcTemplate jdbcTemplate, Counter requestCounter, AtomicInteger activeUsers) {
        this.jdbcTemplate = jdbcTemplate;
        this.requestCounter = requestCounter;
        this.activeUsers = activeUsers;
    }

    @Override
    public Health health() {
        Health.Builder builder = Health.up();

        // --- 1️⃣ Check DB connectivity ---
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            builder.withDetail("database", "PostgreSQL is reachable");
        } catch (Exception e) {
            builder.down(e).withDetail("database", "PostgreSQL connection failed");
        }

        // --- 2️⃣ Add custom metrics info ---
        builder.withDetail("customRequestsTotal", requestCounter.count());

        // --- 3️⃣ Add active users gauge ---
        builder.withDetail("activeUsers", activeUsers.get());

        return builder.build();
    }
}
