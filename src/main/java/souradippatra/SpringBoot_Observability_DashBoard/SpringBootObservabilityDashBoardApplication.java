package souradippatra.SpringBoot_Observability_DashBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.micrometer.core.instrument.Counter;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
public class SpringBootObservabilityDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootObservabilityDashBoardApplication.class, args);
	}

	@Bean
    public Counter sampleCounter(MeterRegistry registry) {
        return Counter.builder("custom.requests.total")
                      .description("Total number of custom requests")
                      .register(registry);
    }

}
