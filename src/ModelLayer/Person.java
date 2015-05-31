package ModelLayer;

public abstract class Person {

	public String name;
	public String address;
	public String email;
	
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
