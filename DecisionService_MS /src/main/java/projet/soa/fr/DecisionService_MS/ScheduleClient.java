package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduleClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8087/schedule/next";

    /**
     * Retourne le nombre de minutes avant le prochain cours
     * -1 si aucun cours prévu
     */
    public int minutesBeforeNextCourse(Long classId) {
        return restTemplate.getForObject(url + "?classId=" + classId, Integer.class);
    }
}

