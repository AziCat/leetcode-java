package code.code100.question059;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void generateMatrix() {
        Solution solution  = new Solution();
        int[][] ans = solution.generateMatrix(4);
        for (int i = 0; i < ans.length; i++) {
            for (int i1 = 0; i1 < ans[i].length; i1++) {
                System.out.print(ans[i][i1]+" ");
            }
            System.out.println();
        }
    }
}