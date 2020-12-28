package greedy_algorithm;

import java.util.ArrayList;

public class Coordination {
	
	public static void main(String[] args) {
		
		//initialize the algorithm with given order list, trucks and capacities
		Warehouse warehouse = new Warehouse(given_information());
		
		double fst_drivers_weight = 72400.0;
		double snd_drivers_weight = 85700.0;
		double truck_capacity = 1100000.0;
		
		Truck fst_truck = new Truck(fst_drivers_weight, truck_capacity);
		Truck snd_truck = new Truck(snd_drivers_weight, truck_capacity);
		
		//print_cargo(warehouse.getOrder_list());
		
		fill_truck(warehouse, fst_truck);
		
		print_cargo(fst_truck.getCargo());
		
		System.out.println();
		
		fill_truck(warehouse, snd_truck);
		
		print_cargo(snd_truck.getCargo());
		
		System.out.println("space left");
		System.out.println(fst_truck.getRemaining_space());
		System.out.println(snd_truck.getRemaining_space());

	}
	
	
	
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
	}
	
	/**
	 * 
	 * @param item
	 * @return
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
	
	
	public static void print_cargo(ArrayList<CargoPair> cargo) {
		
		for(CargoPair pair : cargo) {
			System.out.println(pair.amount +
								"  priority: "+ ((double)pair.item.getValue()/(double)pair.item.getWeight())
							   + "   Hardware: "+
							   pair.item.getName()+" "+
							   pair.item.getValue()+" "+
							   pair.item.getWeight());
			
		}
	}
}
