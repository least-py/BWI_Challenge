package greedy_algorithm;

import java.util.ArrayList;

public class Truck {

	private double remaining_space;
	private ArrayList <CargoPair> cargo;
	
	public Truck(double drivers_weight, double capacity) {
		this.remaining_space = capacity - drivers_weight;
		this.cargo = new ArrayList<CargoPair>();
	}
	
	/**
	 * If the number exceeds the remaining capacity,
	 * then false will be returned. 
	 * If the specified amount has been successfully loaded
	 * into the truck, then true is returned.
	 * @param pair hardware item and its amount in the cargo
	 */
	public boolean loadItem(CargoPair pair) {
		int loading_weight = pair.loading_weight();
		if(remaining_space >= loading_weight) {
			cargo.add(pair);
			remaining_space = remaining_space - loading_weight;
			return true;
		}
		else {
			return false;
		}
	}
	
}
