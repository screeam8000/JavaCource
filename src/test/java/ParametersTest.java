package calc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametersTest {


    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {0,0,0}, {1,2,3}
        });

    }
        @Parameterized.Parameter
         public double number1;
    @Parameterized.Parameter(1)
         public double number2;
    @Parameterized.Parameter(2)
         public double result;

    @Test
    public void testMethod(){
        Assert.assertEquals(result, new Addition(number1, number2).calculateResalt(), 0.0);


    }


}
