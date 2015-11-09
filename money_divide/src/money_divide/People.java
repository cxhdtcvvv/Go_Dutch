package money_divide;

import java.util.HashMap;
import java.util.Map;

public class People {
	String name;
	double money_paid = 0;
	Map<String, Double> who_to_pay = new HashMap<String, Double>();
	
	People(String name, double money){
		this.name = name;
		this.money_paid = money; 
	}
}
