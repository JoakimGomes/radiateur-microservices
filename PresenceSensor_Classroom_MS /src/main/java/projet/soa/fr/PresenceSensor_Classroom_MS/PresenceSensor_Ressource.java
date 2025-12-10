package projet.soa.fr.PresenceSensor_Classroom_MS;

import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/presence")
public class PresenceSensor_Ressource {


	private final List<PresenceSensor_Classroom> detections = new ArrayList<>();
	private Long idCounter = 1L;
	
	
	@PostMapping
	public PresenceSensor_Classroom createDetection(@RequestBody PresenceSensor_Classroom sensor) {
		sensor.setId(idCounter++);
		sensor.setTimestamp(LocalDateTime.now());
		detections.add(sensor);
		return sensor;
	}
	
	
	@GetMapping
	public List<PresenceSensor_Classroom> getAllDetections() {
		return detections;
	}
	
	
	@GetMapping("/{id}")
	public PresenceSensor_Classroom getDetection(@PathVariable Long id) {
		return detections.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);	
	}
	
	@GetMapping("/detected/true")
	public List<PresenceSensor_Classroom> getDetected() {
		return detections.stream().filter(PresenceSensor_Classroom::isPresenceDetected).toList();
	}
	
}
