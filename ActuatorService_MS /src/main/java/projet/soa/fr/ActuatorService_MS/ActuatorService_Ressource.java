package projet.soa.fr.ActuatorService_MS;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actuator")
public class ActuatorService_Ressource {

    private final ActuatorService actuatorService;

    public ActuatorService_Ressource(ActuatorService actuatorService) {
        this.actuatorService = actuatorService;
    }

    /**
     * Applique la décision depuis le microservice Decision
     */
    @PostMapping("/update/{classId}")
    public String updateFromDecision(@PathVariable Long classId) {
        actuatorService.applyDecisionFromDecisionService(classId);
        return "Actuator mis à jour pour classId=" + classId;
    }

    /**
     * Retourne l'état courant de l'actuator
     */
    @GetMapping("/state")
    public String getState() {
        return "heatingOn=" + actuatorService.isHeatingOn() +
                " | mode=" + actuatorService.getMode() +
                " | targetTemperature=" + actuatorService.getTargetTemperature();
    }
}
