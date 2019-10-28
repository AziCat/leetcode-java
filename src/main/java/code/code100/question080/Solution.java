package code.code100.question080;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/22
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[p - 2]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    public int removeDuplicates_(int[] nums) {
        int left = 0, right = 1, count = 1;
        while (right < nums.length) {
            if (count == 2) {
                while (right < nums.length && nums[right] == nums[left]) {
                    right++;
                }
                if (right < nums.length) {
                    nums[++left] = nums[right++];
                    count = 1;
                }
            } else {
                if (nums[right] != nums[left]) {
                    nums[++left] = nums[right++];
                    count = 1;
                } else {
                    nums[++left] = nums[right++];
                    count++;
                }
            }
        }
        return left + 1;
    }
}
