import java.util.HashMap;
import java.util.Map.Entry;

public class Drink{
	String name;
	double price;
	HashMap<Ingredient,Integer> ingredients;
	boolean inStock;
	public Drink(String name){
		this.name=name;
		ingredients=new HashMap<Ingredient,Integer>();
		price=0;
		inStock=true;
	}
	//Getters
	public String getName(){
		return name;
	}
	/**
	 * 
	 * @return price of drink. We never actually need to do anything with this besides printing it,
	 * so it is acceptable for it to be returned in a string
	 */
	public String getPrice(){
		return String.format("%.2f", price);
	}
	/**
	 * 
	 * @param ingr
	 * @return quantities needed for given ingredient
	 * Will return 0 if ingredient is not needed for the drink
	 */
	public int getMenuQuantity(Ingredient ingr){
		if(ingredients.containsKey(ingr))
			return ingredients.get(ingr);
		return 0;
	}
	/**
	 * Updates each ingredient needed for the drink
	 * Subtracts the quantity used from the remaining quantity in stock
	 */
	public void dispense(){
		for(Entry<Ingredient, Integer> entry : ingredients.entrySet()){
			entry.getKey().use(entry.getValue());
		}
	}
	public boolean isInStock(){
		return inStock;
	}
	/**
	 * Puts a given ingredient, along with the number of units needed to make it into the hash map
	 * Updates price
	 * @param ingr
	 * @param num
	 */
	public void addToMap(Ingredient ingr, int num){
		ingredients.put(ingr, num);
		price+=ingr.getCost()*num;
	}
	public void setInStock(boolean bool){
		inStock=bool;
	}
}