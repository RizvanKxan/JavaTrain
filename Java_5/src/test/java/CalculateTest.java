import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculateTest {
    @Test
    public void test() {
        Calculate calculate = new Calculate();
        assertEquals(25, calculate.figureAreaTriangle(10,5), 0.1);
        assertEquals(50, calculate.figureAreaRectangle(10,5), 0.1);
        assertEquals(100, calculate.figureAreaSquare(10), 0.1);
        assertEquals(50, calculate.figureAreaRhombus(10, 5), 0.1);
        assertEquals(25, calculate.convertUSDToRUB(10), 0.1);
        assertEquals(29.1, calculate.convertEUROToRUB(10), 0.1);
        assertEquals(0.22, calculate.convertJPYToRUB(10), 0.1);
        assertEquals(34.8, calculate.convertGBPToRUB(10), 0.1);
        assertEquals(true, calculate.isPalindrome("fasdsaf"));
        assertEquals(2, calculate.countEntry("asadfasas", "asa"));

    }
}
