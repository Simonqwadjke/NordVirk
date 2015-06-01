package ModelLayer;

@SuppressWarnings ("unused")
public abstract class Person {

	private int ID;
	private String name;
	private String address;
	private String email;

	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	public String getAddress(){
		return address;
	}

	public void setAdress(String address){
		this.address = address;
	}
	public String getEmail(){
		
		return email;
	}
	
	public void setEmail(String email){
		
		this.email = email;
	}
	
	
}
