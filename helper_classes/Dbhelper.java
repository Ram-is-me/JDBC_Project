package ram.ramproject;

import java.sql.*;

//import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

public class Dbhelper {
	//SQL Initializations
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/hospital";
		
	static final String USER = "root";
	static final String PASS = "root";
	
	// SQL Environment Setup
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public void startconnect()
	{
		try {
			Class.forName(JDBC_DRIVER);

		    //STEP 3: Open a connection
		    System.out.println("Connecting to database...");
		    this.conn = DriverManager.getConnection(DB_URL,USER,PASS);
			}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
			}catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
			}
	}
	
	public void endconnect()
	{
		try{
			System.out.println("Closing Connection...");
			if(this.conn!=null)
	           this.conn.close();
	    }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	}
	
	public void startstatement()
	{
		try {
//			System.out.println(this.conn);
			this.stmt = this.conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void endstatement()
	{
		try {
			this.rs.close();
			this.stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet execstatement(String statement)
	{
		try {
			this.rs = this.stmt.executeQuery(statement);
		} catch (SQLException e) {
			e.printStackTrace();
			this.rs = null;
		}
		return this.rs;
	}
	
	public void update(String statement)
	{
		try {
			this.stmt.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void endupdate()
	{
		try {
			this.stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
