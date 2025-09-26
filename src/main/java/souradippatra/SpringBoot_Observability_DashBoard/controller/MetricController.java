package souradippatra.SpringBoot_Observability_DashBoard.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import souradippatra.SpringBoot_Observability_DashBoard.dto.MetricResponseDTO;
import souradippatra.SpringBoot_Observability_DashBoard.service.MetricService;

@RestController
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping("/increment")
    public MetricResponseDTO incrementMetric() {
        return metricService.incrementAndGetMetric();
    }

    @GetMapping("/metrics/custom")
    public MetricResponseDTO getCustomMetric() {
        return metricService.getMetricValue();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("I wrote this ResponseEntity; big milestone!", HttpStatusCode.valueOf(201));
    }
}
