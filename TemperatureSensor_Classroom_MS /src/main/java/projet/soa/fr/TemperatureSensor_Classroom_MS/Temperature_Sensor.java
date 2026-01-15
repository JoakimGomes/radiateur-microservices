package projet.soa.fr.TemperatureSensor_Classroom_MS;


import java.time.LocalDateTime;


public class Temperature_Sensor {

    private String id;
    private String classroom;
    private double temperature;
    private LocalDateTime timestamp;

    public Temperature_Sensor() {}

    public Temperature_Sensor(String id, String classroom, double temperature, LocalDateTime timestamp) {
        this.id = id;
        this.classroom = classroom;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    // -------- GETTERS & SETTERS --------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return classroom;
    }

    public void setLocation(String location) {
        this.classroom = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}