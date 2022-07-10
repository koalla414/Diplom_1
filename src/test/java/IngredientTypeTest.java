import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void IngredientTypeContainsTwo() {
        int expected = 2;
        int actual = 0;
        for (IngredientType types: IngredientType.values()) {
            actual = types.ordinal() + 1;
        }
        Assert.assertEquals(expected, actual);
    }



}