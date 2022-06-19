import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BurgerTest {

//    Замоккать этот тест?
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

}