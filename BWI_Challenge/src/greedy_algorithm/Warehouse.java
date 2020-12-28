package greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Warehouse {
	
	private ArrayList <CargoPair> order_list;
	
	public Warehouse() {
		this.setOrder_list(new ArrayList <CargoPair>());
	}
	
	public Warehouse(ArrayList <CargoPair> order_list) {
		this.setOrder_list(order_list);
	}
	
	/**
	 * Updating the order quantity after a certain amount of an item type has been loaded
	 * @param pair loaded item type and its amount
	 */
	public void extractItem(CargoPair loaded_item_pair) {
		Item searched_item = loaded_item_pair.item;
		int index = 0;
		for (CargoPair order : getOrder_list()) {
			//reduce the ordered quantity by the loaded quantity
			if(order.item.equals(searched_item)) 
				order.amount = order.amount - loaded_item_pair.amount;
			
			index++;
			break;
		}
		//When the entire ordered quantity has been loaded, 
		//the order entry can be deleted.
		if(getOrder_list().get(index).amount == 0) 
			getOrder_list().remove(index);
	}
	
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
