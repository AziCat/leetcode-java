package code.code50.question017;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void letterCombinations() {
        List<String> lists = solution.letterCombinations("233");
        System.out.println(lists.size());
    }
}