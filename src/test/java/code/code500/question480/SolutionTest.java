package code.code500.question480;

import junit.framework.TestCase;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionTest extends TestCase {

    public void testMedianSlidingWindow() {

        Solution solution = new Solution();
        double [] result = solution.medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648},2);
    }

}