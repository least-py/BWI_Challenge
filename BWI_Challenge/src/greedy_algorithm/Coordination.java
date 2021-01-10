package greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class Coordinates the loading process of the respective trucks under 
 * the specifications defined in the Main Method.
 * @author Lea
 *
 */
public class Coordination {
	
	public static void main(String[] args) {
		
		//initialize the algorithm with given order list, trucks and capacities
		Warehouse warehouse = new Warehouse(given_information());
		
		double fst_drivers_weight = 72400.0;
		double snd_drivers_weight = 85700.0;
		double truck_capacity = 1100000.0;
		
		Truck fst_truck = new Truck(fst_drivers_weight, truck_capacity);
		Truck snd_truck = new Truck(snd_drivers_weight, truck_capacity);
		
		
		//------------------------- FIRST TRUCK -------------------------------
		fill_truck(warehouse, fst_truck);
		
		System.out.println("First Truck:");
		print_cargo(fst_truck.getCargo());
		

		//------------------------ SECOND TRUCK -------------------------------
		fill_truck(warehouse, snd_truck);
		
		System.out.println("Second Truck:");
		print_cargo(snd_truck.getCargo());
		
		
		print_transport_value(fst_truck, snd_truck);
		
		System.out.println("remaining space in the first truck: " + fst_truck.getRemaining_space());
		System.out.println("remaining space in the second truck: " + snd_truck.getRemaining_space());

	}
	
	/**
	 * Swaps the last item if the remaining space allows an item of higher value to be stowed.
	 * @param warehouse
	 * @param truck
	 */
	public static void change_last_item(Warehouse warehouse, Truck truck) {
		ArrayList <CargoPair> cargo = truck.getCargo();
		
		//sort Pairs by their items' weight
		Collections.sort(cargo, new Comparator<CargoPair>() {
			@Override
			 public int compare(CargoPair p1, CargoPair p2) {
				return ((Integer)(p1.item.getWeight())).compareTo((Integer)(p2.item.getWeight()));
			  }
			});
		
		Item last_item = cargo.get(0).item; 
		
		int alternative_size = (int) (truck.getRemaining_space() + last_item.getWeight());
		int items_value = last_item.getValue();
	
		ArrayList <Item> order_list = new ArrayList <Item>();
		
		//extract the items of higher value than the 'last item'
		for( CargoPair pair : warehouse.getOrder_list()) {
			if (pair.item.getValue() > items_value) {
				order_list.add(pair.item);
			}
		}
		//sort Items by value
		Collections.sort(order_list, new Comparator<Item>() {
			@Override
			  public int compare(Item i1, Item i2) {
			    return ((Integer)i2.getValue()).compareTo((Integer)i1.getValue());
			  }
		});
		
		//sorted by value (descending)
		for(Item i : order_list) {
			if(i.getWeight() <= alternative_size) {
				CargoPair pair = cargo.get(0);
				pair.amount = pair.amount - 1;
				if(pair.amount == 0) {
					cargo.remove(0);
				}
				
				//Find index of Pair with given Item in the warehouse
				Integer index = warehouse.find_Index_of_Item(pair.item);
				
				//In this case the item is not available in the warehouse, so it is "readded"
				if(index == null) {
					warehouse.getOrder_list().add(new CargoPair(pair.item, 1));
				}
				//In this case we update the amount of the item in the warehouse
				else {
					int position = Integer.valueOf(index);
					warehouse.getOrder_list().get(position).amount--;
				}
				
				truck.setRemaining_space(truck.getRemaining_space() + pair.item.getWeight());
				CargoPair loaded_pair = new CargoPair(i, 1);
				
				//load the item into the truck and update its amount in the warehouse
				truck.load_Pair(loaded_pair);
				warehouse.extractItem(loaded_pair);
				
				warehouse.sort_by_priority();
				break;
			}
		}
	}
	

	
	/**
	 * Fill a given truck with the available items in the warehouse regarding the priority and weight of the items.
	 * @param warehouse
	 * @param truck
	 */
	public static void fill_truck(Warehouse warehouse, Truck truck) {
		
		for(CargoPair order : warehouse.getOrder_list()) {
			
			if(truck.can_Item_be_loaded(order.item)) {
				
				//How many units would fit at most?
				CargoPair fitting_units_pair = get_fitting_units(order.item, warehouse, truck);
				
				//possible update of fitting units after reconciliation with the available stock 
				warehouse.extractItem(fitting_units_pair);
				
				//adding the pair to the load of the truck
				truck.load_Pair(fitting_units_pair);
			}
			else {
				continue;
			}
		}
		//Now every item was considered to be added to the cargo. 
		warehouse.clean_up_orders();
		
		change_last_item(warehouse, truck);
	}
	
	/**
	 * It determines how many units of the given item would fit in the truck without checking the actual quantity available.
	 * @param item
	 * @return A CargoPair of item and units
	 */
	public static CargoPair get_fitting_units(Item item, Warehouse warehouse, Truck truck) {
		//casting remaining_space from double to integer, so it will be rounded downwards
		int space = (int)truck.getRemaining_space();
		
		int units = space / item.getWeight();
		
		return new CargoPair(item, units);
	}
	
	/**
	 * creates the Item Objects with the required quantity with the information from the PDF
	 * @return order list for the Warehouse
	 */
	public static  ArrayList <CargoPair> given_information(){
		
		ArrayList <CargoPair> order_list = new ArrayList <CargoPair>();
		
		Item item = new Item("Notebook Buero 13 Zoll", 2451, 40);
		CargoPair pair = new CargoPair(item, 205);
		order_list.add(pair);
		
		item = new Item("Notebook Buero 14 Zoll", 2978, 35);
		pair = new CargoPair(item, 420);
		order_list.add(pair);
		
		item = new Item("Notebook outdoor", 3625, 80);
		pair = new CargoPair(item, 450);
		order_list.add(pair);
		
		item = new Item("Mobiltelefon Buero", 717, 30);
		pair = new CargoPair(item, 60);
		order_list.add(pair);
		
		item = new Item("Mobiltelefon Outdoor", 988, 60);
		pair = new CargoPair(item, 157);
		order_list.add(pair);
		
		item = new Item("Mobiltelefon Heavy Duty", 1220, 65);
		pair = new CargoPair(item, 220);
		order_list.add(pair);
		
		item = new Item("Tablet Buero klein", 1405, 40);
		pair = new CargoPair(item, 620);
		order_list.add(pair);
		
		item = new Item("Tablet Buero groﬂ", 1455, 40);
		pair = new CargoPair(item, 250);
		order_list.add(pair);
		
		item = new Item("Tablet outdoor klein", 1690, 45);
		pair = new CargoPair(item, 540);
		order_list.add(pair);
		
		item = new Item("Tablet outdoor groﬂ", 1980, 68);
		pair = new CargoPair(item, 370);
		order_list.add(pair);
		
		return order_list;
	}
	
	/**
	 * Printing the given cargo
	 * @param cargo
	 */
	public static void print_cargo(ArrayList<CargoPair> cargo) {
		
		for(CargoPair pair : cargo) {
			System.out.println(    "Units: " 
							   +	 pair.amount +
								 "	Priority: "
							   + ((double)pair.item.getValue()/(double)pair.item.getWeight())
							   + "	Item: "
							   +	 pair.item.getName()+" "
							   + "	Value: "
							   +	 pair.item.getValue()+" "
							   + "	Weight: "
							   +	 pair.item.getWeight());
			
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------");
	}
	
	
	/**
	 * Prints the loaded value of the two trucks
	 * @param fst_truck
	 * @param snd_truck
	 */
	public static void print_transport_value(Truck fst_truck, Truck snd_truck) {
		System.out.println();
		System.out.println("loaded value in first truck: " + fst_truck.get_loaded_value());
		System.out.println("loaded value in second truck: " + snd_truck.get_loaded_value());
		System.out.println();
	}
}
