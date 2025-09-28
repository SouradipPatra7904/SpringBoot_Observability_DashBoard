package souradippatra.SpringBoot_Observability_DashBoard.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import souradippatra.SpringBoot_Observability_DashBoard.dto.MetricResponseDTO;
import souradippatra.SpringBoot_Observability_DashBoard.service.MetricService;


@RestController
public class MetricController {

    private final MetricService metricService;
    private final AtomicInteger activeUsers;

    public MetricController(MetricService metricService, AtomicInteger activeUsers) {
        this.metricService = metricService;
        this.activeUsers = activeUsers;
    }

    @GetMapping("/increment")
    public MetricResponseDTO incrementMetric() {
        return metricService.incrementAndGetMetric();
    }

    @GetMapping("/metrics/custom")
    public MetricResponseDTO getCustomMetric() {
        return metricService.getMetricValue();
    }

    @GetMapping("/simulate-slow")
    public MetricResponseDTO simulateSlowMetric() {
        return metricService.simulateSlowRequest();
    }
    

    @GetMapping("/user/login")
    public String userLogin() {
        int current = activeUsers.incrementAndGet();
        return "User logged in. Active users = " + current;
    }

    @GetMapping("/user/logout")
    public String userLogout() {
        int current = activeUsers.decrementAndGet();
        return "User logged in. Active users = " + current;
    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.status(HttpStatus.CREATED).header("App Version", "1.0.0").body("I wrote this ResponseEntity; big milestone! I love myself!");
    }
}
