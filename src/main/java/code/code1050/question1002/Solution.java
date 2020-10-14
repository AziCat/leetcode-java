package code.code1050.question1002;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/10/14
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] pre = new int[26];
        if (A.length > 0) {
            for (char c : A[0].toCharArray()) {
                pre[c - 'a']++;
            }
            for (int i = 1; i < A.length; i++) {
                int[] cur = new int[26];
                //求交集
                for (char c : A[i].toCharArray()) {
                    if (pre[c - 'a'] > 0) {
                        cur[c - 'a']++;
                        pre[c - 'a']--;
                    }
                }
                pre = cur;
            }
        }
        for (int i = 0; i < pre.length; i++) {
            while (pre[i] > 0) {
                ans.add(String.valueOf((char) ('a' + i)));
                pre[i]--;
            }
        }
        return ans;
    }
}
