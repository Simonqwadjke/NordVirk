package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public class DBPerson {

	private Connection con;
	
	public ArrayList<> findPersonByName (String name)
	{
		
	}
	
	public ArrayList<> findPersonByPhoneNumber (String phoneNumber)
	{
		
	}
	
	public ArrayList<> findPersonByEmail (String email)
	{
		
	}
	
	public ArrayList<> findPersonByAddress (String address)
	{
		
	}
	
	public void insertPerson (String Person)
	{
		
	}
	
	public void updatePerson (String Person)
	{
		
	}
	
	public void deletePerson (int ID)
	{
		
	}
	
	public ArrayList<> search (String wClause)
	{
		
	}
	
	public Supplier buildPerson() throws SQLException{
		
	}

	public String buildQuery(String wClause){
		String query = "";
		if(wClause.length() > 0){
			query = query + " WHERE " + wClause;
		}
		return query;
	}
}
