package code.code1100.question1095;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    class MyMountainArray implements Solution.MountainArray {
        public int[] nums;

        public MyMountainArray(int[] nums) {
            this.nums = nums;
        }

        @Override
        public int get(int index) {
            return nums[index];
        }

        @Override
        public int length() {
            return nums.length;
        }
    }

    @Test
    public void findInMountainArray() {
        MyMountainArray mountainArray = new MyMountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        Solution solution = new Solution();
        Assert.assertEquals(2, solution.findInMountainArray(3, mountainArray));
    }

    @Test
    public void findInMountainArray1() {
        MyMountainArray mountainArray = new MyMountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        Solution solution = new Solution();
        Assert.assertEquals(4, solution.findInMountainArray(5, mountainArray));
    }

    @Test
    public void findInMountainArray2() {
        MyMountainArray mountainArray = new MyMountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        Solution solution = new Solution();
        Assert.assertEquals(-1, solution.findInMountainArray(0, mountainArray));
    }
    @Test
    public void findInMountainArray3() {
        MyMountainArray mountainArray = new MyMountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        Solution solution = new Solution();
        Assert.assertEquals(0, solution.findInMountainArray(1, mountainArray));
    }
    @Test
    public void findInMountainArray4() {
        MyMountainArray mountainArray = new MyMountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        Solution solution = new Solution();
        Assert.assertEquals(3, solution.findInMountainArray(4, mountainArray));
    }
}