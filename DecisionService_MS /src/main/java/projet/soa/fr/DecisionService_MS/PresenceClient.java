package projet.soa.fr.DecisionService_MS;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PresenceClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8086/presence/";

    public boolean isSomeonePresent(Long classId) {
        return restTemplate.getForObject(url + "?classId=" + classId, Boolean.class);
    }
}
