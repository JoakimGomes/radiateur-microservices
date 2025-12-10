package projet.soa.fr.Schedule_MS;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class Schedule_Ressource {

    private List<Schedule> schedules = new ArrayList<>();

    @PostMapping("/add")
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        schedules.add(schedule);
        return schedule;
    }

    // Récupérer tous les emplois du temps
    @GetMapping("/all")
    public List<Schedule> getAllSchedules() {
        return schedules;
    }

    // Récupérer un emploi du temps spécifique à une classe
    @GetMapping("/{className}")
    public List<Schedule> getScheduleForClass(@PathVariable String className) {
        return schedules.stream()
                .filter(s -> s.getClassName().equalsIgnoreCase(className))
                .toList();
    }

    // Supprimer un emploi du temps pour mise à jour
    @DeleteMapping("/delete")
    public String deleteSchedule(@RequestBody Schedule schedule) {
        boolean removed = schedules.removeIf(s ->
                s.getClassName().equalsIgnoreCase(schedule.getClassName()) &&
                s.getDayOfWeek().equalsIgnoreCase(schedule.getDayOfWeek()) &&
                s.getStartTime().equals(schedule.getStartTime())
        );

        return removed ? "Emploi supprimé." : "Aucun emploi correspondant trouvé.";
    }
}
