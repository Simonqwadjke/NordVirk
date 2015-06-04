package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public interface DBPerson {
	
	public ArrayList<Person> findByName (String name) throws SQLException;
	
	public ArrayList<Person> findByPhoneNumber (String phoneNumber) throws SQLException;
	
	public ArrayList<Person> findByEmail (String email) throws SQLException;
	
	public ArrayList<Person> findByAddress (String address) throws SQLException;
	
	public void insert(Person person) throws SQLException;
	
	public void update(Person person) throws SQLException;
	
	public void delete(Person person) throws SQLException;
	
	public ArrayList<Person> search (String wClause) throws SQLException;
	
	public Supplier buildPerson() throws SQLException;

	public String buildQuery(String wClause);
}
