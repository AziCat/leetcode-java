package code.code450.question443;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testCompress() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    public void testCompress1() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.compress(new char[]{'a','b', 'c'}));
    }

    public void testCompress2() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.compress(new char[]{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'}));
    }
}