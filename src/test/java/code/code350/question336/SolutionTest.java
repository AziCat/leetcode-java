package code.code350.question336;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void palindromePairs() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }

    @Test
    public void palindromePairs1() {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll","aba",""});
        for (List<Integer> an : ans) {
            System.out.println(an);
        }
    }
}