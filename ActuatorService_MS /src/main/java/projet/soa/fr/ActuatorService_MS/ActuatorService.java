package projet.soa.fr.ActuatorService_MS;


import projet.soa.fr.DecisionService_MS.DecisionResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActuatorService {

    private boolean heatingOn = false;
    private String mode = "OFF"; // OFF, PREHEAT, NORMAL
    private double targetTemperature = 0;

    private final RestTemplate restTemplate = new RestTemplate();

    // URL DecisionService (à adapter selon ton port)
    private final String decisionUrl = "http://localhost:8088/decision/heating?classId=";

    /**
     * Met à jour l’état du chauffage en récupérant directement la décision
     * depuis le microservice Decision
     */
    public void applyDecisionFromDecisionService(Long classId) {

        DecisionResponse decision = restTemplate.getForObject(decisionUrl + classId, DecisionResponse.class);

        if (decision != null) {
            this.heatingOn = decision.isHeatingOn();
            this.mode = decision.getMode();
            this.targetTemperature = decision.getTargetTemperature();

            System.out.println("Actuator mis à jour : heatingOn=" + heatingOn +
                    " | mode=" + mode +
                    " | targetTemp=" + targetTemperature);
        }
    }

    // GETTERS
    public boolean isHeatingOn() {
        return heatingOn;
    }

    public String getMode() {
        return mode;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }
}