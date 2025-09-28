package souradippatra.SpringBoot_Observability_DashBoard;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@SpringBootApplication
public class SpringBootObservabilityDashBoardApplication {

    private final AtomicInteger activeUsers = new AtomicInteger(0);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootObservabilityDashBoardApplication.class, args);
	}

	@Bean
    public Counter sampleCounter(MeterRegistry registry) {
        return Counter.builder("custom.requests.total")
                      .description("Total number of custom requests")
                      .register(registry);
    }

    @Bean
    public Timer requestTimer(MeterRegistry meterRegistry){
        return Timer.builder("custom.requests.duration")
                    .description("Time taken for /increment endpoint")
                    .publishPercentiles(0.5, 0.95, 0.99) // p50, p95, p99
                    .register(meterRegistry);
    }

    @Bean
    public AtomicInteger activeUsers(MeterRegistry meterRegistry){
        meterRegistry.gauge("custom.active.users", activeUsers);
        return activeUsers;
    }

}
