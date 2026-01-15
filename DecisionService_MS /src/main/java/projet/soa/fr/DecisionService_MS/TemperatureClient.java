package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import projet.soa.fr.DecisionService_MS.model.Temperature_Sensor;

@Component
public class TemperatureClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8089/temperature_sensors";

    public double getCurrentTemperature(String classroom) {
        String urlAppel = url + "/search?room=" + classroom;
        try {
            Double temp = restTemplate.getForObject(urlAppel, Double.class);
            return temp != null ? temp : Double.NaN;
        } catch (Exception e) {
            return Double.NaN; 
        }
    }
}
