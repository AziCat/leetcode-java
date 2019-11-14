package code.code150.question118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arrList;
        if(numRows >= 1){
            arrList = new ArrayList<>();
            arrList.add(1);
            result.add(arrList);
        }
        if(numRows >= 2){
            arrList = new ArrayList<>();
            arrList.add(1);
            arrList.add(1);
            result.add(arrList);
        }

        for (int i = 2; i < numRows; i++) {
            int j = i - 1;
            arrList = new ArrayList<>();
            arrList.add(1);
            while (j >= 1) {
                arrList.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                j--;
            }
            arrList.add(1);
            result.add(arrList);
        }
        return result;
    }
}
