import java.util.ArrayList;
import java.util.Scanner;

public class JavaMatic{
	static Ingredient[] ingredients;
	static ArrayList<Drink> drinks;
	static boolean quit;
	public static void main(String[] args){
		setUp();
		quit=false;
		Scanner scan=new Scanner(System.in);
		printInventory();
		printMenu();
		while(!quit){
			String input=scan.nextLine();
			run(input);
		}
	}
	public static void setUp(){
		ingredients=new Ingredient[9];
		drinks=new ArrayList<Drink>();
		Ingredient cocoa=new Ingredient("Cocoa",0.9);
		Ingredient coffee=new Ingredient("Coffee",0.75);
		Ingredient cream=new Ingredient("Cream",0.25);
		Ingredient decaf=new Ingredient("Decaf Coffee",0.75);
		Ingredient espresso=new Ingredient("Espresso",1.1);
		Ingredient foamed=new Ingredient("Foamed Milk",0.35);
		Ingredient steamed=new Ingredient("Steamed Milk",0.35);
		Ingredient sugar=new Ingredient("Sugar",0.25);
		Ingredient whipped=new Ingredient("Whipped Cream",1);
		Drink americano=new Drink("Caffe Americano");
		americano.addToMap(espresso, 3);
		drinks.add(americano);
		Drink latte=new Drink("Caffe Latte");
		latte.addToMap(espresso, 2);
		latte.addToMap(steamed,1);
		drinks.add(latte);
		Drink mocha=new Drink("Caffe Mocha");
		mocha.addToMap(espresso, 1);
		mocha.addToMap(cocoa,1);
		mocha.addToMap(steamed, 1);
		mocha.addToMap(whipped, 1);
		drinks.add(mocha);
		Drink cappuccino=new Drink("Cappuccino");
		cappuccino.addToMap(espresso, 2);
		cappuccino.addToMap(steamed,1);
		cappuccino.addToMap(foamed, 1);
		drinks.add(cappuccino);
		Drink coffeeDrink=new Drink("Coffee");
		coffeeDrink.addToMap(coffee, 3);
		coffeeDrink.addToMap(sugar, 1);
		coffeeDrink.addToMap(cream, 1);
		drinks.add(coffeeDrink);
		Drink decafDrink=new Drink("Decaf Coffee");
		decafDrink.addToMap(decaf, 3);
		decafDrink.addToMap(sugar, 1);
		decafDrink.addToMap(cream, 1);
		drinks.add(decafDrink);
		ingredients[0]=cocoa;
		ingredients[1]=coffee;
		ingredients[2]=cream;
		ingredients[3]=decaf;
		ingredients[4]=espresso;
		ingredients[5]=foamed;
		ingredients[6]=steamed;
		ingredients[7]=sugar;
		ingredients[8]=whipped;
	}
	public static void run(String input){
		if(!quit){
			if(input.toLowerCase().equals("r")){
				for(Ingredient ingr: ingredients){
					ingr.restock();
				}
				printMenu();
			}
			else if(input.toLowerCase().equals("q"))
				quit=true;
			else if((input.chars().allMatch(Character::isDigit))&&Integer.parseInt(input)>0&&Integer.parseInt(input)<=drinks.size()){
				Drink chosen=drinks.get(Integer.parseInt(input)-1);
				if(chosen.isInStock()){
					System.out.println("Dispensing:"+chosen.getName());
					chosen.dispense();
					printInventory();
					printMenu();
				}
				else
					System.out.println("Out of Stock: "+chosen.getName());
			}
			else{
				System.out.println("Invalid Selection: "+input);
			}
		}
	}
	public static void printInventory(){
		System.out.println("Inventory:");
		for(int i=0;i<ingredients.length;i++){
			System.out.println(ingredients[i].getName()+","+ingredients[i].getQuantity());
		}
	}
	public static void printMenu(){
		System.out.println("Menu:");
		for(int i=0;i<drinks.size();i++){
			int number=i+1;
			String name=drinks.get(i).getName();
			String price=drinks.get(i).getPrice();
			boolean inStock=true;
			for(Ingredient ingr:ingredients){
				if(ingr.getQuantity()<drinks.get(i).getMenuQuantity(ingr))
					inStock=false;
			}
			System.out.println(number+","+name+",$"+price+","+inStock);
			drinks.get(i).setInStock(inStock);
		}
	}
	public Ingredient[] getIngredients(){
		return ingredients;
	}
	public ArrayList<Drink> getDrinks(){
		return drinks;
	}
}