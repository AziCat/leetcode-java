package code.code50.question006;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void convert4() {
        String str = solution.convert("LEETCODEISHIRING", 1);
        Assert.assertEquals("LEETCODEISHIRING", str);
    }
    @Test
    public void convert3() {
        String str = solution.convert("LEETCODEISHIRING", 2);
        Assert.assertEquals("LECDIHRNETOESIIG", str);
    }
    @Test
    public void convert1() {
        String str = solution.convert("LEETCODEISHIRING", 3);
        Assert.assertEquals("LCIRETOESIIGEDHN", str);
    }

    @Test
    public void convert2() {
        String str = solution.convert("LEETCODEISHIRING", 4);
        Assert.assertEquals("LDREOEIIECIHNTSG", str);
    }

    @Test
    public void convert5() {
        String str = solution.convert("LEETCODEISHIRING", 5);
        Assert.assertEquals("LIEESGEDHNTOIICR", str);
    }

    @Test
    public void convert6() {
        String str = solution.convert("LEETCODEISHIRING", 6);
        Assert.assertEquals("LHESIEIRTEICDNOG", str);
    }

    @Test
    public void convert7() {
        String str = solution.convert("LEET", 6);
        Assert.assertEquals("LEET", str);
    }
}