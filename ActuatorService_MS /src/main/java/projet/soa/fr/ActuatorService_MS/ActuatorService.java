package projet.soa.fr.ActuatorService_MS;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ActuatorService {

    public static class ActuatorState {
        public boolean heatingOn;
        public String mode;
        public double targetTemperature;

        public ActuatorState(boolean heatingOn, String mode, double targetTemperature) {
            this.heatingOn = heatingOn;
            this.mode = mode;
            this.targetTemperature = targetTemperature;
        }
        public ActuatorState() {} 
    }

    public static class DecisionResponse {
        public boolean heating;
        public String mode;
        public double currentTemp;
    }

    private final Map<String, ActuatorState> actuators = new ConcurrentHashMap<>();
    
    private final RestTemplate restTemplate = new RestTemplate();
    
    private final String decisionUrl = "http://localhost:8088/decision/heating";

    public void applyDecisionFromDecisionService(String classroom) {
        String url = decisionUrl + "?classroom=" + classroom;

        try {
            DecisionResponse response = restTemplate.getForObject(url, DecisionResponse.class);

            if (response != null) {
                double targetTemp = 0.0;
                if ("PREHEAT".equals(response.mode)) targetTemp = 22.0;
                else if ("NORMAL".equals(response.mode)) targetTemp = 19.0;

                ActuatorState newState = new ActuatorState(
                        response.heating,
                        response.mode,
                        targetTemp
                );

                actuators.put(classroom, newState);
                
                System.out.println("UPDATE salle " + classroom + " -> " + response.mode);
            }
        } catch (Exception e) {
            System.err.println("Erreur appel Decision pour " + classroom + ": " + e.getMessage());
        }
    }

    public ActuatorState getActuatorState(String classroom) {
        return actuators.get(classroom);
    }
}