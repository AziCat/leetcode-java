package code.interview.question16_18;

/**
 * @author yan
 * @version 1.0
 * @date 2020/6/22
 */
public class Solution {
    public boolean patternMatching(String pattern, String value) {
        return patternMatching(null, null, pattern, value);
    }

    public boolean patternMatching(String a, String b, String pattern, String value) {
        if (pattern.equals(value)) {
            return true;
        }
        if (pattern.length() > 0) {
            char item = pattern.charAt(0);
            if (item == 'a') {
                if (a == null) {
                    for (int i1 = 0; i1 <= value.length(); i1++) {
                        String subA = value.substring(0, i1);
                        if (subA.equals(b)) {
                            continue;
                        }
                        if (patternMatching(subA, b, pattern.substring(1), value.substring(i1))) {
                            return true;
                        }
                    }
                } else {
                    if (value.startsWith(a)) {
                        return patternMatching(a, b, pattern.substring(1), value.substring(a.length()));
                    } else {
                        return false;
                    }
                }
            } else {
                if (b == null) {
                    for (int i1 = 0; i1 <= value.length(); i1++) {
                        String subB = value.substring(0, i1);
                        if (subB.equals(a)) {
                            continue;
                        }
                        if (patternMatching(a, subB, pattern.substring(1), value.substring(i1))) {
                            return true;
                        }
                    }
                } else {
                    if (value.startsWith(b)) {
                        return patternMatching(a, b, pattern.substring(1), value.substring(b.length()));
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("aaa".startsWith(""));
    }
}
