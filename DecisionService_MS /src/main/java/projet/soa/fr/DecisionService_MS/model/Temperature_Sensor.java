package projet.soa.fr.DecisionService_MS.model;


import java.time.LocalDateTime;


public class Temperature_Sensor {

    private String id;
    private String location;
    private double temperature;
    private LocalDateTime timestamp;

    public Temperature_Sensor() {}

    public Temperature_Sensor(String id, String location, double temperature, LocalDateTime timestamp) {
        this.id = id;
        this.location = location;
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
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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