package projet.soa.fr.Schedule_MS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

        Course currentCourse = repo.findFirstByRoomAndStartTimeLessThanEqualAndEndTimeGreaterThan(room, now, now);

        if (currentCourse != null) {
            return new NextCourseResponse(currentCourse, now);
        }

        return repo.findFirstByRoomAndStartTimeAfterOrderByStartTimeAsc(room, now)
                .map(course -> new NextCourseResponse(course, now))
                .orElse(null);
    }
    
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id,@RequestBody Course updatedCourse) {
        Course course = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
        course.setRoom(updatedCourse.getRoom());
        course.setStartTime(updatedCourse.getStartTime());
        course.setEndTime(updatedCourse.getEndTime());
        return repo.save(course);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found");
        }
        repo.deleteById(id);
    }

    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        if (course.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID must not be provided");
        }
        return repo.save(course);
    }
}
