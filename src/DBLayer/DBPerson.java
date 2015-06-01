package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public interface DBPerson {
	
	public ArrayList<Person> findPersonByName (String name);
	
	public ArrayList<Person> findPersonByPhoneNumber (String phoneNumber);
	
	public ArrayList<Person> findPersonByEmail (String email);
	
	public ArrayList<Person> findPersonByAddress (String address);
	
	public void insertPerson (String Person);
	
	public void updatePerson (String Person);
	
	public void deletePerson (int ID);
	
	public ArrayList<Person> search (String wClause);
	
	public Supplier buildPerson() throws SQLException;

	public String buildQuery(String wClause);
}
