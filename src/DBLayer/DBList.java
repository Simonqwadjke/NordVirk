package DBLayer;

import java.sql.*;
import java.util.ArrayList;
import ModelLayer.*;

public class DBList {
	
	private Connection con;
	
	public DBList(){
		con = DBConnection.getInstance().getDBcon();
	}
	
	public ArrayList<List> findByName(String naem) throws SQLException{
		String wClause = "hej";
		return search(wClause);
	}
	
	private ArrayList<List> search(String wClause) throws SQLException{
		ResultSet results;
		ArrayList<List> lists = new ArrayList<List>();

		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		results = stmt.executeQuery(query);
		while(results.next()){
			List list;
			list = buildList(results);
			fillList(list);
			lists.add(list);
		}
		stmt.close();
		
		return lists;
	}
	
	private List buildList(ResultSet results) throws SQLException{
		List list = new List();
		
		list.setID(results.getInt("listID"));
		list.setName(results.getString("name"));
		list.setSupplier(new Supplier(results.getInt("supplier"), null, null, null));
		list.setCreator(new Employee(results.getInt("creator"), null, null, null, null, 0));
		list.setAcquasitionType(results.getString("acquasitionType"));
		
		return list;
	}
	
	private List fillList(List list) throws SQLException{
		DBWare DBware = new DBWare();
		
		ArrayList<Ware> array = DBware.findByList(list);
		for(int i = 0; i < array.size(); i++){
			list.addWare(array.get(i));
		}
		
		return list;
	}

	private String buildQuery(String wClause){
		String query = "SELECT listID, creator, supplierID, acquasitionType FROM List";
		if(wClause.length() > 0){
			query = query + " WHERE = " + wClause;
		}
		return query;
	}
}
