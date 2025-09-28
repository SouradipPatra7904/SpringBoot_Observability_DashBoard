package souradippatra.SpringBoot_Observability_DashBoard.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import souradippatra.SpringBoot_Observability_DashBoard.dto.MetricResponseDTO;

@Service
public class MetricService {

    private final Counter sampleCounter;
    private final Timer sampleTimer;

    public MetricService(Counter sampleCounter, Timer sampleTimer) {
        this.sampleCounter = sampleCounter;
        this.sampleTimer = sampleTimer;
    }

    /**
     * Increments the counter and returns a DTO
     */
    public MetricResponseDTO incrementAndGetMetric() {
        sampleCounter.increment();
        return new MetricResponseDTO(
                "custom.requests.total",
                sampleCounter.count()        );
    }

    /**
     * Simulate a slow task for demo (to see Timer in action)
     */
    public MetricResponseDTO simulateSlowRequest() {
        return sampleTimer.record(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); // simulate latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new MetricResponseDTO(
                    "custom.slow.request",
                    sampleCounter.count()
            );
        });
    }

    /**
     * Gets current value without incrementing
     */
    public MetricResponseDTO getMetricValue() {
        return new MetricResponseDTO(
                "The custom metric that I created : 'custom.requests.total' ",
                sampleCounter.count()
        );
    }
}
