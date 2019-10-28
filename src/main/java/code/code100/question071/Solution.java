package code.code100.question071;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 * <p>
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 * <p>
 * 链接：https://leetcode-cn.com/problems/simplify-path
 *
 * @author yan
 * @version 1.0
 * @date 2019/10/21
 */
public class Solution {
    /**
     * 使用栈
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : arr) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!s.equals("") && !s.equals(".")) {
                stack.addLast(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append("/").append(stack.pollFirst());
            }
            return sb.toString();
        }
    }
}
