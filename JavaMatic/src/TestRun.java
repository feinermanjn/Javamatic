import static org.junit.Assert.*;

import org.junit.Test;


public class TestRun {

	@Test
	public void testExample() {
		JavaMatic java=new JavaMatic();
		java.setUp();
		java.run("2");
		Ingredient[] ingredients=java.getIngredients();
		assertEquals(10,ingredients[0].getQuantity());//Cocoa
		assertEquals(10,ingredients[1].getQuantity());//Coffee
		assertEquals(10,ingredients[2].getQuantity());//Cream
		assertEquals(10,ingredients[3].getQuantity());//Decaf Coffee
		assertEquals(8,ingredients[4].getQuantity());//Espresso
		assertEquals(10,ingredients[5].getQuantity());//Foamed Milk
		assertEquals(9,ingredients[6].getQuantity());//Steamed Milk
		assertEquals(10,ingredients[7].getQuantity());//Sugar
		assertEquals(10,ingredients[8].getQuantity());//Whipped Cream
		java.run("Q");
		java.run("R");
		ingredients=java.getIngredients();
		assertEquals(10,ingredients[0].getQuantity());//Cocoa
		assertEquals(10,ingredients[1].getQuantity());//Coffee
		assertEquals(10,ingredients[2].getQuantity());//Cream
		assertEquals(10,ingredients[3].getQuantity());//Decaf Coffee
		assertEquals(8,ingredients[4].getQuantity());//Espresso
		assertEquals(10,ingredients[5].getQuantity());//Foamed Milk
		assertEquals(9,ingredients[6].getQuantity());//Steamed Milk
		assertEquals(10,ingredients[7].getQuantity());//Sugar
		assertEquals(10,ingredients[8].getQuantity());//Whipped Cream
	}
	@Test
	public void testRestock(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		java.run("2");
		java.run("R");
		Ingredient[] ingredients=java.getIngredients();
		for(int i=0;i<ingredients.length;i++){
			assertEquals(10,ingredients[i].getQuantity());
		}
	}
	@Test
	public void testWontDispenseIfOutOfStock(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		for(int i=0;i<5;i++){
			java.run("2");
		}
		Ingredient[] beforeInvalidCommand=java.getIngredients();
		java.run("2");
		Ingredient[] afterInvalidCommand=java.getIngredients();
		for(int i=0;i<afterInvalidCommand.length;i++){
			assertEquals(0,afterInvalidCommand[i].getQuantity()-beforeInvalidCommand[i].getQuantity());
		}
	}
	@Test
	public void testWontDispenseIfWouldBeOutOfStock(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		for(int i=0;i<3;i++){
			java.run("1");
		}
		Ingredient[] beforeInvalidCommand=java.getIngredients();
		java.run("1");
		Ingredient[] afterInvalidCommand=java.getIngredients();
		for(int i=0;i<afterInvalidCommand.length;i++){
			assertEquals(0,afterInvalidCommand[i].getQuantity()-beforeInvalidCommand[i].getQuantity());
		}
	}
	@Test
	public void testInvalidCommands(){
		JavaMatic java=new JavaMatic();
		java.setUp();
		java.run("qwerty");
		Ingredient[] ingredients=java.getIngredients();
		for(int i=0;i<ingredients.length;i++){
			assertEquals(10,ingredients[i].getQuantity());
		}
		java.run("0");
		ingredients=java.getIngredients();
		for(int i=0;i<ingredients.length;i++){
			assertEquals(10,ingredients[i].getQuantity());
		}
		java.run("100");
		ingredients=java.getIngredients();
		for(int i=0;i<ingredients.length;i++){
			assertEquals(10,ingredients[i].getQuantity());
		}
	}
}
