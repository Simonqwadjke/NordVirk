package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public class DBEmployee{
	
	private Connection con;
	
	public DBEmployee(){
		con = DBConnection.getInstance().getDBcon();
	}

	public ArrayList<Employee> findByName(String name)  throws SQLException{
		String wClause = "name = " + name;
		return search(wClause);
	}

	public ArrayList<Employee> findByPhoneNumber(String phoneNumber)  throws SQLException{
		String wClause = "phoneNumber = " + phoneNumber;
		return search(wClause);
	}

	public ArrayList<Employee> findByEmail(String email)  throws SQLException{
		String wClause = "email = " + email;
		return search(wClause);
	}

	public ArrayList<Employee> findByAddress(String address)  throws SQLException{
		String wClause = "address = " + address;
		return search(wClause);
	}
	
	public ArrayList<Employee> findByRights(int rights)  throws SQLException{
		String wClause = "rights = " + rights;
		return search(wClause);
	}

	public void insert(Employee employee) throws SQLException {
		String query = "INSERT INTo Person(name,phoneNumber,email,address,subtype)"
				+ " VALUES('" 
				+ employee.getName() + "','"
				+ employee.getPhoneNr() + "','"
				+ employee.getEmail() + "','"
				+ employee.getAddress() + "','"
				+ "Employee')";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeQuery(query);
		stmt.close();
	}

	public void update(Employee employee) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(Employee employee) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Employee> search(String wClause) {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier buildEmployee() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String buildQuery(String wClause) {
		// TODO Auto-generated method stub
		return null;
	}

}
