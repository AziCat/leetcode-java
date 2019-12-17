package code.code200.question153;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/17
 */
public class Solution {
    /**
     * 因为元素不重复，用二分法分割，比较头尾
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return findMin(0, nums.length - 1, nums);
    }

    private int findMin(int st, int end, int[] nums) {
        if (st == end || nums[st] <= nums[end]) {
            return nums[st];
        }
        int mid = (st + end) / 2;
        if (nums[st] <= nums[mid]) {
            if (nums[mid + 1] <= nums[end]) {
                return nums[mid + 1];
            } else {
                return findMin(mid + 1, end, nums);
            }
        } else {
            return findMin(st, mid, nums);
        }
    }
}
