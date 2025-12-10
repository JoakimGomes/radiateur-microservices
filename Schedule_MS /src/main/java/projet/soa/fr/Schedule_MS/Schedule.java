package projet.soa.fr.Schedule_MS;

public class Schedule {

    private String className;        
    private String startTime;        // Format HH:mm
    private String endTime;          
    private String dayOfWeek;        

    public Schedule() {
    }

    public Schedule(String className, String startTime, String endTime, String dayOfWeek, String subject) {
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
