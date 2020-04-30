package code.code1100.question1095;

import java.util.HashMap;
import java.util.Map;

/**
 * （这是一个 交互式问题 ）
 * <p>
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * <p>
 * 如果不存在这样的下标 index，就请返回 -1。
 * <p>
 *  
 * <p>
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * <p>
 * 首先，A.length >= 3
 * <p>
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * <p>
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 * <p>
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * <p>
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-in-mountain-array
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/29
 */
public class Solution {
    interface MountainArray {
        int get(int index);

        int length();
    }


    /**
     * 二分法
     *
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek = findPeek(mountainArr);
        int ans = binSearch1(mountainArr, 0, peek, target);
        return ans >= 0 ? ans : binSearch2(mountainArr, peek, mountainArr.length(), target);
    }

    //左边升序区间查找
    int binSearch1(MountainArray mountainArray, int l, int rr, int t) {
        int r = rr;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (mountainArray.get(m) < t)
                l = m + 1;
            else
                r = m;
        }
        return l < rr && mountainArray.get(l) == t ? l : -1;
    }

    //右边降序区间查找
    int binSearch2(MountainArray mountainArray, int l, int rr, int t) {
        int r = rr;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (mountainArray.get(m) > t)
                l = m + 1;
            else
                r = m;
        }
        return l < rr && mountainArray.get(l) == t ? l : -1;
    }

    //查找峰
    int findPeek(MountainArray mountainArray) {
        int l = 0, r = mountainArray.length();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (m + 1 < mountainArray.length() && mountainArray.get(m) < mountainArray.get(m + 1))
                l = m + 1;
            else
                r = m;
        }
        return l;
    }

}
