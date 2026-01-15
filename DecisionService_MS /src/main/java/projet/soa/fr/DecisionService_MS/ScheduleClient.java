package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import projet.soa.fr.DecisionService_MS.model.NextCourseResponse;

@Component
public class ScheduleClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8087/schedule/";

    public Long minutesBeforeNextCourse(String classroom) {
        try {
            NextCourseResponse response = restTemplate.getForObject(url + "/" + classroom + "/next", NextCourseResponse.class);
            
            if (response == null) {
                return -1L;
            }
            
            return response.getDeltaMinutes();

        } catch (Exception e) {

            System.err.println("Erreur appel Schedule : " + e.getMessage());
            return -1L;
        }
    }
}

