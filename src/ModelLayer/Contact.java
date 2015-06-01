package ModelLayer;

public class Contact extends Person{
	
	private supplier Supplier;
	
	public Contact()
	{
		supplier = null;
	}
	
	public Contact(Supplier supplier)
	{
		this.supplier =  supplier;
	}
	
	public supplier getSupplier()
	{
		return supplier;
	}
	
	public void setSupplier(supplier Supplier)
	{
		this.supplier = supplier;
	}

}
