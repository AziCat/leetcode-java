package code.code350.question345;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/4/9
 */
public class Solution {
    /**
     * A、E、I、O、U通常都是元音字母。
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int st = 0, ed = arr.length - 1;
        while (st < ed) {
            while (!isVowels(arr[st]) && st < ed) {
                st++;
            }
            while (!isVowels(arr[ed]) && st < ed) {
                ed--;
            }
            if (st >= ed) {
                break;
            }
            char temp = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++;
            ed--;

        }
        return new String(arr);
    }

    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
