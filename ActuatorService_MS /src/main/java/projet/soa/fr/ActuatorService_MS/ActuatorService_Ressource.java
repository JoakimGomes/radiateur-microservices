package projet.soa.fr.ActuatorService_MS;

import org.springframework.web.bind.annotation.*;
import projet.soa.fr.ActuatorService_MS.ActuatorService.ActuatorState;

@RestController
@RequestMapping("/actuator")
public class ActuatorService_Ressource {

    private final ActuatorService actuatorService;

    public ActuatorService_Ressource(ActuatorService actuatorService) {
        this.actuatorService = actuatorService;
    }

    @PostMapping("/update")
    public String updateFromDecision(@RequestParam String classroom) {
        actuatorService.applyDecisionFromDecisionService(classroom);
        return "Demande de mise à jour envoyée pour la salle : " + classroom;
    }


    @GetMapping("/state")
    public ActuatorState getState(@RequestParam String classroom) {
        ActuatorState state = actuatorService.getActuatorState(classroom);
        
        if (state == null) {
            return new ActuatorState(false, "UNKNOWN", 0.0);
        }
        return state;
    }
}
