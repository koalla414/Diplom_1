import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;

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

//    @Test


}
