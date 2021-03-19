package code.code250.question224;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testCalculate() {
        Solution solution = new Solution();
        int i = solution.calculate("(02147483647)");
        System.out.println(i);
    }
}