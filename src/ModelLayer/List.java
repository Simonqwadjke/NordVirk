package ModelLayer;

import java.util.ArrayList;

@SuppressWarnings ("unused")
public class List {
	
	private int ID;
	private String name;
	private ArrayList<Ware> wares;
	private Employee creator;
	private Supplier supplier;
	private String acquasitionType;
	public ListSearch search;
	
	public List(){
		
	}
	
	public List(int ID,String name, ArrayList<Ware> wares, Employee creator, Supplier supplier, String acquasitionType){
		this.ID = ID;
		this.name = name;
		this.wares = wares;
		this.creator = creator;
		this.supplier = supplier;
		this.acquasitionType = acquasitionType;
	}

}
