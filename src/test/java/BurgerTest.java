import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void setBunsIsBun() {
        Burger burger = new Burger();
        Bun testBun = new Bun("test bun", 50);
        Bun expected = testBun;
        burger.setBuns(testBun);
        Bun actual = burger.bun;
        assertEquals(expected, actual);
    }

    @Test
    public void choosingSevelalBunsIsSetPastBun() {
        Burger burger = new Burger();
        Bun testBun1 = new Bun("test bun 1", 30);
        Bun testBun2 = new Bun("test bun 2", 50);
        Bun testBun3 = new Bun("test bun 3", 20);
        Bun expected = testBun3;
        burger.setBuns(testBun1);
        burger.setBuns(testBun2);
        burger.setBuns(testBun3);
        Bun actual = burger.bun;
        assertEquals(expected, actual);
    }

    @Test
    public void addIngredientIsAdded() {
        Burger burger = new Burger();
        Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "test sauce", 50);
        Ingredient expected = testIngredient;
        burger.addIngredient(testIngredient);
        Ingredient actual = burger.ingredients.get(burger.ingredients.size() - 1);
        assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientIsRemoved() {
        Burger burger = new Burger();
        Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "test sauce", 50);
        Ingredient testIngredient2 = new Ingredient(IngredientType.FILLING, "test filling", 50);
        Ingredient expected = testIngredient2;
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient2);
        burger.removeIngredient(burger.ingredients.size() - 1);
        Ingredient actual = burger.ingredients.get(burger.ingredients.size() - 1);
        assertNotEquals(expected, actual);
    }

    @Test
    public void moveIngredientIsMoved() {
        Burger burger = new Burger();
        Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "test sauce", 50);
        Ingredient testIngredient2 = new Ingredient(IngredientType.FILLING, "test filling", 50);
        Ingredient expected = testIngredient2;
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient2);
        burger.moveIngredient((burger.ingredients.size() - 1), (burger.ingredients.size() - 2));
        Ingredient actual = burger.ingredients.get(burger.ingredients.size() - 2);
        assertEquals(expected, actual);
    }

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient;

    @Test
    public void getPriceIsPrice() {
        Burger burger = new Burger();

        Mockito.when(mockBun.getPrice()).thenReturn(Float.valueOf(50));
        burger.setBuns(mockBun);

        Mockito.when(mockIngredient.getPrice()).thenReturn(Float.valueOf(30));
        burger.addIngredient(mockIngredient);

        float actual = burger.getPrice();
        assertEquals(130, actual, 0);
    }

    @Test
    public void getReceiptIsReceipt() {
        Burger burger = new Burger();
        Bun testBun = new Bun("test bun", 50);
        Ingredient testIngredient = new Ingredient(IngredientType.SAUCE, "test sauce", 30);
        Ingredient testIngredient2 = new Ingredient(IngredientType.FILLING, "test filling", 40);
        burger.setBuns(testBun);
        burger.addIngredient(testIngredient);
        burger.addIngredient(testIngredient2);

        String expected = "(==== test bun ====)\r\n" +
                "= sauce test sauce =\r\n" +
                "= filling test filling =\r\n" +
                "(==== test bun ====)\r\n" +
                "\r\n" +
                "Price: 170,000000\r\n";
        String actual = burger.getReceipt();
        assertEquals(expected, actual);
    }

}