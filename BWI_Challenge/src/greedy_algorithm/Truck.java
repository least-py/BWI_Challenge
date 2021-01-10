package greedy_algorithm;

import java.util.ArrayList;

public class Truck {

	private double remaining_space;
	private ArrayList <CargoPair> cargo;
	
	public Truck(double drivers_weight, double capacity) {
		this.setRemaining_space(capacity - drivers_weight);
		this.setCargo(new ArrayList<CargoPair>());
	}
	
	
	/**
	 * After the truck is loaded, this method calculates the sum of all values of all items to get the whole transported value.
	 * @return
	 */
	public int get_loaded_value() {
		int value = 0;
		for(CargoPair pair : getCargo()) {
			value = value + (pair.item.getValue()*pair.amount);
		}
		return value;
	}
	
	/**
	 * Checks if the weight of the given item exceeds the remaining space.
	 * @param item
	 * @return true if the item can be loaded into the truck
	 */
	public boolean can_Item_be_loaded(Item item) {
		if(getRemaining_space() >= item.getWeight()) 
			return true;
		else
			return false;
	}
	
	
	/**
	 * Adding the given pair to {@link #cargo} and updating the remaining space in the truck.
	 * @param pair hardware item and its amount in the cargo
	 */
	public void load_Pair(CargoPair pair) {
		int loading_weight = pair.loading_weight();
		getCargo().add(pair);
		setRemaining_space(getRemaining_space() - loading_weight);
		
	}

	public double getRemaining_space() {
		return remaining_space;
	}

	public void setRemaining_space(double remaining_space) {
		this.remaining_space = remaining_space;
	}

	public ArrayList <CargoPair> getCargo() {
		return cargo;
	}

	public void setCargo(ArrayList <CargoPair> cargo) {
		this.cargo = cargo;
	}
	
}
