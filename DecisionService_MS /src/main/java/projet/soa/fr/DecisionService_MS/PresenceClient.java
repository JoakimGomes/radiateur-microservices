package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import projet.soa.fr.DecisionService_MS.model.PresenceSensor_Classroom;

@Component
public class PresenceClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8086/presence/";

    public boolean isSomeonePresent(String classroom) {
    	PresenceSensor_Classroom Presence;
    	
        Presence = restTemplate.getForObject(url + classroom, PresenceSensor_Classroom.class);
        return Presence.isPresenceDetected();
    }
}
