package greedy_algorithm;

public class Item {
	
	private String name;
	private int weight;
	private int value;
	
	public Item(String name, int weight, int value) {
		this.setName(name);
		this.setWeight(weight);
		this.setValue(value);
	}
	
	 @Override
	 public boolean equals(Object obj) { 
	    if(this == obj) 
	    	return true;
	    
	    if(obj == null || obj.getClass()!= this.getClass()) 
	    	return false; 
	    
	    Item item = (Item) obj; 
	    
	    //comparing the values of the attributes
	    //name, weight and value uniquely identify the object
	    return (item.name.equals(this.name) && item.weight == this.weight && item.value == this.value); 
	     
	 }
	 

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	


}
