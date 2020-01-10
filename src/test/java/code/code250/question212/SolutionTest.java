package code.code250.question212;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findWords() throws Exception {
        Solution1 solution = new Solution1();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain", "aa"};
        List<String> ans = solution.findWords(board, words);
        Assert.assertEquals("[oath, aa, eat]", ans.toString());
    }

    @Test
    public void findWords1() throws Exception {
        Solution1 solution = new Solution1();
        char[][] board = {
                {'a', 'b'},
                {'a', 'a'},
        };
        String[] words = {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        List<String> ans = solution.findWords(board, words);
        Assert.assertEquals("[aba, aaa, aaab, baa, aaba]", ans.toString());
    }

}