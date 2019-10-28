package code.code50.question015;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素a,b,c，使用a+b+c=0？找出所有满足条件且不重复的三元组
 * <p>
 * nums=[-1,0,1,2,-1,-4]
 * <p>
 * 返回
 * [
 * [-1,0,1],
 * [-1,-1,2]
 * ]
 *
 * @author yan
 * @version 1.0
 * @date 2019/9/16
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //选升序排序
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                //因为是升序，如果i指针内容大于0，则后面双指针的内容都是大于0的，3数之和不可能=0，直接结束循环
                break;
            }
            //l,r左右双指针
            int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
            //如果i指针内容没有变化，直接路过
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        resultList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        //值小于目标值，因为数组升序的原因，左指针右移使sum变大
                        l++;

                    } else {
                        //值大于目标值，因为数组升序的原因，右指针左移使sum变小
                        r--;
                    }
                }
            }
        }
        return resultList;
    }


    public List<List<Integer>> threeSum_(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;   // 跳过重复值
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return ls;
    }

    /**
     * 此方法超时了
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum__(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<String, Object> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            List<List<Integer>> temp = sum2(nums, i, 0 - nums[i]);
            for (List<Integer> itemList : temp) {
                itemList.add(nums[i]);
                StringBuilder str = new StringBuilder();
                itemList.stream()
                        .sorted()
                        .forEach(item -> str.append(item).append(","));
                if (!tempMap.containsKey(str.toString())) {
                    tempMap.put(str.toString(), null);
                    resultList.add(itemList);
                }
            }
        }
        return resultList;
    }

    private List<List<Integer>> sum2(int[] nums, int skipIndex, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (skipIndex != i) {
                if (map.containsKey(nums[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(map.get(nums[i]));
                    resultList.add(list);
                } else {
                    map.put(target - nums[i], nums[i]);
                }
            }
        }
        return resultList;
    }
}
