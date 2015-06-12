package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;


public class DBSupplier {

	private Connection	con;

	public DBSupplier() {
		con = DBConnection.getInstance().getDBcon();
	}

	public ArrayList<Supplier> findByName(String name) throws SQLException {
		String wClause = " name = '" + name + "'";
		return search(wClause);
	}

	public ArrayList<Supplier> findByCVR(String CVR) throws SQLException {
		String wClause = " CVR = '" + CVR + "'";
		return search(wClause);
	}

	public ArrayList<Supplier> findByAddress(String address) throws SQLException {
		String wClause = " address = '" + address + "'";
		return search(wClause);
	}
	
	public void insert(Supplier supplier) throws SQLException {
		DBContact DBcontact = new DBContact();
		ResultSet idRow;
		int i = 0;
		String query = " INSERT INTO Supplier(name, CVR, address, phoneNumber)"
				+ " VALUES('"
				+ supplier.getName() + "','"
				+ supplier.getCVR() + "','"
				+ supplier.getAddress() + "','"
				+ supplier.getPhoneNr() + "')";
		String getID = " SELECT supplierID FROM SUpplier WHERE"
				+ " CVR = '" + supplier.getCVR() + "'"
				+ " AND address = '" + supplier.getAddress() + "'";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		idRow = stmt.executeQuery(getID);
		while(idRow.next()) supplier.setID(idRow.getInt(1));
		stmt.close();
		System.out.println("success");
		while(supplier.search.byIndex(i) != null){
			DBcontact.insert(supplier.search.byIndex(i));
		}
	}
	
	public void update(Supplier supplier) throws SQLException {
		
	}
	
	public void delete(Supplier supplier) throws SQLException {
		
	}

	private ArrayList<Supplier> search(String wClause) throws SQLException {
		ResultSet results;
		ArrayList<Supplier> sups = new ArrayList<Supplier>();
		
		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		results = stmt.executeQuery(query);
		while(results.next()){
			Supplier sup;
			sup = buildSupplier(results);
			sups.add(sup);
		}
		stmt.close();
		System.out.println("success");
		
		return sups;
	}
	
	private Supplier buildSupplier(ResultSet results) throws SQLException {
		Supplier sup = new Supplier();
		sup.setID(results.getInt("supplierID"));
		sup.setName(results.getString("name"));
		sup.setCVR(results.getInt("CVR"));
		sup.setAddress(results.getString("address"));
		sup.setPhoneNr(results.getString("phoneNumber"));
		sup.addContact(new Contact(results.getInt("personID"), null, null, null ,null, sup));
		
		return sup;
	}
	
	private String buildQuery(String wClause) {
		String query = " SELECT s.supplierID, name, CVR, address, c.personID FROM Supplier as s, Contact as c, SupplierContacts sc WHERE c.contactID = sc.contactID AND sc.supplierID = s.supplierID";
		if(wClause.length() > 0){
			query = query + " AND" + wClause;
		}
		return query;
	}
}
