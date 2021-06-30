package code.code2000.question1985;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest extends TestCase {
    @Test
    public void testPermutation() {
        Solution solution = new Solution();
        String[] ans = solution.permutation("abca");
        System.out.println(Arrays.asList(ans).toString());
    }
}