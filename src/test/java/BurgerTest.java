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
    @Mock
    Bun mockBun;
    @Mock
    Bun mockBun1;
    @Mock
    Bun mockBun2;
    @Mock
    Ingredient mockIngredient;
    @Mock
    Ingredient mockIngredient1;

    @Test
    public void setBunsIsBun() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        Bun expected = mockBun;
        Bun actual = burger.bun;
        assertEquals(expected, actual);
    }

    @Test
    public void choosingSeveralBunsIsSetPastBun() {
        Burger burger = new Burger();
        Bun expected = mockBun2;
        burger.setBuns(mockBun);
        burger.setBuns(mockBun1);
        burger.setBuns(mockBun2);
        Bun actual = burger.bun;
        assertEquals(expected, actual);
    }

    @Test
    public void addIngredientIsAdded() {
        Burger burger = new Burger();
        Ingredient expected = mockIngredient;
        burger.addIngredient(mockIngredient);
        Ingredient actual = burger.ingredients.get(burger.ingredients.size() - 1);
        assertEquals(expected, actual);
}

    @Test
    public void removeIngredientIsRemoved() {
        Burger burger = new Burger();
        Ingredient expected = mockIngredient1;
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(burger.ingredients.size() - 1);
        Ingredient actual = burger.ingredients.get(burger.ingredients.size() - 1);
        assertNotEquals(expected, actual);
    }

    @Test
    public void moveIngredientIsMoved() {
        Burger burger = new Burger();
        Ingredient expected = mockIngredient1;
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient1);
        burger.moveIngredient((burger.ingredients.size() - 1), (burger.ingredients.size() - 2));
        Ingredient actual = burger.ingredients.get(burger.ingredients.size() - 2);
        assertEquals(expected, actual);
    }

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
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient1);
        Mockito.when(mockBun.getPrice()).thenReturn(Float.valueOf(50));
        Mockito.when(mockBun.getName()).thenReturn("test bun");
        Mockito.when(mockIngredient.getPrice()).thenReturn(Float.valueOf(30));
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));
        Mockito.when(mockIngredient.getName()).thenReturn("test sauce");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(Float.valueOf(40));
        Mockito.when(mockIngredient1.getType()).thenReturn(IngredientType.valueOf("FILLING"));
        Mockito.when(mockIngredient1.getName()).thenReturn(String.format("test filling"));
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