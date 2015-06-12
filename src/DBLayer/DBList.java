package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public class DBList {
	
	private Connection con;
	
	public DBList(){
		con = DBConnection.getInstance().getDBcon();
	}
	
	public ArrayList<List> findByName(String name) throws SQLException{
		String wClause = " name = '" + name + "'";
		return search(wClause);
	}
	
	public ArrayList<List> findByCreator(Employee creator) throws SQLException{
		String wClause = " creator = '" + creator.getID() + "'";
		return search(wClause);
	}
	
	public ArrayList<List> findBySupplier(Supplier supplier) throws SQLException{
		String wClause = " supplier = '" + supplier.getID() + "'";
		return search(wClause);
	}
	
//	public ArrayList<List> findList(String startDate, String endDate) throws SQLException{
//		//TODO: work in progress
//	}
	
	public void insert(List list) throws SQLException{
		DBWare DBware = new DBWare();
		ResultSet idRow;
		int i = 1;
		String query = " INSERT INTO List(name,creator,supplierID,acquasitionType)"
				+ " VALUES('" + list.getName() + "','"
				+ list.getCreator().getID() + "','"
				+ list.getSupplier().getID() + "','"
				+ list.getAcquasitionType() + "')";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		idRow = stmt.executeQuery(" SELECT listID FROM List WHERE name = '" + list.getName() + "'");
		while(idRow.next()) list.setID(idRow.getInt(1));
		stmt.close();
		System.out.println("success!");
		while(list.search.byIndex(i) != null){
			DBware.insert(list.search.byIndex(i),list);
			i++;
		}
	}
	
	public void update(List list) throws SQLException{
		DBWare DBware = new DBWare();
		int i = 1;
		String query = " UPDATE List SET"
				+ " name = '" + list.getName() + "',"
				+ " creator = '" + list.getCreator().getID() + "',"
				+ " supplierID = '" + list.getSupplier().getID() + "',"
				+ " acquasitionType = '" + list.getAcquasitionType() + "'"
				+ " WHERE listID = '" + list.getID() + "'";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");
		while(list.search.byIndex(i) != null){
			DBware.update(list.search.byIndex(i));
			i++;
		}
	}
	
	public void delete(List list) throws SQLException{
		DBWare DBware = new DBWare();
		int i = 1;
		String query = " DELETE FROM List WHERE listID = " + list.getID();
		
		while(list.search.byIndex(i) != null){
			DBware.delete(list.search.byIndex(i));
			i++;
		}
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");
	}
	
	private ArrayList<List> search(String wClause) throws SQLException{
		ResultSet results;
		ArrayList<List> lists = new ArrayList<List>();

		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		results = stmt.executeQuery(query);
		while(results.next()){
			List list;
			list = buildList(results);
			fillList(list);
			lists.add(list);
		}
		stmt.close();
		System.out.println("success!");
		
		return lists;
	}
	
	private List buildList(ResultSet results) throws SQLException{
		List list = new List();
		
		list.setID(results.getInt("listID"));
		list.setName(results.getString("name"));
		list.setSupplier(new Supplier(results.getInt("supplierID"), null, null, null));
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
		String query = " SELECT listID, name, creator, supplierID, acquasitionType FROM List";
		if(wClause.length() > 0){
			query = query + " WHERE" + wClause;
		}
		return query;
	}
}
