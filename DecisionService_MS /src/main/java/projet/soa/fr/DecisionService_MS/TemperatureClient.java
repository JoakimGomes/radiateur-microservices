package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TemperatureClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8085/temperature_sensors";

    public double getCurrentTemperature(Long classId) {
        return restTemplate.getForObject(url + "?classId=" + classId, Double.class);
    }
}
