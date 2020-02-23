package ram.ramproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Manager {

	private int managerId;

	private String managerName;
	
	public Manager(int id, String name)
	{
		this.managerId = id;
		this.managerName = name;
	}
	
	public void printAll()
	{
		System.out.println(managerId+managerName);
	}
	
	public void viewBedStatus()
	{
		//TODO SQL Aspect for Functionality
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	
}
