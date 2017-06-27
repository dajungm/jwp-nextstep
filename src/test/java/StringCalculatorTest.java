import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by dajung.mun on 2017. 6. 27..
 */
public class StringCalculatorTest {
    StringCalculator calculator;

    @Before
    public void before() {
        calculator = new StringCalculator();
    }

    @Test
    public void 쉼표또는콜론구분자() {
        assertThat(calculator.add("1,2:3"), is(6));
    }

    @Test
    public void 커스텀구분자() {
        assertThat(calculator.add("//;\n1;2;3"), is(6));
    }

    @Test(expected = RuntimeException.class)
    public void 음수() {
        calculator.add("-1,9,2");
    }
}