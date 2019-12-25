package code.code200.question187;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * <p>
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/25
 */
public class Solution {
    /**
     * 哈希表
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Boolean> map = new HashMap<>();
        int st = 0;
        while (st + 10 <= s.length()) {
            String temp = s.substring(st, st + 10);
            if (map.containsKey(temp)) {
                if (map.get(temp)) {
                    ans.add(temp);
                    map.put(temp, false);
                }
            } else {
                map.put(temp, true);
            }
            st+=1;
        }
        return ans;
    }
}
