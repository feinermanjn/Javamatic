import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestDrink {

	@Test
	public void testCorrectIngredients() {
		JavaMatic java=new JavaMatic();
		java.setUp();
		ArrayList<Drink> drinks=java.getDrinks();
		Ingredient[] ingredients=java.getIngredients();
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[0]));//0 Cocoa in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[1]));//0 Coffee in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[2]));//0 Cream in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[3]));//0 Decaf Coffee in Caffe Americano
		assertEquals(3,drinks.get(0).getMenuQuantity(ingredients[4]));//3 Espresso in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[5]));//0 Foamed Milk in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[6]));//0 Steamed Milk in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[7]));//0 Sugar in Caffe Americano
		assertEquals(0,drinks.get(0).getMenuQuantity(ingredients[8]));//0 Whipped Cream in Caffe Americano
		
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[0]));//0 Cocoa in Caffe Latte
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[1]));//0 Coffee in Caffe Latte
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[2]));//0 Cream in Caffe Latte
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[3]));//0 Decaf Coffee in Caffe Latte
		assertEquals(2,drinks.get(1).getMenuQuantity(ingredients[4]));//2 Espresso in Caffe Latte
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[5]));//0 Foamed Milk in Caffe Latte
		assertEquals(1,drinks.get(1).getMenuQuantity(ingredients[6]));//1 Steamed Milk in Caffe Latte
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[7]));//0 Sugar in Caffe Latte
		assertEquals(0,drinks.get(1).getMenuQuantity(ingredients[8]));//0 Whipped Cream in Caffe Latte

		assertEquals(1,drinks.get(2).getMenuQuantity(ingredients[0]));//1 Cocoa in Caffe Mocha
		assertEquals(0,drinks.get(2).getMenuQuantity(ingredients[1]));//0 Coffee in Caffe Mocha
		assertEquals(0,drinks.get(2).getMenuQuantity(ingredients[2]));//0 Cream in Caffe Mocha
		assertEquals(0,drinks.get(2).getMenuQuantity(ingredients[3]));//0 Decaf Coffee in Caffe Mocha
		assertEquals(1,drinks.get(2).getMenuQuantity(ingredients[4]));//1 Espresso in Caffe Mocha
		assertEquals(0,drinks.get(2).getMenuQuantity(ingredients[5]));//0 Foamed Milk in Caffe Mocha
		assertEquals(1,drinks.get(2).getMenuQuantity(ingredients[6]));//1 Steamed Milk in Caffe Mocha
		assertEquals(0,drinks.get(2).getMenuQuantity(ingredients[7]));//0 Sugar in Caffe Mocha
		assertEquals(1,drinks.get(2).getMenuQuantity(ingredients[8]));//1 Whipped Cream in Caffe Mocha

		assertEquals(0,drinks.get(3).getMenuQuantity(ingredients[0]));//0 Cocoa in Cappuccino
		assertEquals(0,drinks.get(3).getMenuQuantity(ingredients[1]));//0 Coffee in Cappuccino
		assertEquals(0,drinks.get(3).getMenuQuantity(ingredients[2]));//0 Cream in Cappuccino
		assertEquals(0,drinks.get(3).getMenuQuantity(ingredients[3]));//0 Decaf Coffee in Cappuccino
		assertEquals(2,drinks.get(3).getMenuQuantity(ingredients[4]));//2 Espresso in Cappuccino
		assertEquals(1,drinks.get(3).getMenuQuantity(ingredients[5]));//1 Foamed Milk in Cappuccino
		assertEquals(1,drinks.get(3).getMenuQuantity(ingredients[6]));//1 Steamed Milk in Cappuccino
		assertEquals(0,drinks.get(3).getMenuQuantity(ingredients[7]));//0 Sugar in Cappuccino
		assertEquals(0,drinks.get(3).getMenuQuantity(ingredients[8]));//0 Whipped Cream in Cappuccino
		
		assertEquals(0,drinks.get(4).getMenuQuantity(ingredients[0]));//0 Cocoa in Coffee
		assertEquals(3,drinks.get(4).getMenuQuantity(ingredients[1]));//3 Coffee in Coffee
		assertEquals(1,drinks.get(4).getMenuQuantity(ingredients[2]));//1 Cream in Coffee
		assertEquals(0,drinks.get(4).getMenuQuantity(ingredients[3]));//0 Decaf Coffee in Coffee
		assertEquals(0,drinks.get(4).getMenuQuantity(ingredients[4]));//0 Espresso in Coffee
		assertEquals(0,drinks.get(4).getMenuQuantity(ingredients[5]));//0 Foamed Milk in Coffee
		assertEquals(0,drinks.get(4).getMenuQuantity(ingredients[6]));//0 Steamed Milk in Coffee
		assertEquals(1,drinks.get(4).getMenuQuantity(ingredients[7]));//1 Sugar in Coffee
		assertEquals(0,drinks.get(4).getMenuQuantity(ingredients[8]));//0 Whipped Cream in Coffee
		
		assertEquals(0,drinks.get(5).getMenuQuantity(ingredients[0]));//0 Cocoa in Decaf Coffee
		assertEquals(0,drinks.get(5).getMenuQuantity(ingredients[1]));//0 Coffee in Decaf Coffee
		assertEquals(1,drinks.get(5).getMenuQuantity(ingredients[2]));//1 Cream in Decaf Coffee
		assertEquals(3,drinks.get(5).getMenuQuantity(ingredients[3]));//3 Decaf Coffee in Decaf Coffee
		assertEquals(0,drinks.get(5).getMenuQuantity(ingredients[4]));//0 Espresso in Decaf Coffee
		assertEquals(0,drinks.get(5).getMenuQuantity(ingredients[5]));//0 Foamed Milk in Decaf Coffee
		assertEquals(0,drinks.get(5).getMenuQuantity(ingredients[6]));//0 Steamed Milk in Decaf Coffee
		assertEquals(1,drinks.get(5).getMenuQuantity(ingredients[7]));//1 Sugar in Decaf Coffee
		assertEquals(0,drinks.get(5).getMenuQuantity(ingredients[8]));//0 Whipped Cream in Decaf Coffee
		
		
	}
	@Test
	public void testCorrectNames(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		ArrayList<Drink> drinks=java.getDrinks();
		assertEquals("Caffe Americano",drinks.get(0).getName());
		assertEquals("Caffe Latte",drinks.get(1).getName());
		assertEquals("Caffe Mocha",drinks.get(2).getName());
		assertEquals("Cappuccino",drinks.get(3).getName());
		assertEquals("Coffee",drinks.get(4).getName());
		assertEquals("Decaf Coffee",drinks.get(5).getName());
	}
	@Test
	public void testCorrectPrices(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		ArrayList<Drink> drinks=java.getDrinks();
		assertEquals("3.30",drinks.get(0).getPrice());
		assertEquals("2.55",drinks.get(1).getPrice());
		assertEquals("3.35",drinks.get(2).getPrice());
		assertEquals("2.90",drinks.get(3).getPrice());
		assertEquals("2.75",drinks.get(4).getPrice());
		assertEquals("2.75",drinks.get(5).getPrice());
	}
	@Test
	public void testDispense(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		Ingredient espresso=java.getIngredients()[4];
		Drink caffeAmericano=java.getDrinks().get(0);
		caffeAmericano.dispense();
		assertEquals(7,espresso.getQuantity());
	}
}
