
import java.util.Map;

public record Moneda(String base_code,
                     String time_next_update_utc,
                     Map<String, Double> conversion_rates
                    ) {
}
