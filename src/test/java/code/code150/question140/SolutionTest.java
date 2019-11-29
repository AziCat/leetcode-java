package code.code150.question140;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void wordBreak() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        for (String an : ans) {
            System.out.println(an);
        }
    }
    @Test
    public void wordBreak4() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.wordBreak("catandog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        for (String an : ans) {
            System.out.println(an);
        }
    }
    @Test
    public void wordBreak1() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        for (String an : ans) {
            System.out.println(an);
        }
    }

    @Test
    public void wordBreak2() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        for (String an : ans) {
            System.out.println(an);
        }
    }

}