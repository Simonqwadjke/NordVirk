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
		String wClause = " name = " + name;
		return search(wClause);
	}

	public ArrayList<Employee> findByPhoneNumber(String phoneNumber)  throws SQLException{
		String wClause = " phoneNumber = " + phoneNumber;
		return search(wClause);
	}

	public ArrayList<Employee> findByEmail(String email)  throws SQLException{
		String wClause = " email = " + email;
		return search(wClause);
	}

	public ArrayList<Employee> findByAddress(String address)  throws SQLException{
		String wClause = " address = " + address;
		return search(wClause);
	}
	
	public ArrayList<Employee> findByRights(int rights)  throws SQLException{
		String wClause = " rights = " + rights;
		return search(wClause);
	}

	public void insert(Employee employee) throws SQLException{
		String query = " INSERT INTo Person(name,phoneNumber,email,address,subtype)"
				+ " VALUES('" 
				+ employee.getName() + "','"
				+ employee.getPhoneNr() + "','"
				+ employee.getEmail() + "','"
				+ employee.getAddress() + "','"
				+ "Employee')";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeQuery(query);
		query = " INSERT INTO Employee(personID,rights)"
				+ " VALUES('"
				+ stmt.executeQuery("SELECT personID FROM Person"
						+ " WHERE "
						+ " name = " + employee.getName()
						+ " AND phoneNumber = " + employee.getPhoneNr()
						+ " AND subtype = Employee").getInt(1) 
				+ "','"	+ employee.getRights() + "')";
		stmt.executeQuery(query);
		stmt.close();
	}

	public void update(Employee employee) throws SQLException{
		String query = " UPDATE Person SET"
				+ " name = " + employee.getName()
				+ " phoneNumber = " + employee.getPhoneNr()
				+ " email = " + employee.getEmail()
				+ " address = " + employee.getAddress()
				+ " subtype = employee"
				+ " WHERE personID = " + employee.getID()
				+ " UPDATE Employee SET"
				+ " rights = " + employee.getRights()
				+ " WHERE personID = " + employee.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeQuery(query);
		stmt.close();
	}

	public void delete(Employee employee) throws SQLException{
		String query = " DELETE FROM Employee WHERE personID = " + employee.getID()
				+ " DELETE FROM Person WHERE personID = " + employee.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeQuery(query);
		stmt.close();
	}

	public ArrayList<Employee> search(String wClause) throws SQLException{
		ResultSet results;
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		results = stmt.executeQuery(query);
		while(results.next()){
			Employee emp;
			emp = buildEmployee(results);
			emps.add(emp);
		}
		stmt.close();
		
		return emps;
	}

	public Employee buildEmployee(ResultSet results) throws SQLException{
		Employee emp = new Employee();
		
		emp.setID(results.getInt("personID"));
		emp.setName(results.getString("name"));
		emp.setPhoneNr(results.getString("phoneNumber"));
		emp.setAdress(results.getString("address"));
		emp.setEmail(results.getString("email"));
		emp.setRights(results.getInt("rights"));
		
		return emp;
	}

	public String buildQuery(String wClause) {
		String query = " SELECT personID,name,phoneNumber,address,email,rights FROM Person,Employee";
		if(wClause.length() > 0){
			query = query + " WHERE" + wClause;
		}
		return query;
	}

}
