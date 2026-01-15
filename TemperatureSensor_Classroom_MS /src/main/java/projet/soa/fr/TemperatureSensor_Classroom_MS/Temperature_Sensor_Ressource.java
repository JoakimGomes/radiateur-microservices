package projet.soa.fr.TemperatureSensor_Classroom_MS;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/temperature_sensors")
public class Temperature_Sensor_Ressource {

    private final Map<String, Temperature_Sensor> sensors = new HashMap<>();
	private Long idCounter = 1L;

    // ------------------- GET ALL -------------------
    @GetMapping
    public List<Temperature_Sensor> getAllSensors() {
        return new ArrayList<>(sensors.values());
    }

    // ------------------- GET BY ID -------------------
    @GetMapping("/{id}")
    public Temperature_Sensor getSensor(@PathVariable String id) {
        return sensors.get(id);
    }

    @GetMapping("/search")
    public Double getTemperatureByRoom(@RequestParam String room) {
        return sensors.values().stream()
                .filter(s -> s.getLocation().equalsIgnoreCase(room))
                .map(Temperature_Sensor::getTemperature)
                .findFirst()
                .orElse(null);
    }
    
    // ------------------- CREATE -------------------
    @PostMapping(consumes = "application/json" , produces = "application/json")
    public Temperature_Sensor createSensor(@RequestBody Temperature_Sensor sensor) {
    	if (sensor.getId() == null || sensor.getId().isEmpty()) {
    	    sensor.setId(idCounter.toString());
    	    idCounter++;
    	}
    	sensor.setTimestamp(LocalDateTime.now());
        sensors.put(sensor.getId(), sensor);
        return sensor;
    }

    // ------------------- UPDATE -------------------
    @PutMapping(value = "/{id}", consumes = "application/json" , produces = "application/json")
    public Temperature_Sensor updateSensor(@PathVariable String id, @RequestBody Temperature_Sensor updated) {
        Temperature_Sensor existing = sensors.get(id);

        if (existing == null) {
            return null;
        }

        existing.setLocation(updated.getLocation());
        existing.setTemperature(updated.getTemperature());
        existing.setTimestamp(LocalDateTime.now());

        return existing;
    }

    // ------------------- DELETE -------------------
    @DeleteMapping("/{id}")
    public boolean deleteSensor(@PathVariable String id) {
        return sensors.remove(id) != null;
    }
}
