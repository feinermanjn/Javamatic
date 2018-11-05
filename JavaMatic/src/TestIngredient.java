import static org.junit.Assert.*;

import org.junit.Test;


public class TestIngredient {

	@Test
	public void testCorrectSetUp() {
		JavaMatic java=new JavaMatic();
		java.setUp();
		Ingredient[] ingredients=java.getIngredients();
		assertEquals("Cocoa",ingredients[0].getName());
		assertEquals("Coffee",ingredients[1].getName());
		assertEquals("Cream",ingredients[2].getName());
		assertEquals("Decaf Coffee",ingredients[3].getName());
		assertEquals("Espresso",ingredients[4].getName());
		assertEquals("Foamed Milk",ingredients[5].getName());
		assertEquals("Steamed Milk",ingredients[6].getName());
		assertEquals("Sugar",ingredients[7].getName());
		assertEquals("Whipped Cream",ingredients[8].getName());
		assertEquals("0.90",String.format("%.2f", ingredients[0].getCost()));
		assertEquals("0.75",String.format("%.2f", ingredients[1].getCost()));
		assertEquals("0.25",String.format("%.2f", ingredients[2].getCost()));
		assertEquals("0.75",String.format("%.2f", ingredients[3].getCost()));
		assertEquals("1.10",String.format("%.2f", ingredients[4].getCost()));
		assertEquals("0.35",String.format("%.2f", ingredients[5].getCost()));
		assertEquals("0.35",String.format("%.2f", ingredients[6].getCost()));
		assertEquals("0.25",String.format("%.2f", ingredients[7].getCost()));
		assertEquals("1.00",String.format("%.2f", ingredients[8].getCost()));
		for(int i=0;i<ingredients.length;i++){
			assertEquals(10,ingredients[i].getQuantity());
		}
	}
	@Test
	public void testUse(){
		Ingredient ingredient=new Ingredient("Coffee",0.75);
		ingredient.use(1);
		assertEquals(9,ingredient.getQuantity());
	}
	@Test
	public void testRestock(){
		Ingredient ingredient=new Ingredient("Coffee",0.75);
		ingredient.use(1);
		ingredient.restock();
		assertEquals(10,ingredient.getQuantity());
	}
	@Test
	public void testCanDispense(){
		Ingredient ingredient=new Ingredient("Coffee",0.75);
		for(int i=0;i<3;i++){
			ingredient.use(3);
		}
		assertFalse(ingredient.canDispense(3));
	}
}
