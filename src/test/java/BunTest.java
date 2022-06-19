import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameReturnName() {
        Bun bun = new Bun("test bun", 50);
        String expected = "test bun";
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceReturnPrice() {
        Bun bun = new Bun("test bun", 50);
        int expected = 50;
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }
}
