package code.code1100.question1052;

/**
 * @author yjh
 * @since 2024/4/23
 */
public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //使用滑动窗口
        int left = 0;
        int right = minutes - 1;
        int temp = 0;
        //初始化
        for (int i = 0; i < customers.length; i++) {
            if (i <= right) {
                //在窗口内
                temp += customers[i];
            } else {
                temp += grumpy[i] == 1 ? 0 : customers[i];
            }
        }
        int maxResult = temp;
        while (right < customers.length - 1) {
            right++;
            temp -= grumpy[right] == 1 ? 0 : customers[right];
            temp += customers[right];

            temp -= customers[left];
            temp += grumpy[left] == 1 ? 0 : customers[left];
            left++;

            maxResult = Math.max(maxResult, temp);
        }

        return maxResult;
    }
}
