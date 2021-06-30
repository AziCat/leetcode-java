package code.code450.question401;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest extends TestCase {
    @Test
    public void testReadBinaryWatch() {
        Solution solution = new Solution();
        List<String> ans = solution.readBinaryWatch(1);
        Assert.assertEquals("[0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]", ans.toString());
        System.out.println(ans);
    }

    @Test
    public void testReadBinaryWatch1() {
        Solution solution = new Solution();
        List<String> ans = solution.readBinaryWatch(8);
        Assert.assertEquals("[7:31, 11:31, 7:47, 11:47, 7:55, 11:55, 7:59, 11:59]", ans.toString());
        System.out.println(ans);
    }
}