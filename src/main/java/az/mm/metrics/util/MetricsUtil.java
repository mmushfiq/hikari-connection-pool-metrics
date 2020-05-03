package az.mm.metrics.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Mushfiq on 5/3/2020
 */
public class MetricsUtil {

    private MetricsUtil() {
    }

    public static Map<String, String> hikariMetricFields() {
        Map<String, String> hikariFields = new LinkedHashMap<>();
        hikariFields.put("total", "hikaricp.connections");
        hikariFields.put("active", "hikaricp.connections.active");
        hikariFields.put("idle", "hikaricp.connections.idle");
        hikariFields.put("waiting", "hikaricp.connections.pending");
        return hikariFields;
    }
}
