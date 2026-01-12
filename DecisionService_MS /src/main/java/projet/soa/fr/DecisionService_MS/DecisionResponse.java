package projet.soa.fr.DecisionService_MS;

public class DecisionResponse {

    private boolean heatingOn;
    private String mode; // OFF, ECO, PREHEAT, NORMAL
    private double targetTemperature;

    public DecisionResponse(boolean heatingOn, String mode, double targetTemperature) {
        this.heatingOn = heatingOn;
        this.mode = mode;
        this.targetTemperature = targetTemperature;
    }

    public boolean isHeatingOn() {
        return heatingOn;
    }

    public String getMode() {
        return mode;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }
}

