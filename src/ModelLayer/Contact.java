package ModelLayer;

public class Contact extends Person {

	private Supplier	supplier;

	public Contact() {
		supplier = null;
	}

	public Contact(int ID, String name, String phoneNr, String address, String email, Supplier supplier) {
		super(ID, name, phoneNr, address, email);
		this.supplier = supplier;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
