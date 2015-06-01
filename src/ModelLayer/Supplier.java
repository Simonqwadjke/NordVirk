package ModelLayer;

import java.util.ArrayList;

public class Supplier {

	private int ID;
	private String name;
	private String address;
	private String phoneNr;
	private ArrayList<Contact> contacts;
	public SupplierSearch search;
	
	//////////Constructor\\\\\\\\\\
	public Supplier(){
		ID = 0;
		name = "";
		address = "";
		phoneNr = "";
		search = new SupplierSearch(contacts);
	}
	
	public Supplier(int ID, String name, String address, String phoneNr){
		this.ID = ID;
		this.name = name;
		this. address = address;
		this.phoneNr = phoneNr;
	}
	//////////Get methods\\\\\\\\\\
	
	public int getID(){
		return this.ID;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getPhoneNr(){
		return this.phoneNr;
	}
	
	//////////Set methods\\\\\\\\\\
	public void setID(int ID){
		this.ID = ID;
	}
	
	public void setName(String name){
		this.name= name;
	}
	
	public void setAddress(String address){
		this.address= address;
	}
	
	public void setPhoneNr(String phoneNr){
		this.phoneNr = phoneNr;
	}
}
