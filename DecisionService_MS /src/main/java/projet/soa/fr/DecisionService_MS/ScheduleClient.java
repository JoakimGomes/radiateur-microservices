package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import projet.soa.fr.DecisionService_MS.model.NextCourseResponse;

@Component
public class ScheduleClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8087/schedule/";

    /**
     * Retourne le nombre de minutes avant le prochain cours
     * -1 si aucun cours prévu
     */
    public Long minutesBeforeNextCourse(String classroom) {
    	NextCourseResponse TimeBeforeNextCourse = restTemplate.getForObject(
                url + "/" + classroom + "/next", NextCourseResponse.class);
    	
    	return TimeBeforeNextCourse.getDeltaMinutes();
    	}
}

