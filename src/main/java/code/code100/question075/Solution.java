package code.code100.question075;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 链接：https://leetcode-cn.com/problems/sort-colors
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/21
 */
public class Solution {
    /**
     * 使用3指针，p1指向最后一个0的位置，p2指向第一个2的位置,i指向当前遍历的位置
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int p1 = -1, p2 = nums.length, i = 0;
        while (i < p2) {
            if (nums[i] == 0) {
                //与p1+1位置的元素交换，i右移，p1右移
                swap(nums, i, ++p1);
                i++;
            } else if (nums[i] == 2) {
                if (nums[p2 - 1] == 2) {
                    //如果p2-1位置是2，p2--
                    p2--;
                } else if (nums[p2 - 1] == 0) {
                    //如果p2-1位置是0，交换位置内容，p2左移，i保持不动
                    swap(nums, i, --p2);
                } else {
                    swap(nums, i, --p2);
                    i++;
                }
            }else {
                i++;
            }
        }

    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
