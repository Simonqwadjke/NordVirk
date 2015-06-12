package ModelLayer;

import java.util.ArrayList;

public class SupplierSearch {
	private ArrayList<Contact>	contacts;

	SupplierSearch(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public Contact byIndex(int index){
		Contact contact = null;
		if(index < contacts.size() || index >= 0){
			contact = contacts.get(index);
		}
		return contact;
	}

	/**
	 * Search the contacts of this supplier by ID. Returns null if no match is
	 * found.
	 */
	public Contact byID(int ID) {
		int indx = 0;
		boolean running = true;
		Contact contact = null;
		try {
			while (indx <= contacts.size() && running) {
				contact = contacts.get(indx);
				if (contact.getID() == ID) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			contact = null;
		}
		return contact;
	}

	/**
	 * Search the contacts of this supplier by Name. Returns null if no match is
	 * found.
	 */
	public Contact byName(String name) {
		int indx = 0;
		boolean running = true;
		Contact contact = null;
		try {
			while (indx <= contacts.size() && running) {
				contact = contacts.get(indx);
				if (contact.getName().equals(name)) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			contact = null;
		}
		return contact;
	}

	/**
	 * Search the contacts of this supplier by Phone Number. Returns null if no
	 * match is found.
	 */
	public Contact byProneNr(String phoneNr) {
		int indx = 0;
		boolean running = true;
		Contact contact = null;
		try {
			while (indx <= contacts.size() && running) {
				contact = contacts.get(indx);
				if (contact.getName().equals(phoneNr)) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			contact = null;
		}
		return contact;
	}

	/**
	 * Search the contacts of this supplier by Email. Returns null if no match
	 * is found.
	 */
	public Contact byEmail(String email) {
		int indx = 0;
		boolean running = true;
		Contact contact = null;
		try {
			while (indx <= contacts.size() && running) {
				contact = contacts.get(indx);
				if (contact.getName().equals(email)) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			contact = null;
		}
		return contact;
	}

	/**
	 * Search the contacts of this supplier by Address. Returns null if no match
	 * is found.
	 */
	public Contact byAddress(String address) {
		int indx = 0;
		boolean running = true;
		Contact contact = null;
		try {
			while (indx <= contacts.size() && running) {
				contact = contacts.get(indx);
				if (contact.getName().equals(address)) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			contact = null;
		}
		return contact;
	}
}
