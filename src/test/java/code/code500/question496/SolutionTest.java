package code.code500.question496;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testNextGreaterElement() {
        Solution solution = new Solution();
        int[] ans = solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(ans);
    }
}