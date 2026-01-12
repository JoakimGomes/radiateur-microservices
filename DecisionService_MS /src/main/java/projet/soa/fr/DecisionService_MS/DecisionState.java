package projet.soa.fr.DecisionService_MS;

public class DecisionState {

    private boolean presence;
    private double temperature;
    private int minutesBeforeCourse;

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getMinutesBeforeCourse() {
        return minutesBeforeCourse;
    }

    public void setMinutesBeforeCourse(int minutesBeforeCourse) {
        this.minutesBeforeCourse = minutesBeforeCourse;
    }
}
