package code.code400.question352;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SummaryRangesTest {
    @Test
    public void test() throws Exception {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] add = {6, 6, 0, 4, 8, 7, 6, 4, 7, 5};
        for (int i : add) {
            summaryRanges.addNum(i);
            print(summaryRanges.getIntervals());
        }
    }

    private void print(int[][] nums) {
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
        System.out.println("-----------");
    }
}