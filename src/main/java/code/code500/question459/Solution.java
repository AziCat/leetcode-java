package code.code500.question459;

/**
 * @author yan
 * @version 1.0
 * @date 2020/8/24
 */
public class Solution {
    /**
     * 假设字串为x，s由n个x组成 s = nx，n>=2
     * 给定字符串t = s + s，则t = 2nx
     * 现在把t首尾字符去掉，则把头和尾的字串x破坏了，t = (2n-2)x
     * 因为n>=2，所以2n-2>=n，得出t至少有n个x字串，t里面最少有一个s
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String t = s.substring(1) + s.substring(0, s.length() - 1);
        return t.contains(s);
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }
}
