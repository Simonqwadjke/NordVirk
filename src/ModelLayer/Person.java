package ModelLayer;

public abstract class Person {

	private int		ID;
	private String	name;
	private String	phoneNr;
	private String	address;
	private String	email;

	//////////Constructors\\\\\\\\\\

	protected Person() {
		ID = 0;
		name = "";
		phoneNr = "";
		address = "";
		email = "";
	}

	protected Person(int ID, String name, String phoneNr, String address, String email) {
		this.ID = ID;
		this.name = name;
		this.phoneNr = phoneNr;
		this.address = address;
		this.email = email;
	}

	//////////Set Methods\\\\\\\\\\

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public void setAdress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//////////Get Methods\\\\\\\\\\

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getPhoneNr() {
		return this.phoneNr;
	}

	public String getAddress() {
		return address;
	}

	public String setEmail() {
		return this.email;
	}
}
