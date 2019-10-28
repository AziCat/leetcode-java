package code.code50.question049;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void groupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "", ""};
        List<List<String>> ans = solution.groupAnagrams(strs);
        System.out.println(ans.toString());
    }
}