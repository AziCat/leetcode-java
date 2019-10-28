package code.code100.question091;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void numDecodings() {
        Solution solution = new Solution();
        Assert.assertEquals(0,solution.numDecodings("") );
    }
    @Test
    public void numDecodings111() {
        Solution solution = new Solution();
        Assert.assertEquals(1,solution.numDecodings("10") );
    }
    @Test
    public void numDecodings12111() {
        Solution solution = new Solution();
        Assert.assertEquals(1,solution.numDecodings("101") );
    }
    @Test
    public void numDecodings121141() {
        Solution solution = new Solution();
        Assert.assertEquals(1,solution.numDecodings("101010207") );
    }
    @Test
    public void numDecodings1111() {
        Solution solution = new Solution();
        Assert.assertEquals(2,solution.numDecodings("11") );
    }
    @Test
    public void numDecodings1() {
        Solution solution = new Solution();
        Assert.assertEquals(1,solution.numDecodings("1") );
    }
    @Test
    public void numDecodings12() {
        Solution solution = new Solution();
        Assert.assertEquals(0,solution.numDecodings("01") );
    }
    @Test
    public void numDecodings11() {
        Solution solution = new Solution();
        Assert.assertEquals(1,solution.numDecodings("110") );
    }
    @Test
    public void numDecodings1211() {
        Solution solution = new Solution();
        Assert.assertEquals(3,solution.numDecodings("111") );
    }
    @Test
    public void numDecodings1214() {
        Solution solution = new Solution();
        Assert.assertEquals(0,solution.numDecodings("1130") );
    }
    @Test
    public void numDecodings121() {
        Solution solution = new Solution();
        Assert.assertEquals(2,solution.numDecodings("1110") );
    }
    @Test
    public void numDecodings3() {
        Solution solution = new Solution();
        Assert.assertEquals(3,solution.numDecodings("226") );
    }
    @Test
    public void numDecodings123() {
        Solution solution = new Solution();
        Assert.assertEquals(5,solution.numDecodings("2211") );
    }
}