package money_divide;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AA {
	
	private int people_num;
	private List <People> people_list = new ArrayList<People>();
	private String name_i;
	private double money_i;
	private Scanner scanner;
	private double total_money;
	
	List<People> people_input(){
		System.out.println("Enter number of people in the party:  ");
		scanner = new Scanner(System.in);
		people_num = scanner.nextInt();
		int tempnum = people_num;
		while(tempnum != 0){
			System.out.println("Enter name: ");
			scanner = new Scanner(System.in);
			name_i = scanner.nextLine();
			System.out.println("Enter amount: ");
			scanner = new Scanner(System.in);
			money_i = scanner.nextDouble();
			people_list.add(new People(name_i,money_i) );
			total_money += money_i;
			
			tempnum--;
		}
		
		System.out.println("input received!" + " total: " + total_money);
		for(People temp : people_list ){
			System.out.println(temp.name +"  "+temp.money_paid );
		}
		return people_list;
	}
	
	List<People> settlement(){
		System.out.println("who to manage the payment? :");
		for(People temp : people_list ){
			System.out.println(temp.name);
		}
		System.out.println("input the name:");
		scanner = new Scanner(System.in);
		name_i = scanner.nextLine();
		
		People manager = null;
		for(People temp : people_list ){
			if(temp.name.equals(name_i)){
				manager = temp;
			}
		}
		
		double money_divided = total_money / people_num;
		money_divided = Math.round(money_divided*100.0)/100.0;
		
		System.out.println("everyone pay: " + money_divided);
		if(manager != null){
			for(People temp : people_list){
				if(!temp.name.equals(manager.name)){
					if(temp.money_paid > money_divided){
						manager.who_to_pay.put(temp.name, temp.money_paid - money_divided);
					}else{
						temp.who_to_pay.put(manager.name, money_divided - temp.money_paid);
					}	
				}			
			}
		}
		System.out.println(manager.name +" should pay:");
		System.out.println(manager.who_to_pay);
		for(People temp : people_list){
			if(!temp.name.equals(manager.name)){
				System.out.println(temp.name +" should pay:");
				System.out.println(temp.who_to_pay);
			}
		}

		return people_list;
	}
	
	
	
	
	public static void main(String[] args){
		AA money_divide = new AA();
		money_divide.people_input();
		money_divide.settlement();
	}
}


