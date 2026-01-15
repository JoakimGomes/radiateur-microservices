package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import projet.soa.fr.DecisionService_MS.model.Temperature_Sensor;

@Component
public class TemperatureClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8085/temperature_sensors/";

    public double getCurrentTemperature(String classroom) {
    	Temperature_Sensor Temperature;
    	Temperature = restTemplate.getForObject(url + classroom, Temperature_Sensor.class);
        return Temperature.getTemperature();
    }
}
