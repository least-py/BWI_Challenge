package greedy_algorithm;

import java.util.ArrayList;

public class Coordination {

	public static void main(String[] args) {
		
		Warehouse warehouse = new Warehouse(given_information());
		warehouse.sort_by_priority();
		
		double fst_drivers_weight = 72.4;
		double snd_drivers_weight = 85.7;
		double truck_capacity = 1100.0;
		
		Truck fst_truck = new Truck(fst_drivers_weight, truck_capacity);
		Truck snd_truck = new Truck(snd_drivers_weight, truck_capacity);
		
		
		
		

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
