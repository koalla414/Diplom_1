import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    private final String type;
    private final boolean expected;

    public IngredientTypeParameterizedTest(String type, boolean expected) {
        this.type = type;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{0} содержится в списке ингредиентов? - {1}")
    public static Object[][] checkTypesInIngredientType() {
        return new Object[][] {
                {"SAUCE", true},
                {"FILLING", true},
        };
    }

    @Test
    public void IngredientTypeContainsTypes() {

        String actual = IngredientType.valueOf(type).toString();
        Assert.assertEquals(type, actual);
    }

}
