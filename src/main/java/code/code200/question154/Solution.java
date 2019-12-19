package code.code200.question154;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/17
 */
public class Solution {
    /**
     * 还是二分法
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return findMin(0, nums.length - 1, nums);
    }

    private int findMin(int s, int e, int[] nums) {
        if (s == e || nums[s] < nums[e]) {
            return nums[s];
        }
        int mid = (s + e) / 2;
        return Math.min(findMin(s, mid, nums), findMin(mid + 1, e, nums));
    }
}
