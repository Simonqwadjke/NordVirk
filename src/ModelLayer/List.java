package ModelLayer;

import java.util.ArrayList;

public class List {

	private int				ID;
	private String			name;
	private ArrayList<Ware>	wares;
	private Employee		creator;
	private Supplier		supplier;
	private String			acquasitionType;
	public ListSearch		search;

	public List() {

	}

	public List(int ID, String name, ArrayList<Ware> wares, Employee creator, Supplier supplier, String acquasitionType) {
		this.ID = ID;
		this.name = name;
		this.wares = wares;
		this.creator = creator;
		this.supplier = supplier;
		this.acquasitionType = acquasitionType;
	}

	public Ware getWare(int index) {
		Ware ware = null;
		if (index < wares.size()) {
			ware = wares.get(index);
		}
		return ware;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public Employee getCreator() {
		return creator;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public String getAcquasitionType() {
		return acquasitionType;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWare(int indx, Ware ware) {
		wares.set(indx, ware);
	}

	public void addWare(Ware ware) {
		wares.add(ware);
	}

	public void deleteWare(int indx) {
		wares.remove(indx);
	}

	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public void setAcquasitionType(String acquasitionType) {
		this.acquasitionType = acquasitionType;
	}
}
