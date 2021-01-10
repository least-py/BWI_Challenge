package greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse {
	
	private ArrayList <CargoPair> order_list;
	//Names of the items which are no longer in the stock after filling the truck
	//private ArrayList <Item> removed_items = new ArrayList <Item>();
	
	
	/**
	 * Constructor will initialize the {@link #order_list} sorted by priority.
	 * @param order_list
	 */
	public Warehouse(ArrayList <CargoPair> order_list) {
		this.setOrder_list(order_list);
		sort_by_priority();
	}
	
	/**
	 * Updating the order quantity in the {@link #order_list} to load a certain amount of an item type.
	 * The method compares the quantity to be loaded with the available quantity and updates the load if necessary.
	 * If the entire amount of an item type has been loaded, its index will be added to the {@link #removed_items} list.
	 * @param pair item to load and its updated amount
	 */
	public void extractItem(CargoPair cargo_pair) {
		int units_to_load = cargo_pair.amount;
		Item searched_item = cargo_pair.item;
		
		for (CargoPair order : getOrder_list()) {
			
			if(order.item.getName().equals(searched_item.getName())) { 
				
				//if the quantity of items in the cargo_pair exceeds the existing amount in the warehouse
				//all units of this item are removed from the warehouse
				if (units_to_load >= order.amount) {
					units_to_load = order.amount;
					order.amount = 0;
					
					//the entire ordered quantity has been loaded
					//removed_items.add(order.item);
				}
				else {
				order.amount = order.amount - cargo_pair.amount;
				}
				break;
			}
		}
		
		//updating amount in cargo_pair
		cargo_pair.amount = units_to_load;
	}
	
	public Integer find_Index_of_Item(Item item) {
		for(int i = 0; i < order_list.size(); i++) {
			if(order_list.get(i).item.equals(item)) {
				return (Integer)i;
			}
		}
		return null;
	}
	
	/**
	 * Cleaning up the {@link #order_list} with the help of the {@link #removed_items} list. The Names are uniquely!
	 * The method should be used after filling a truck.
	 */
	public void clean_up_orders() {
		getOrder_list().removeIf(pair -> pair.amount == 0);
	}
	
	/**
	 * The given orders won't be inserted by priority. 
	 * The method will only concatenate the ArrayList with the already existing {@link #order_list}
	 * @param new_orders
	 */
	public void add_orders(ArrayList <CargoPair> new_orders) {
		getOrder_list().addAll(new_orders);
	}
	

	public void sort_by_priority() {
		Collections.sort(getOrder_list(), Collections.reverseOrder());
	}

	public ArrayList <CargoPair> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(ArrayList <CargoPair> order_list) {
		this.order_list = order_list;
	}
}
