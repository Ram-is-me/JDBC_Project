package ram.ramproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;

public class Receptionist {

	private int receptionistId;
	
	private String receptionistName;

	public void printAll()
	{
		System.out.println(receptionistId+receptionistName);
	}
	
	public Receptionist(int id, String name)
	{
		this.receptionistId = id;
		this.receptionistName = name;
	}
	
//	public void assignDoctorToPatient(Patient p, ArrayList<Doctor> d)
//	{
//		//TODO SQL functionality - check inside the other functions (only update SQL in simple assignments)
//		ArrayList<Integer> opt = new ArrayList<Integer>();
//		for(int i=0;i<d.size();i++)
//		{
//			opt.add(d.get(i).getPatients().size());
//		}
//		int minIndex = opt.indexOf(Collections.min(opt));
//		
//		p.assignDoctor(App.getDoctorById(minIndex));
//		d.get(minIndex).assignPatient(App.getPatientById(minIndex));
//	}
//	
	public void allotRoom(Patient p, ArrayList<Room> r)
	{
		//TODO check SQL implementation
		for(int i=0;i<r.size();i++)
		{
			if(r.get(i).getPatient() == null)
			{
				r.get(i).assignPatient(p);
				break;
			}
		}
	}
	
	public int getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(int receptionistId) {
		this.receptionistId = receptionistId;
	}

	public String getReceptionistName() {
		return receptionistName;
	}

	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}

	
}
