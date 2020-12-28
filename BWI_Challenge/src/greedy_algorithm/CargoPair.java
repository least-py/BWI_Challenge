package greedy_algorithm;

public class CargoPair implements Comparable<CargoPair>{
	
	public final Item item;
	public int amount;
	
	public CargoPair(Item item, int amount) {
		this.item = item;
		this.amount = amount;
	}
	
	/**
	 * @return the total weight resulting from the quantity and the weight of the item.
	 */
	public int loading_weight() {
		return this.item.getWeight() * amount;
	}

	@Override
	public int compareTo(CargoPair o) {
		//value and weight will be compared individually to avoid comparing double values
		//and thus inaccuracies
		
		int v1 = this.item.getValue();
		int w1 = this.item.getWeight();
		
		int v2 = o.item.getValue();
		int w2 = o.item.getWeight();
		
		if (v1 < v2) 
			if (w1 >= w2) 
				return -1;
		
		if (v1 == v2)
			if (w1 < w2)
				return 1;
		
			else if (w1 == w2)
				return 0;
		
			else if (w1 < w2)
				return -1;
		
		if (v1 > v2)
			if(w1 <= w2)
				return 1;
		

		//at this point (v1<v2 and w1<w2) as well as (v1>v2 and w1>w2) are left
		//calculating the quotient is now necessary
		
		double q1 = ((double)v1) / ((double)w1);
		double q2 = ((double)v2) / ((double)w2);
		
		if (q1 < q2) 
			return -1;
		//q1=q2 can not hold, because the case of equality has been already covered 
		//by (v1=v2 and w1=w2)
		//if q1=q2 then it must be a rounding inaccuracy
		else
			return 1;
			
		
	}
}
