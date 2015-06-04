package ModelLayer;

import java.util.ArrayList;

public class ListSearch {

	ArrayList<Ware> wares;

	ListSearch(ArrayList<Ware> wares) {
		this.wares = wares;
	}

	/**
	 * Search the Wares of this supplier by Name. Returns null if no match is
	 * found.
	 */
	public Ware byID(int ID) {
		int indx = 0;
		boolean running = true;
		Ware Ware = null;
		while (indx <= wares.size() && running) {
			Ware = wares.get(indx);
			if (Ware.getID() == ID) {
				running = false;
			}
			indx++;
		}
		return Ware;
	}
	
	public Ware byStatus(String status) {
		int indx = 0;
		boolean running = true;
		Ware Ware = null;
		while (indx <= wares.size() && running) {
			Ware = wares.get(indx);
			if (Ware.getStatus().equals(status)) {
				running = false;
			}
			indx++;
		}
		return Ware;
	}
	
	public Ware bySignature(String signature) {
		int indx = 0;
		boolean running = true;
		Ware Ware = null;
		while (indx <= wares.size() && running) {
			Ware = wares.get(indx);
			if (Ware.getSignature().equals(signature)) {
				running = false;
			}
			indx++;
		}
		return Ware;
	}
	
	public Ware bySerialNumber(String serialNumber) {
		int indx = 0;
		boolean running = true;
		Ware Ware = null;
		while (indx <= wares.size() && running) {
			Ware = wares.get(indx);
			if (Ware.getSerialNumber().equals(serialNumber)) {
				running = false;
			}
			indx++;
		}
		return Ware;
	}
}
