package code.code500.question486;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void predictTheWinner() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.PredictTheWinner(new int[]{9, 1, 5, 200, 7}));
    }
}