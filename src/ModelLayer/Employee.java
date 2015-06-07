package ModelLayer;

public class Employee extends Person {
	private int	rights;

	public Employee() {
		rights = 0;
	}

	public Employee(int ID, String name, String phoneNr, String address, String email, int rights) {
		super(ID, name, phoneNr, address, email);
		this.rights = rights;
	}

	public int getRights() {
		return rights;
	}

	public void setRights(int rights) {
		this.rights = rights;
	}
}