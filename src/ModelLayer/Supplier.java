package ModelLayer;

import java.util.ArrayList;

public class Supplier {

	private int					ID;
	private String				name;
	private String				address;
	private String				phoneNr;
	private ArrayList<Contact>	contacts;
	public SupplierSearch		search;

	//////////Constructor\\\\\\\\\\
	public Supplier() {
		ID = 0;
		name = "";
		address = "";
		phoneNr = "";
		contacts = new ArrayList<>();
		search = new SupplierSearch(contacts);
	}

	public Supplier(int ID, String name, String address, String phoneNr) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.phoneNr = phoneNr;
		contacts = new ArrayList<>();
		search = new SupplierSearch(contacts);
	}

	//////////Get methods\\\\\\\\\\

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPhoneNr() {
		return this.phoneNr;
	}

	//////////Set methods\\\\\\\\\\
	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public void setContact(int indx, Contact contact) {
		contacts.set(indx, contact);
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void deleteContact(int indx) {
		contacts.remove(indx);
	}

	public static void main(String[] args) {
		//create supplier
		Supplier s = new Supplier();

		//create 3 contacts and set their supplier to the above.
		Contact c1 = new Contact(1, "Simon", "99887766", "home", "a@mail.com", s);
		Contact c2 = new Contact(2, "Martin", "99887766", "home", "a@mail.com", s);
		Contact c3 = new Contact(3, "Anders", "99887766", "home", "a@mail.com", s);

		//adds all 3 newly created contacts to the contacts list.
		s.addContact(c1);
		s.addContact(c2);
		s.addContact(c3);

		//using SupplierSearch we find the contact by the name "Simon". Case sensitive.
		Contact returned = s.search.byName("Simon");

		//prints out the name of the returned contact to complete the test.
		System.out.println(returned.getName());
	}
}
