package code.code100.question088;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void merge() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 4, 5, 0, 0, 0};
        int[] nums2 = {2, 2, 3};
        solution.merge(nums1, 5, nums2, 3);
        Assert.assertEquals("[1, 2, 2, 2, 3, 3, 4, 5]", Arrays.toString(nums1));
    }

    @Test
    public void merge1() {
        Solution solution = new Solution();
        int[] nums1 = {0, 2, 3, 4, 5, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        solution.merge(nums1, 5, nums2, 3);
        Assert.assertEquals("[0, 1, 2, 2, 3, 3, 4, 5]", Arrays.toString(nums1));
    }

    @Test
    public void merge2() {
        Solution solution = new Solution();
        int[] nums1 = {0, 1, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0};
        solution.merge(nums1, 2, nums2, 0);
        Assert.assertEquals("[0, 1, 0, 0, 0, 0, 0, 0]", Arrays.toString(nums1));
    }

    @Test
    public void merge12() {
        Solution solution = new Solution();
        int[] nums1 = {-1, 3, 0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 1, 2, 3};
        solution.merge(nums1, 2, nums2, 5);
        Assert.assertEquals("[-1, 0, 0, 1, 2, 3, 3]", Arrays.toString(nums1));
    }

    @Test
    public void merge121() {
        Solution solution = new Solution();
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
        Assert.assertEquals("[1]", Arrays.toString(nums1));
    }

    @Test
    public void merge1121() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 0, 0};
        int[] nums2 = {0, 1};
        solution.merge(nums1, 2, nums2, 2);
        Assert.assertEquals("[0, 1, 1, 2]", Arrays.toString(nums1));
    }

}