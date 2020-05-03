package az.mm.metrics.service;

import az.mm.metrics.util.MetricsUtil;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.AvailableTag;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.MetricResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mushfiq on 5/3/2020
 */

@Service
public class MetricsService {

    private final MetricsEndpoint metricsEndpoint;
    private final Map<String, String> hikariFields;

    public MetricsService(MetricsEndpoint metricsEndpoint) {
        this.metricsEndpoint = metricsEndpoint;
        this.hikariFields = MetricsUtil.hikariMetricFields();
    }

    public Map<String, Map> hikariConnectionPoolMetrics() {
        MetricResponse hikariPoolInfo = metricsEndpoint.metric(hikariFields.get("total"), null);
        AvailableTag availableTag = hikariPoolInfo.getAvailableTags().get(0);
        String tagName = availableTag.getTag();
        Set<String> tagValues = availableTag.getValues();
        Map<String, Map> connections = new HashMap<>();

        for (String tagValue : tagValues) {
            Map<String, Object> params = new LinkedHashMap<>();
            hikariFields.forEach((k, v) -> {
                MetricResponse metricResponse = metricsEndpoint.metric(v, Arrays.asList(tagName + ":" + tagValue));
                Integer val = metricResponse.getMeasurements().get(0).getValue().intValue();
                params.put(k, val);
            });
            connections.put(tagValue, params);
        }
        return connections;
    }
}
