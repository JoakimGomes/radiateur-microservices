package projet.soa.fr.Schedule_MS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository repo;

    @GetMapping("/{room}")
    public List<Course> getRoomSchedule(
            @PathVariable String room,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        return repo.findByRoomAndStartTimeBetween(
                room,
                startOfDay,
                endOfDay
        );
    }
    
    @GetMapping("/{room}/next")
    public NextCourseResponse getNextCourse(@PathVariable String room) {

        LocalDateTime now = LocalDateTime.now();

        return repo
            .findFirstByRoomAndStartTimeAfterOrderByStartTimeAsc(room, now)
            .map(course -> new NextCourseResponse(course, now))
            .orElse(null);
    }
}