package projet.soa.fr.DecisionService_MS;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decision")
public class DecisionService_Ressource {

    private final DecisionService decisionService;

    public DecisionService_Ressource(DecisionService decisionService) {
        this.decisionService = decisionService;
    }

    @GetMapping("/heating")
    public DecisionResponse getHeatingDecision(@RequestParam Long classId) {
        return decisionService.evaluate(classId);
    }
}
