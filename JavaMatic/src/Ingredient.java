public class Ingredient{
	String name;
	int quantity;
	double cost;
	public Ingredient(String name, double cost){
		this.name=name;
		this.cost=cost;
		this.quantity=10;
	}
	public String getName(){
		return name;
	}
	public int getQuantity(){
		return quantity;
	}
	public double getCost(){
		return cost;
	}
	public boolean canDispense(int n){
		return quantity>=n;
	}
	public void use(int n){
		quantity-=n;
	}
	public void restock(){
		quantity=10;
	}
}