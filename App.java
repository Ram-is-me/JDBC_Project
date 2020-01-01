package ram.ramproject;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
//import org.hibernate.cfg.Configuration;

import java.util.*;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class App 
{
	static int PASS=0;
	static int FAIL=1;
	static int EXIT=-1;
	
	//Object Data
//	static ArrayList<Room> hospital = new ArrayList<Room>(10);
//	static ArrayList<Manager> managers = new ArrayList<Manager>(2);
//	static Receptionist receptionist = new Receptionist(0,null);
//	static ArrayList<Doctor> doctors = new ArrayList<Doctor>(4);
//	static ArrayList<Patient> patients = new ArrayList<Patient>(10);
	
	//DB Helper
	static Dbhelper db = new Dbhelper();
	
	// Current Data
	static int type; //1 - Doctor, 2 - Manager, 3 - Receptionist
	
	// Input Checker
	private static int returnNumeric(String input)
	{
		int i;
		try {
			i = Integer.parseInt(input);
			return i;
		} catch(Exception e)
		{
			return 0;
		}
	}
	
	
	// Object Initialization
	public static void createHospital()
	{
//		Room r;
//		for(int i=0;i<10;i++)
//		{
//			r = new Room(i+1,null,null);
////			System.out.println(i+" "+r.getRoomId());
//			hospital.add(r);
////			System.out.println(hospital.get(i).getRoomId());
//		}
		String statement;
		for(int i=0;i<10;i++)
		{
			statement = "insert into Room values("+i+1+","+"NULL,"+"NULL);";
			db.startstatement();
			db.update(statement);
			db.endupdate();
		}
		
//		Manager m = new Manager(1,"Manager1");
//		managers.add(m);
//		managers.get(0).printAll();
		statement = "insert into Manager values(1,'Manager1')";
		db.startstatement();
		db.update(statement);
		db.endupdate();
//		m = new Manager(2,"Manager2");
//		managers.add(m);
//		managers.get(1).printAll();
		statement = "insert into Manager values(2,'Manager2')";
		db.startstatement();
		db.update(statement);
		db.endupdate();
//		receptionist = new Receptionist(1,"Receptionist1");
//		receptionist.printAll();
		statement = "insert into Receptionist values(1,'Receptionist1')";
		db.startstatement();
		db.update(statement);
		db.endupdate();
		
//		Doctor d;
//		for(int i=0;i<4;i++)
//		{
//			d = new Doctor(i+1,"Doctor"+(i+1),"Specialization"+(i+1));
//			doctors.add(d);
//			d.printAll();
//		}
		for(int i=0;i<4;i++)
		{
			statement = "insert into Doctor values("+(i+1)+","+"'Doctor"+(i+1)+"',"+"'Specialization"+(i+1)+"',NULL);";
			db.startstatement();
			db.update(statement);
			db.endupdate();
		}
	}
	
	//Login Screen
	public static void loginSelection()
	{
		System.out.println("Please Enter your Login Details: ");
		System.out.println("1 - Doctor");
		System.out.println("2 - Manager");
		System.out.println("3 - Receptionist");
		System.out.println("0 - Exit");
	}
	
	// Login Authentication
	public static int checkDoctor(Scanner in, int id, String name)
	{
//		System.out.println(name+" "+doctors.get(0).getDoctorName());
//		for(int i=0;i<doctors.size();i++)
//		{
//			if(id == doctors.get(i).getDoctorId()&& name.equals(doctors.get(i).getDoctorName()))
//			{
//				return PASS;
//			}
//		}
//		return FAIL;
		String statement = "select doctorId from Doctor where doctorId="+id+" and doctorName='"+name+"';";
		int doctorid=-1;
		db.startstatement();
		ResultSet rs = db.execstatement(statement);
		try {
			while(rs.next())
			{
				doctorid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.endstatement();
		if(doctorid!=-1) 
			return PASS;
		else
			return FAIL;
	}
	
	public static int checkManager(Scanner in, int id, String name)
	{	
//		for(int i=0;i<managers.size();i++)
//		{
//			if(id == managers.get(i).getManagerId() && name.equals(managers.get(i).getManagerName()))
//			{
//				return PASS;
//			}
//		}
//		return FAIL;
		
		String statement = "select managerId from Manager where managerId="+id+" and managerName='"+name+"';";
		int doctorid=-1;
		db.startstatement();
		ResultSet rs = db.execstatement(statement);
		try {
			while(rs.next())
			{
				doctorid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.endstatement();
		if(doctorid!=-1) 
			return PASS;
		else
			return FAIL;
	}
	
	public static int checkReceptionist(Scanner in, int id, String name)
	{	
//		System.out.println(id + " " + receptionist.getReceptionistId() + " "+ name+" "+receptionist.getReceptionistName());
//		if(id == receptionist.getReceptionistId() && name.equals(receptionist.getReceptionistName()))
//		{
//			return PASS;
//		}
//		return FAIL;
		String statement = "select receptionistId from Receptionist where receptionistId="+String.valueOf(id)+" and receptionistName= '"+name+"' ;";
		int doctorid=-1;
		db.startstatement();
		ResultSet rs = db.execstatement(statement);
		try {
			while(rs.next())
			{
				doctorid = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.endstatement();
		if(doctorid!=-1) 
			return PASS;
		else
			return FAIL;
	}
	
	public static void createPatient(Scanner in)
	{
//		//TODO Input Verification and Data verification
//		Patient p = null;
//		System.out.println("Enter Patient ID:");
//		String temp = in.nextLine();
//		int id = returnNumeric(temp);
//		String name = in.nextLine();
//		String history = in.nextLine();
//		String contact = in.nextLine();
//		temp = in.nextLine();
//		int bedalloc = returnNumeric(temp);
//		if(bedalloc>0) bedalloc = 1;
//		else bedalloc = 0;
//		
		int id =1;
		String name = "patient1";
		String history = "history1";
		String contact = "contact1";
		int bedalloc = 1;
		String statement = "insert into Patient values("+id+",'"+name+"','"+history+"','"+contact+"',"+bedalloc+",NULL,NULL,NULL);";
		db.startstatement();
		db.update(statement);
		db.endupdate();
		
		id =2;
		name = "patient1";
		history = "history1";
		contact = "contact1";
		bedalloc = 1;
		statement = "insert into Patient values("+id+",'"+name+"','"+history+"','"+contact+"',"+bedalloc+",NULL,NULL,NULL);";
		db.startstatement();
		db.update(statement);
		db.endupdate();
	}
	
	// UI
	public static int doctorUI(int id, String name, Scanner in)
	{
		String statement;
		System.out.println("Welcome Doctor!");
		System.out.println("1 - Consult Patient");
		System.out.println("0 - Logout");
		
		String input = in.nextLine();
		int choice = returnNumeric(input);
		if(choice==1)
		{
//			Doctor d = getDoctorById(id);
//			d.consultPatient();
//			return 0;
			statement = "select pId from Doctor where doctorId="+id+";";
			db.startstatement();
			ResultSet rs = db.execstatement(statement);
			int pid = -1;
			try {
				while(rs.next())
				{
					pid = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.endstatement();
			
//			System.out.println(pid+" "+id);
			if(pid == 0)
			{
				System.out.println("No Patients Assigned");
				return 0;
			}
			
			statement = "update Patient set prescription='Doctor"+id+"presc'"+" where patientId="+pid+";";
			db.startstatement();
			db.update(statement);
			db.endupdate();
			
			statement = "update Patient set rId = NULL where patientId ="+pid+";";
			db.startstatement();
			db.update(statement);
			db.endupdate();
			
			statement = "update Room set dId = NULL where pId="+pid+";";
			db.startstatement();
			db.update(statement);
			db.endupdate();
			
			statement = "update Room set pId = NULL where pId="+pid+";";
			db.startstatement();
			db.update(statement);
			db.endupdate();
			
			statement = "update Doctor set pId = NULL where doctorId="+id+" ;";
			db.startstatement();
			db.update(statement);
			db.endupdate();
			
			System.out.println("Patient "+pid+" has been consulted");
			
			return 0;
		}
		else 
		{
			return 1;
		}
	}
	
	public static int managerUI(int id, String name, Scanner in)
	{
		System.out.println("Welcome Manager!");
		System.out.println("1 - View Rooms Vacant");
		System.out.println("0 - Logout");
		
		String statement;
		
		String input = in.nextLine();
		int choice = returnNumeric(input);
		if(choice==1)
		{
//			Manager m = getManagerById(id);
//			m.viewBedStatus();
//			return 0;
			statement = "select roomId from Room where pId is NULL;";
			ArrayList<Integer> valid = new ArrayList<Integer>();
			db.startstatement();
			ResultSet rs = db.execstatement(statement);
			try {
				while(rs.next())
				{
					int value = rs.getInt(1);
					valid.add(value);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.endstatement();
			System.out.println("List of Vacant Rooms are: ");
			for(int i=0;i<valid.size();i++)
			{
				System.out.println(valid.get(i));
			}
			return 0;
		}
		else 
		{
			return 1;
		}
	}
	
	public static int receptionistUI(int id, String name, Scanner in)
	{
		System.out.println("Welcome Receptionist!");
		System.out.println("1 - Assign Patient to Doctor and allot room");
		System.out.println("2 - Register Patient");
		System.out.println("0 - Logout");
		
		String input = in.nextLine();
		int choice = returnNumeric(input);
		if(choice==1)
		{
//			Patient p = createPatient(in);
//			Receptionist r = receptionist;
//			r.assignDoctorToPatient(p, doctors);
			
			int patientid=-1;
			int doctorid=-1;
			int roomid=-1;
			String statement;
			statement = "select patientId from Patient where dId is NULL;";
			db.startstatement();
			ResultSet rs = db.execstatement(statement);
			try {
				while(rs.next())
				{
					patientid = rs.getInt(1);
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.endstatement();
			if(patientid!=-1)
			{
				statement = "select doctorId from Doctor d where d.pId is NULL;";
				db.startstatement();
				ResultSet rs2 = db.execstatement(statement);
				try {
					while(rs2.next())
					{
						doctorid = rs2.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				db.endstatement();
				
				if(doctorid!=-1)
				{
					statement = "select roomId from Room where pId is NULL;";
					db.startstatement();
					ResultSet rs3 = db.execstatement(statement);
					try {
						while(rs3.next())
						{
							roomid = rs3.getInt(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					db.endstatement();
					
					if(roomid!=-1)
					{
						statement = "update Room set dId = "+doctorid+" where roomId="+roomid+" ;";
						db.startstatement();
						db.update(statement);
						db.endupdate();
						
						statement = "update Room set pId = "+patientid+" where roomId="+roomid+" ;";
						db.startstatement();
						db.update(statement);
						db.endupdate();
						
						statement = "update Patient set dId = "+doctorid+" where patientId="+patientid+" ;";
						db.startstatement();
						db.update(statement);
						db.endupdate();
						
						statement = "update Doctor set pId = "+patientid+" where doctorId="+doctorid+" ;";
						db.startstatement();
						db.update(statement);
						db.endupdate();
						
						System.out.println("Patient "+patientid+" has been assigned to Doctor"+doctorid+" at Room "+roomid);
					}
				}
			}
			if(patientid==-1)
			{
				System.out.println("No more patients to process");
			}
			else if(doctorid==-1)
			{
				System.out.println("Doctor Unavailable");
			}
			
			else if(roomid==-1)
			{
				System.out.println("No more available Rooms");
			}
			return 0;
		}
		else if(choice==2)
		{
			System.out.println("Enter Patient ID:");
			String temp = in.nextLine();
			int id2 = returnNumeric(temp);
			System.out.println("Enter Patient Name:");
			String name2 = in.nextLine();
			System.out.println("Enter Patient History:");
			String history2 = in.nextLine();
			System.out.println("Enter Patient Contact:");
			String contact2 = in.nextLine();
			System.out.println("Enter Patient Bed Allocation:");
			temp = in.nextLine();
			int bedalloc2 = returnNumeric(temp);
			if(bedalloc2>0) bedalloc2 = 1;
			else bedalloc2 = 0;
			
			String statement;
			statement = "insert into Patient values("+id2+",'"+name2+"','"+history2+"','"+contact2+"',"+bedalloc2+",NULL,NULL,NULL);";
			db.startstatement();
			db.update(statement);
			db.endupdate();
			
			System.out.println("Patient has been added to the Database as unassigned");
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	//executeUI
	public static int executeUI(int result,int id, String name, Scanner in)
	{
		int logout = 0;
		switch(result)
		{
		case 1: 
			logout = doctorUI(id,name,in);
			break;
		case 2: 
			logout = managerUI(id,name,in);
			break;
		case 3:
			logout = receptionistUI(id,name,in);
			break;
		case 0:
			logout = 1;
			break;
		}
		return logout;
	}
	
	//Main Function
	public static void main( String[] args )
    {
		System.out.println("Welcome to the Hospital Management System");
		db.startconnect();
		createHospital();
		System.out.println("Creating 2 Patients...");
		Scanner in2 = new Scanner(System.in);
		createPatient(in2);
//		createPatient(in2);
		boolean choice = true;
		Scanner in = new Scanner(System.in);
		while(choice)
		{
			loginSelection();
//			int result = loginauthentication(doctors, managers, receptionist);
			String input = in.nextLine();
			int inp = returnNumeric(input);
			int result;
			int id = 0;
			String name = "";
			String temp;
			switch(inp)
			{
			case 1: 
				System.out.println("Enter Doctor Id:");
				temp = in.nextLine();
				id = returnNumeric(temp);
//				System.out.println("Id taken is " + id);
				System.out.println("Enter Doctor Name:");
				name = in.nextLine();
//				System.out.println("Name takes is " + name);
				result = checkDoctor(in,id,name); 
//				System.out.println("Result takes is " + result);
				if(result==PASS) 
					type = 1; 
				break;
			case 2: 
				System.out.println("Enter Manager Id:");
				temp = in.nextLine();
				id = returnNumeric(temp);
				System.out.println("Enter Manager Name:");
				name = in.nextLine();
				result = checkManager(in,id,name); 
				if(result==PASS) 
					type = 2; 
				break;
			case 3: 
				System.out.println("Enter Receptionist Id:");
				temp = in.nextLine();
				id = returnNumeric(temp);
				System.out.println("Enter Receptionist Name:");
				name = in.nextLine();
				result = checkReceptionist(in, id, name); 
//				System.out.println("Result of Receptionist is : "+result);
				if(result==PASS) 
					type = 3; 
				break;
			case 0: result = EXIT; break;
			default: result = FAIL;
			}
			
			if(result==FAIL)
			{
				System.out.println("Login Failed, please try again");
				continue;
			}
			else if(result==EXIT)
			{
				choice = false;
				continue;
			}
			int logout = 0;
			while(logout == 0)
			{
				logout = executeUI(type,id,name,in);
				if(logout==1)
				{
					System.out.println("Thank you, User!");
				}
			}
		}
		in.close();
		db.endconnect();
    }
}
