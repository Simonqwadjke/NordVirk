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
		search = new SupplierSearch();
	}
	
	public Supplier(int ID, String name, String address, String phoneNr){
		
	}
	//////////Get methods\\\\\\\\\\
	
	//////////Set methods\\\\\\\\\\
	public String getPhoneNr(){
		return this.phoneNr;
	}
}
