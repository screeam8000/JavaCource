import calc.Addition;
import calc.Division;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdditon (){
        Addition addition = new Addition(4, 5);
//        Assert.assertEquals(5  addition.calculateResult(), 0);
    }

    @Test
    public void testDivision(){
        Division division = new Division(4, 5);
//        Assert.assertEquals(1, division.);

    }

}
