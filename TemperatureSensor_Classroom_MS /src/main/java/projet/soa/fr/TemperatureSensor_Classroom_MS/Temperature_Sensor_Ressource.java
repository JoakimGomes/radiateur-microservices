package projet.soa.fr.TemperatureSensor_Classroom_MS;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/temperature_sensors")
public class Temperature_Sensor_Ressource {

    private final Map<String, Temperature_Sensor> sensors = new HashMap<>();

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

    // ------------------- CREATE -------------------
    @PostMapping(consumes = "application/json" , produces = "application/json")
    public Temperature_Sensor createSensor(@RequestBody Temperature_Sensor sensor) {
    	if (sensor.getId() == null || sensor.getId().isEmpty()) {
    	    sensor.setId(UUID.randomUUID().toString());
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
