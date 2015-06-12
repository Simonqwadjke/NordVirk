package DBLayer;

import java.sql.*;
import java.util.ArrayList;

import ModelLayer.*;

public class DBContact {
	
	Connection con;
	
	public DBContact(){
		con = DBConnection.getInstance().getDBcon();
	}

	public ArrayList<Contact> findByName(String name) throws SQLException {
		String wClause = " name = '" + name + "'";
		return search(wClause);
	}

	public ArrayList<Contact> findByPhoneNumber(String phoneNumber) throws SQLException {
		String wClause = " phoneNubmer = '" + phoneNumber + "'";
		return search(wClause);
	}

	public ArrayList<Contact> findByEmail(String email) throws SQLException {
		String wClause = " email = '" + email + "'";
		return search(wClause);
	}

	public ArrayList<Contact> findByAddress(String address) throws SQLException {
		String wClause = " address = '" + address + "'";
		return search(wClause);
	}
	
	public ArrayList<Contact> findBySupplier(Supplier supplier) throws SQLException {
		String wClause = " supplierID = '" + supplier.getID() + "'";
		return search(wClause);
	}

	public void insert(Contact contact) throws SQLException {
		int id = 0;
		String query = " INSERT INTO Person(name,phoneNumber,email,address,subtype)"
				+ " VALUES('" 
				+ contact.getName() + "','"
				+ contact.getPhoneNr() + "','"
				+ contact.getEmail() + "','"
				+ contact.getAddress() + "',"
				+ "'Contact')";
		String getID = " SELECT personID FROM Person"
				+ " WHERE"
				+ " name = '" + contact.getName() + "'"
				+ " AND phoneNumber = '" + contact.getPhoneNr() + "'"
				+ " AND subtype = 'Contact'";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		System.out.println(getID);
		ResultSet idRow = stmt.executeQuery(getID);
		while(idRow.next()) id = idRow.getInt(1);
		stmt.executeUpdate(" INSERT INTO Contact(personID) VALUEs('"
				+ id + "')");
		if(contact.getSupplier() != null){
			idRow = stmt.executeQuery(" SELECT contactID FROM Contact WHERE personID = '" + id + "'");
			idRow.next();
			stmt.executeUpdate(" INSERT INTO SupplierContacts(contactID,supplierID) VALUES('"
					+ idRow.getInt(1) + "','" + contact.getSupplier().getID() + "')");
		}
		stmt.close();
		System.out.println("success!");
	}

	public void update(Contact contact) throws SQLException {
		String query = " UPDATE Person SET"
				+ " name = '" + contact.getName() + "',"
				+ " phoneNumber = '" + contact.getPhoneNr() + "',"
				+ " email = '" + contact.getEmail() + "',"
				+ " address = '" + contact.getAddress() + "',"
				+ " subtype = 'Contact'"
				+ " WHERE personID = " + contact.getID()
				+ " UPDATE SupplierContacts SET"
				+ " supplierID = " + contact.getSupplier().getID()
				+ " WHERE contactID = " + contact.getID();
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");
	}

	public void delete(Contact contact) throws SQLException {
		String query = " DELETE FROM Contact  WHERE"
				+ " personID = " + contact.getID()
				+ " DELETE FROM Person WHERE"
				+ " personID = " + contact.getID();
		String getID = " SELECT contactID FROM Contact WHERE personID = " + contact.getID();

		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(getID);
		ResultSet idRow = stmt.executeQuery(getID);
		idRow.next();
		String supplierQuery = " DELETE FROM SupplierContacts WHERE contactID = " + idRow.getInt(1);
		System.out.println(supplierQuery);
		stmt.executeUpdate(supplierQuery);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();
		System.out.println("success!");

	}

	private ArrayList<Contact> search(String wClause) throws SQLException {
		ResultSet results;
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		String query = buildQuery(wClause);
		
		Statement stmt = con.createStatement();
		System.out.println(query);
		results = stmt.executeQuery(query);
		while(results.next()){
			Contact contact;
			contact = buildContact(results);
			contacts.add(contact);
		}
		stmt.close();
		System.out.println("success!");
		
		return contacts;
	}

	private Contact buildContact(ResultSet results) throws SQLException {
		Contact contact = new Contact();
		contact.setID(results.getInt("personID"));
		contact.setName(results.getString("name"));
		contact.setPhoneNr(results.getString("phoneNumber"));
		contact.setAdress(results.getString("address"));
		contact.setEmail(results.getString("email"));
		Supplier supplier = new Supplier();
		supplier.setID(results.getInt("supplierID"));
		contact.setSupplier(supplier);
		return contact;
	}

	private String buildQuery(String wClause) {
		String query = " SELECT Person.personID, name, phoneNumber, address, email, supplierID FROM Person, Contact as c, SupplierContacts as s WHERE c.contactID = s.contactID";
		if(wClause.length() > 0){
			query = query + " AND" + wClause;
		}
		return query;
	}

}
