package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

public class DBWare{
	
	private Connection con;
	
	public DBWare(){
		con = DBConnection.getInstance().getDBcon();
	}
	
	public ArrayList<Ware> findByList(List list) throws SQLException{
		String wClause = " listID = " + list.getID();
		return search(wClause);
	}
	
	public ArrayList<Ware> findBySerial(String serialNumber) throws SQLException{
		String wClause = " serialNumber = " + serialNumber;
		return search(wClause);
	}
	
	public ArrayList<Ware> findBySignature(String signature) throws SQLException{
		String wClause = " signature = " + signature;
		return search(wClause);
	}
	
	public ArrayList<Ware> findByStatus(String status) throws SQLException{
		String wClause = " status = " + status;
		return search(wClause);
	}
	
	public void insert(Ware ware, int listID) throws SQLException{
		
		String query = " INSERT INTO Ware(listID,name,status,signature,serialNUmber)"
				+ " VALUES('" 
				+ listID + "','"
				+ ware.getName() + "','"
				+ ware.getStatus() + "','"
				+ ware.getSignature() + "','"
				+ ware.getSerialNumber() + "')";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeUpdate(query);
		stmt.close();
	}
	
	public void update(Ware ware)throws SQLException{
		
		String query = " UPDATE Ware SET"
				+ " name = '" + ware.getName() + "',"
				+ " status = '" + ware.getStatus() + "',"
				+ " signature = '" + ware.getSignature() + "',"
				+ " serialNumber = '" + ware.getSerialNumber() + "'"
				+ " WHERE wareID = " + ware.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeUpdate(query);
		stmt.close();
	}
	
	public void delete(Ware ware)throws SQLException{

		String query = " DELETE FROM Ware WHERE wareID = " + ware.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		stmt.executeUpdate(query);
		stmt.close();
	}
	
	private ArrayList<Ware> search(String wClause) throws SQLException{
		ResultSet results;
		ArrayList<Ware> wares = new ArrayList<Ware>();
		
		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		results = stmt.executeQuery(query);
		while(results.next()){
			Ware ware;
			ware = buildWare(results);
			wares.add(ware);
		}
		stmt.close();
		
		return wares;
	}
	
	private Ware buildWare(ResultSet results) throws SQLException{
		Ware ware = new Ware();
		
		ware.setID(results.getInt("wareID"));
		ware.setName(results.getString("name"));
		ware.setSerialNumber(results.getString("serialNumber"));
		ware.setSignature(results.getString("signature"));
		ware.setStatus(results.getString("status"));
		
		return ware;
	}

	private String buildQuery(String wClause){
		String query = "Select wareID, listID, name, status, signature, serialNumber FROM Ware";
		if(wClause.length() > 0){
			query = query + " WHERE" + wClause;
		}
		return query;
	}
}
