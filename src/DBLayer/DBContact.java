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
		String query = " INSERT INTO Person(name,phoneNumber,email,address,subtype)"
				+ " VALUES('" 
				+ contact.getName() + "','"
				+ contact.getPhoneNr() + "','"
				+ contact.getEmail() + "','"
				+ contact.getAddress() + "','"
				+ "Contact')";
		String getID = " SELECT personID FROM Person"
				+ " WHERE"
				+ " name = '" + contact.getName() + "'"
				+ " AND phoneNumber = '" + contact.getPhoneNr() + "'"
				+ " AND subtype = 'Contact";
		
		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(query);
		stmt.executeUpdate(query);
		ResultSet idRow = stmt.executeQuery(getID);
		idRow.next();
		stmt.executeUpdate(" INSERT INTO Contact(personID) VALUEs('"
				+ idRow.getInt(1) + "'");
		if(contact.getSupplier() != null){
			idRow = stmt.executeQuery("SELECT contactID FROM Contacts WHERE personID = '" + idRow.getInt(1) + "'");
			idRow.next();
			stmt.executeUpdate(" INSERT INTO SupplierContacts(contactID,supplierID) VALUES('"
					+ idRow.getInt(1) + "','" + contact.getSupplier().getID() + "')");
		}
		stmt.close();
	}

	public void update(Contact contact) throws SQLException {
		String query = " UPDATE Person SET"
				+ " name = '" + contact.getName() + "',"
				+ " phoneNumber = '" + contact.getPhoneNr() + "'"
				+ " email = '" + contact.getEmail() + "'"
				+ " address = '" + contact.getAddress() + "'"
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
	}

	public void delete(Contact contact) throws SQLException {
		String query = " DELETE FROM Person WHERE"
				+ " personID = " + contact.getID()
				+ " DELETE FROM Contact WHERE"
				+ " personID = " + contact.getID();
		String getID = " SELECT contactID FROM Contact WHERE personID = " + contact.getID();

		Statement stmt = con.createStatement();
		stmt.setQueryTimeout(5);
		System.out.println(getID);
		ResultSet idRow = stmt.executeQuery(getID);
		idRow.next();
		System.out.println(query);
		stmt.executeUpdate(query);
		query = " DELETE FROM SupplierContacts WHERE contactID = " + idRow.getInt(1);
		System.out.println(query);
		stmt.executeUpdate(query);
		stmt.close();

	}

	public ArrayList<Contact> search(String wClause) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Supplier buildPerson() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public String buildQuery(String wClause) {
		// TODO Auto-generated method stub
		return null;
	}

}