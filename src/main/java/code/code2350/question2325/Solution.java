package code.code2350.question2325;

import java.util.Arrays;

/**
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/decode-the-message
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/1
 */
public class Solution {
    /**
     * 26 <= key.length <= 2000
     * key 由小写英文字母及 ' ' 组成
     * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
     * 1 <= message.length <= 2000
     * message 由小写英文字母和 ' ' 组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/decode-the-message
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param key
     * @param message
     * @return
     */
    public String decodeMessage(String key, String message) {
        char[] map = new char[26];
        Arrays.fill(map, ' ');
        int keyCounter = 0;
        char[] keyChars = key.toCharArray();
        for (char keyChar : keyChars) {
            if (keyCounter == 26) {
                break;
            }
            if (keyChar == ' ') {
                continue;
            }
            if (map[keyChar - 'a'] == ' ') {
                map[keyChar - 'a'] = (char) ('a' + keyCounter);
                keyCounter++;
            }
        }
        char[] messageChars = message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            if (messageChars[i] == ' ') {
                continue;
            }
            messageChars[i] = map[messageChars[i] - 'a'];
        }
        return new String(messageChars);
    }
}
