package ModelLayer;

public class Ware {
	
	private int ID;
	private String name;
	private String status;
	private String signature;
	private String serialNumber;
	
	public Ware(){
		
	}
	
	public Ware(int ID, String name, String status, String signature, String serialNumber){
		this.ID = ID;
		this.name = name;
		this.status = status;
		this.signature = signature;
		this.serialNumber = serialNumber;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	

}
