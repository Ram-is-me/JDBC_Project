package ram.ramproject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Patient {
	
	private int patientId;
	
	private String patientName;
	
	private String history;
	
	private String contact;
	
	private Doctor d;
	
	private Room r;
	
	private int bedAllocation;
	
	@Column(name="prescription")
	private String prescription;
	
	public Patient(int id, String name, String history, String contact, int bedalloc)
	{
		this.patientId = id;
		this.patientName = name;
		this.history = history;
		this.contact = contact;
		this.bedAllocation = bedalloc;
	}
	
	public Patient(int id, String name, String history, String contact, Doctor d, Room r, int bedalloc)
	{
		this.patientId = id;
		this.patientName = name;
		this.history = history;
		this.contact = contact;
		this.d = d;
		this.r = r;
		this.bedAllocation = bedalloc;
	}
	
	public void printAll()
	{
		System.out.println(patientId+patientName);
	}
	
	public void assignDoctor(Doctor d)
	{
		this.d = d; 
		
		//TODO SQL Aspect
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Doctor getD() {
		return d;
	}

	public void setD(Doctor d) {
		this.d = d;
	}

	public Room getR() {
		return r;
	}

	public void setR(Room r) {
		this.r = r;
	}

	public int getBedAllocation() {
		return bedAllocation;
	}

	public void setBedAllocation(int bedAllocation) {
		this.bedAllocation = bedAllocation;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
	
}
