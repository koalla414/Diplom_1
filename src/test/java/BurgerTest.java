import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

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


}
