package code.code150.question125;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int left = move(s, true, 0), right = move(s, false, s.length() - 1);
        while (left <= right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left = move(s, true, left + 1);
            right = move(s, false, right - 1);
        }
        return true;
    }

    private int move(String s, boolean isLeft, int i) {
        while (i >= 0 && i < s.length() && !isAccessCharacter(s.charAt(i))) {
            i = isLeft ? i + 1 : i - 1;
        }
        return i;
    }

    private boolean isAccessCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
