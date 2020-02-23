package ram.ramproject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class Room {
	
	private int roomId;
	
	private Patient patient;
	
	private Doctor doctor;
	
	public Room(int id, Patient pid, Doctor did)
	{
		this.roomId = id;
		this.patient = pid;
		this.doctor = did;
	}
	
	public void printAll()
	{
		System.out.println(roomId+patient.getPatientName()+doctor.getDoctorName());
	}
	
	public void assignPatient(Patient p)
	{
		//TODO SQL statement
		this.patient = p;
	}
	
	public void assignDoctor(Doctor d)
	{
		//TODO SQL statement
		this.doctor = d;
	}
	
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
