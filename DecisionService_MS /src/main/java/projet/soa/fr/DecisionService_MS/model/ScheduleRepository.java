package projet.soa.fr.DecisionService_MS.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Course, Long> {

    List<Course> findByRoom(String room);
    
    List<Course> findByRoomAndStartTimeBetween(
            String room,
            LocalDateTime start,
            LocalDateTime end
    );
    
    Optional<Course> findFirstByRoomAndStartTimeAfterOrderByStartTimeAsc(
            String room,
            LocalDateTime now
    );

}
