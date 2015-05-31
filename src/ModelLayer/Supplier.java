package ModelLayer;

public class Supplier {

	private Contact contact;
	private String phoneNr;
	
	public Contact getContact(){
		return this.contact;
	}
	
	public String getPhoneNr(){
		return this.phoneNr;
	}
	public void setContact(Contact contact){
		this.contact = contact;
	}
}
