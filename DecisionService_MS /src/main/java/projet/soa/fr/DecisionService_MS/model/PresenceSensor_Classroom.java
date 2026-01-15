package projet.soa.fr.DecisionService_MS.model;

import java.time.LocalDateTime;


public class PresenceSensor_Classroom {


	private Long id;
	private String classroom;
	private boolean presenceDetected;
	private LocalDateTime timestamp;
	
	
	public PresenceSensor_Classroom() {}
	
	
	public PresenceSensor_Classroom(String classroom, boolean presenceDetected) {
		this.classroom = classroom;
		this.presenceDetected = presenceDetected;
		this.timestamp = LocalDateTime.now();
	}
	
	
	public Long getId() { 
		return id; 
	}
	
	public void setId(Long id) {
		this.id = id; 
	}
	
	
	public String getClassroom() { 
		return classroom; 
	}
	
	public void setClassroom(String classroom) { 
		this.classroom = classroom; 
	}
	
	
	public boolean isPresenceDetected() { 
		return presenceDetected; 
	}
	
	public void setPresenceDetected(boolean presenceDetected) { 
		this.presenceDetected = presenceDetected; 
	}
	
	
	public LocalDateTime getTimestamp() { 
		return timestamp; 
	}
	
	public void setTimestamp(LocalDateTime timestamp) { 
		this.timestamp = timestamp; 
	}
	
}