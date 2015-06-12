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
		String wClause = " name = '" + name + "'";
		return search(wClause);
	}

	public ArrayList<Employee> findByPhoneNumber(String phoneNumber)  throws SQLException{
		String wClause = " phoneNumber = '" + phoneNumber + "'";
		return search(wClause);
	}

	public ArrayList<Employee> findByEmail(String email)  throws SQLException{
		String wClause = " email = '" + email + "'";
		return search(wClause);
	}

	public ArrayList<Employee> findByAddress(String address)  throws SQLException{
		String wClause = " address = '" + address + "'";
		return search(wClause);
	}
	
	public ArrayList<Employee> findByRights(int rights)  throws SQLException{
		String wClause = " rights = " + rights;
		return search(wClause);
	}

	public void insert(Employee employee) throws SQLException{
		int id = 0;
		String query = " INSERT INTO Person(name,phoneNumber,email,address,subtype)"
				+ " VALUES('" 
				+ employee.getName() + "','"
				+ employee.getPhoneNr() + "','"
				+ employee.getEmail() + "','"
				+ employee.getAddress() + "','"
				+ "Employee')";
		String getID = " SELECT personID FROM Person WHERE"
				+ " name = '" + employee.getName() + "'"
				+ " AND phoneNumber = '" + employee.getPhoneNr() + "'"
				+ " AND subtype = 'Employee'";
		
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		ResultSet idRow = stmt.executeQuery(getID);
		while(idRow.next()) id = idRow.getInt(1);
		query = " INSERT INTO Employee(personID,rights)"
				+ " VALUES('" + id
				+ "','"	+ employee.getRights() + "')";
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");
	}

	public void update(Employee employee) throws SQLException{
		String query = " UPDATE Person SET"
				+ " name = '" + employee.getName() + "',"
				+ " phoneNumber = '" + employee.getPhoneNr() + "',"
				+ " email = '" + employee.getEmail() + "',"
				+ " address = '" + employee.getAddress() + "',"
				+ " subtype = 'Employee'"
				+ " WHERE personID = " + employee.getID()
				+ " UPDATE Employee SET"
				+ " rights = " + employee.getRights()
				+ " WHERE personID = " + employee.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");
	}

	public void delete(Employee employee) throws SQLException{
		String query = " DELETE FROM Employee WHERE personID = " + employee.getID()
				+ " DELETE FROM Person WHERE personID = " + employee.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");
	}

	private ArrayList<Employee> search(String wClause) throws SQLException{
		ResultSet results;
		ArrayList<Employee> emps = new ArrayList<Employee>();
		
		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		results = stmt.executeQuery(query);
		while(results.next()){
			Employee emp;
			emp = buildEmployee(results);
			emps.add(emp);
		}
		stmt.close();
		System.out.println("success!");
		
		return emps;
	}

	private Employee buildEmployee(ResultSet results) throws SQLException{
		Employee emp = new Employee();
		
		emp.setID(results.getInt("personID"));
		emp.setName(results.getString("name"));
		emp.setPhoneNr(results.getString("phoneNumber"));
		emp.setAdress(results.getString("address"));
		emp.setEmail(results.getString("email"));
		emp.setRights(results.getInt("rights"));
		
		return emp;
	}

	private String buildQuery(String wClause) {
		String query = " SELECT Person.personID,name,phoneNumber,address,email,rights FROM Person,Employee";
		if(wClause.length() > 0){
			query = query + " WHERE" + wClause;
		}
		return query;
	}

}
