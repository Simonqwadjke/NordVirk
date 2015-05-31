package ModelLayer;

public abstract class Person {

	private String name;
	private String address;
	
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
}
