package code.code2000.question1996;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testNumberOfWeakCharacters() {
        Solution solution = new Solution();
        int ans = solution.numberOfWeakCharacters(new int[][]{
                {5, 5},
                {6, 3},
                {3, 6},
        });
        Assert.assertEquals(0, ans);
        ans = solution.numberOfWeakCharacters(new int[][]{
                {2, 2},
                {3, 3},
        });
        Assert.assertEquals(1, ans);
        ans = solution.numberOfWeakCharacters(new int[][]{
                {1, 5},
                {10, 4},
                {4, 3},
        });
        Assert.assertEquals(1, ans);
        ans = solution.numberOfWeakCharacters(new int[][]{
                {1, 1},
                {2, 1},
                {2, 2},
                {1, 2},
        });
        Assert.assertEquals(1, ans);

    }
}