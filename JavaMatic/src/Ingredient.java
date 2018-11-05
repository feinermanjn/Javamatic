public class Ingredient{
	String name;
	int quantity;
	double cost;
	public Ingredient(String name, double cost){
		this.name=name;
		this.cost=cost;
		this.quantity=10;
	}
	//Getters
	public String getName(){
		return name;
	}
	public int getQuantity(){
		return quantity;
	}
	public double getCost(){
		return cost;
	}
	/**
	 * 
	 * @param n
	 * @return true if there are at least n units of the ingredient in stock,
	 * meaning that the drink it is a part of can be dispensed
	 */
	public boolean canDispense(int n){
		return quantity>=n;
	}
	/**
	 * Updates quantity, subtracting the number of units used from the remaining units in stock
	 * @param n
	 */
	public void use(int n){
		quantity-=n;
	}
	/**
	 * Restocks the ingredient to 10 units
	 */
	public void restock(){
		quantity=10;
	}
}