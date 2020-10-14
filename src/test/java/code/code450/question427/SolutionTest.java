package code.code450.question427;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void construct() {
        Solution solution = new Solution();
        solution.construct(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}});
    }
}