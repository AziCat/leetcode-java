package code.code400.question386;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lexicalOrder() {
        Solution solution = new Solution();
        List<Integer> ans = solution.lexicalOrder(22);
        Assert.assertEquals("[1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 3, 4, 5, 6, 7, 8, 9]",ans.toString());
    }
}