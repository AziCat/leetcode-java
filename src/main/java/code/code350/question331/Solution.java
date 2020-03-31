package code.code350.question331;

/**
 * 验证二叉树的前序序列化
 * 示例 1:
 * <p>
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: "9,#,#,1"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/3/31
 */
public class Solution {
    private int cur = 0;

    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        return (arr.length - 1) % 2 == 0 && check(arr) && cur == arr.length - 1;
    }

    private boolean check(String[] arr) {
        if (cur >= arr.length) {
            return false;
        }
        String root = arr[cur];
        if (!"#".equals(root)) {
            cur++;
            boolean checkLeft = check(arr);
            cur++;
            boolean checkRight = check(arr);
            return checkLeft && checkRight;
        }
        return true;
    }
}
