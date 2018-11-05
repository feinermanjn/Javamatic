import java.text.DecimalFormat;
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
	public String getName(){
		return name;
	}
	public String getPrice(){
		return String.format("%.2f", price);
	}
	public int getMenuQuantity(Ingredient ingr){
		if(ingredients.containsKey(ingr))
			return ingredients.get(ingr);
		return 0;
	}
	public void dispense(){
		for(Entry<Ingredient, Integer> entry : ingredients.entrySet()){
			entry.getKey().use(entry.getValue());
		}
	}
	public boolean isInStock(){
		return inStock;
	}
	public void addToMap(Ingredient ingr, int num){
		ingredients.put(ingr, num);
		price+=ingr.getCost()*num;
	}
	public void setInStock(boolean bool){
		inStock=bool;
	}
}