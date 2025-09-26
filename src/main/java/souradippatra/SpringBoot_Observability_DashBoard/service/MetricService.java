package souradippatra.SpringBoot_Observability_DashBoard.service;

import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Service;
import souradippatra.SpringBoot_Observability_DashBoard.dto.MetricResponseDTO;

@Service
public class MetricService {

    private final Counter sampleCounter;

    public MetricService(Counter sampleCounter) {
        this.sampleCounter = sampleCounter;
    }

    /**
     * Increments the counter and returns a DTO
     */
    public MetricResponseDTO incrementAndGetMetric() {
        sampleCounter.increment();
        return new MetricResponseDTO(
                "custom.requests.total",
                sampleCounter.count()
        );
    }

    /**
     * Gets current value without incrementing
     */
    public MetricResponseDTO getMetricValue() {
        return new MetricResponseDTO(
                "custom.requests.total",
                sampleCounter.count()
        );
    }
}
