import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void getPriceReturnPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test sauce", 50);
        float expected = 50;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual,0);
    }

    @Test
    public void getNameReturnName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test sauce", 50);
        String expected = "test sauce";
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTypeReturnType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test sauce", 50);
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        Assert.assertEquals(expected, actual);
    }

}