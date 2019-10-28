package code.code50.question012;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void intToRoman() {
        Assert.assertEquals("III", solution.intToRoman(3));
    }
    @Test
    public void intToRoman1() {
        Assert.assertEquals("IV", solution.intToRoman(4));
    }
    @Test
    public void intToRoman2() {
        Assert.assertEquals("IX", solution.intToRoman(9));
    }
    @Test
    public void intToRoman3() {
        Assert.assertEquals("LVIII", solution.intToRoman(58));
    }
    @Test
    public void intToRoman4() {
        Assert.assertEquals("MCMXCIV", solution.intToRoman(1994));
    }
}