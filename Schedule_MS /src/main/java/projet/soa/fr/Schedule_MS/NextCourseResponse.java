package projet.soa.fr.Schedule_MS;

import java.time.Duration;
import java.time.LocalDateTime;

public class NextCourseResponse {

    private Course course;
    private long deltaMinutes;

    public NextCourseResponse(Course course, LocalDateTime now) {
        this.course = course;
        this.deltaMinutes = Duration.between(now, course.getStartTime()).toMinutes();
    }

    public Course getCourse() {
        return course;
    }

    public long getDeltaMinutes() {
        return deltaMinutes;
    }
}
