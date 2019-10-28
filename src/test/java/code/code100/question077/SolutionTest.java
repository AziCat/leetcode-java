package code.code100.question077;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void combine() {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combine(4, 2);
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void combine1() {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combine(4, 3);
        Assert.assertEquals(4, list.size());
    }
}