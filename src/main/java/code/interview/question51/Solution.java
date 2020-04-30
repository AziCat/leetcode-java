package code.interview.question51;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/24
 */
public class Solution {
    private int ans = 0;

    /**
     * 归并排序
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int mid = (nums.length - 1) >>> 1;
        int[] temp1 = binary(nums, 0, mid);
        int[] temp2 = binary(nums, mid + 1, nums.length - 1);
        mergeSort(temp1, temp2);
        return ans;
    }

    /**
     * 数组二分
     * @param nums
     * @param s
     * @param e
     * @return
     */
    private int[] binary(int[] nums, int s, int e) {
        if (s != e) {
            int mid = (s + e) >>> 1;
            int[] temp1 = binary(nums, s, mid);
            int[] temp2 = binary(nums, mid + 1, e);
            return mergeSort(temp1, temp2);
        }
        return new int[]{nums[s]};
    }

    /**
     * 合并两个有序数组
     * @param temp1
     * @param temp2
     * @return
     */
    private int[] mergeSort(int[] temp1, int[] temp2) {
        int[] sort = new int[temp1.length + temp2.length];
        int i = 0, j = 0, k = 0;
        while (k < sort.length) {
            if (i == temp1.length) {
                sort[k] = temp2[j];
                j++;

            } else if (j == temp2.length) {
                sort[k] = temp1[i];
                i++;
            } else {
                if (temp2[j] < temp1[i]) {
                    sort[k] = temp2[j];
                    j++;
                    ans += temp1.length - i;
                } else {
                    sort[k] = temp1[i];
                    i++;
                }
            }
            k++;
        }
        return sort;
    }


    private class TreeNode {
        /**
         * 当前值
         */
        public int val;
        /**
         * 左子树存放小于等于val的节点
         */
        public TreeNode left;
        /**
         * 右子树存放大于val的节点
         */
        public TreeNode right;
        /**
         * 记录小于等于val的节点数，包含自身
         */
        public int count = 1;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 线段树
     *
     * @param nums
     * @return
     */
    public int reversePairs_(int[] nums) {
        //逆序构建线段树
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        for (int i = nums.length - 1; i >= 0; i--) {
            buildTree(root, nums[i]);
        }
        return ans;
    }

    private void buildTree(TreeNode root, int num) {
        if (num > root.val) {
            ans += root.count;
            if (root.right != null) {
                buildTree(root.right, num);
            } else {
                root.right = new TreeNode(num);
            }
        } else {
            root.count++;
            if (root.left != null) {
                buildTree(root.left, num);
            } else {
                root.left = new TreeNode(num);
            }
        }
    }
}
