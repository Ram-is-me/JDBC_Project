package ram.ramproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;

public class Doctor {
	
	private int doctorId;
	

	private String doctorName;
	

	private String specialization;
	
	//One to Many Relationship
	private ArrayList<Patient> patients; 
	
	public Doctor(int id, String name, String special)
	{
		this.doctorId = id;
		this.doctorName = name;
		this.specialization = special;
	}
	
	public void printAll()
	{
		System.out.println(doctorId+doctorName);
	}
	
	public void consultPatient()
	{
		this.patients.get(0).setPrescription(this.doctorName+this.patients.get(0).getPatientId());
		this.patients.remove(0);
		
		//TODO SQL Aspect for Functionality
	}
	
	public void assignPatient(Patient p)
	{
		this.patients.add(p);
		
		//TODO SQL Aspect
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
}
