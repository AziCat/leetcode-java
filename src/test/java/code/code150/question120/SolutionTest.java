package code.code150.question120;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void minimumTotal() throws Exception {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Assert.assertEquals(11, solution.minimumTotal(triangle));
    }

    @Test
    public void minimumTotal1() throws Exception {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        triangle.add(Arrays.asList(20, 20, 20, 20, 1));
        Assert.assertEquals(17, solution.minimumTotal(triangle));
    }

}