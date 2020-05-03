package az.mm.metrics.controller;

import az.mm.metrics.service.MetricsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Mushfiq on 5/3/2020
 */

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    private final MetricsService metricsService;

    public MetricsController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/hikari/connections")
    public Map<String, Map> getHikariConnectionsInfo() {
        return metricsService.hikariConnectionPoolMetrics();
    }
}
