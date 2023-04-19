package code.code2600.question2530;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * @author yjh
 * @since 2022/5/13
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        int fp = 0, sp = 0;
        boolean hasReplace = false;
        while (fp < first.length() && sp < second.length()) {
            if (hasReplace && first.charAt(fp) != second.charAt(sp)) {
                return false;
            } else if (first.charAt(fp) != second.charAt(sp)) {
                hasReplace = true;
                if (first.length() == second.length()) {
                    fp++;
                    sp++;
                } else if (first.length() > second.length()) {
                    fp++;
                } else {
                    sp++;
                }
            } else {
                fp++;
                sp++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String last = "1665989833093";
        String curr = "1665989833093";

        System.out.println(last.substring(0, last.length() - curr.length()));
        System.out.println(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        System.out.println( sdf.format(new Date()));
    }
}
