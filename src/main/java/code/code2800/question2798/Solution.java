package code.code2800.question2798;

import java.util.Arrays;

/**
 * @author yjh
 * @since 2024/4/30
 */
public class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        //先排序
        Arrays.sort(hours);
        //再二分查找第一个大于等于target的数
        int index = search(0, hours.length - 1, hours, target);
        return index == -1 ? 0 : hours.length - index;
    }

    private int search(int left, int right, int[] hours, int target) {
        if (left == right) {
            return hours[left] >= target ? left : -1;
        }
        int mid = (left + right) / 2;
        //中间值是否大于等于Target
        if (hours[mid] >= target) {
            return search(left, mid, hours, target);
        }else{
            return search(mid + 1, right, hours, target);
        }
    }
}
