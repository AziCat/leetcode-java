package code.code250.question216;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void combinationSum3() throws Exception {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.combinationSum3(7, 40);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

}