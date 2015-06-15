package ModelLayer;

import java.util.ArrayList;

public class ListSearch {

	ArrayList<Ware>	wares;

	ListSearch(ArrayList<Ware> wares) {
		this.wares = wares;
	}

	public Ware byIndex(int index) {
		Ware ware = null;
		if (index < wares.size() && index >= 0) {
			ware = wares.get(index);
		}
		return ware;
	}

	/**
	 * Search the Wares of this supplier by Name. Returns null if no match is
	 * found.
	 */
	public Ware byID(int ID) {
		int indx = 0;
		boolean running = true;
		Ware ware = null;
		try {
			while (indx <= wares.size() && running) {
				ware = wares.get(indx);
				if (ware.getID() == ID) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			ware = null;
		}
		return ware;
	}

	public Ware byStatus(String status) {
		int indx = 0;
		boolean running = true;
		Ware ware = null;
		try {
			while (indx <= wares.size() && running) {
				ware = wares.get(indx);
				if (ware.getStatus().equals(status)) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			ware = null;
		}
		return ware;
	}

	public Ware bySignature(String signature) {
		int indx = 0;
		boolean running = true;
		Ware ware = null;
		String search;
		while (indx < wares.size() && running) {
			search = wares.get(indx).getSignature();
			if (ware.getSignature().equals(search)) {
				ware = wares.get(indx);
				running = false;
			}
			indx++;
		}
		return ware;
	}

	public Ware bySerialNumber(String serialNumber) {
		int indx = 0;
		boolean running = true;
		Ware ware = null;
		try {
			while (indx <= wares.size() && running) {
				ware = wares.get(indx);
				if (ware.getSerialNumber().equals(serialNumber)) {
					running = false;
				}
				indx++;
			}
		}
		catch (IndexOutOfBoundsException e) {
			ware = null;
		}
		return ware;
	}
}
