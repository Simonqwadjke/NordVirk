package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public interface DBPerson {
	
	public ArrayList<Person> findByName (String name);
	
	public ArrayList<Person> findByPhoneNumber (String phoneNumber);
	
	public ArrayList<Person> findByEmail (String email);
	
	public ArrayList<Person> findByAddress (String address);
	
	public void insert(String Person);
	
	public void update(String Person);
	
	public void delete(int ID);
	
	public ArrayList<Person> search (String wClause);
	
	public Supplier buildPerson() throws SQLException;

	public String buildQuery(String wClause);
}
