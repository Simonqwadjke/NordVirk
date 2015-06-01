package ModelLayer;

public class Contact extends Person{
	
	private Supplier supplier;
	
	public Contact()
	{
		supplier = null;
	}
	
	public Contact(Supplier supplier)
	{
		this.supplier =  supplier;
	}
	
	public Supplier getSupplier()
	{
		return supplier;
	}
	
	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}

}
