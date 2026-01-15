package projet.soa.fr.DecisionService_MS;


import org.springframework.stereotype.Service;

@Service
public class DecisionService {

    private final PresenceClient presenceClient;
    private final TemperatureClient temperatureClient;
    private final ScheduleClient scheduleClient;

    public DecisionService(PresenceClient p, TemperatureClient t, ScheduleClient s) {
        this.presenceClient = p;
        this.temperatureClient = t;
        this.scheduleClient = s;
    }

    public DecisionResponse evaluate(String classroom) {

        boolean presence = presenceClient.isSomeonePresent(classroom);
        double currentTemp = temperatureClient.getCurrentTemperature(classroom);
        long minutesBeforeCourse = scheduleClient.minutesBeforeNextCourse(classroom);

        // Aucun cours dans les 2h
        if (minutesBeforeCourse == -1 || minutesBeforeCourse > 120) {
            return new DecisionResponse(false, "OFF", currentTemp);
        }

        // Pré-chauffage
        if (!presence && minutesBeforeCourse <= 30) {
            return new DecisionResponse(true, "PREHEAT", 20.5);
        }

        // Présence sans cours
        if (presence && minutesBeforeCourse > 0) {
            return new DecisionResponse(false, "OFF", currentTemp);
        }

        // Cours + présence
        if (presence && minutesBeforeCourse == 0) {
            return new DecisionResponse(true, "NORMAL", 21.0);
        }

        return new DecisionResponse(false, "OFF", currentTemp);
    }
}