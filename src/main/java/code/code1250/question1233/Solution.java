package code.code1250.question1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * <p>
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * <p>
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * <p>
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/8
 */
public class Solution {
    /**
     * 1 <= folder.length <= 4 * 10的4次方
     * 2 <= folder[i].length <= 100
     * folder[i] 只包含小写字母和 '/'
     * folder[i] 总是以字符 '/' 起始
     * 每个文件夹名都是 唯一 的
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        //先排序
        Arrays.sort(folder);
        String temp = "?";
        for (String f : folder) {
            if (!f.startsWith(temp)) {
                ans.add(f);
                temp = f+"/";
            }
        }
        return ans;
    }
}
