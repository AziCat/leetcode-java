package code.code150.question118;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void generate() throws Exception {
        Solution solution =new Solution();
        List<List<Integer>> ans = solution.generate(5);
        for (List<Integer> an : ans) {
            System.out.println(an.toString());
        }
    }

}