package code.code1850.question1813;

/**
 * 一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 * <p>
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 * <p>
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sentence-similarity-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/1/16
 */
public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        return canInsertHead(arr1, arr2) || canInsertTail(arr1, arr2) || catInsertMiddle(arr1, arr2);
    }

    private boolean catInsertMiddle(String[] arr1, String[] arr2) {
        int left1 = 0;
        int left2 = 0;
        int right1 = arr1.length - 1;
        int right2 = arr2.length - 1;
        while (left1 < arr1.length && left2 < arr2.length) {
            if (arr1[left1].equals(arr2[left2])) {
                left1++;
                left2++;
            } else {
                break;
            }
        }
        while (right1 > 0 && right2 > 0) {
            if (arr1[right1].equals(arr2[right2])) {
                right1--;
                right2--;
            } else {
                break;
            }
        }
        return right1 < left1 || right2 < left2;
    }

    private boolean canInsertTail(String[] arr1, String[] arr2) {
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].equals(arr2[j])) {
                i++;
                j++;
            } else {
                break;
            }
        }
        return i == arr1.length || j == arr2.length;
    }

    private boolean canInsertHead(String[] arr1, String[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i].equals(arr2[j])) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i < 0 || j < 0;
    }


}
