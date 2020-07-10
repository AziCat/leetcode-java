package code.code400.question374;

/**
 * @author yan
 * @version 1.0
 * @date 2020/7/9
 */
public class Solution extends GuessGame {
    public Solution(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int result = guess(n);
        int s, e;

        //二分法确定边界
        if (result == 1) {
            //比目标值小
            s = n;
            e = n * 2;
            while (guess(e) != -1) {
                e *= 2;
            }
        } else if (result == -1) {
            //比目标值大
            e = n;
            s = n / 2;
            while (guess(s) != 1) {
                s /= 2;
            }
        } else {
            return n;
        }
        int mid = (s + e) >>> 1;
        result = guess(mid);
        while (result != 0) {
            if (result == 1) {
                s = mid;
            } else {
                e = mid;
            }
            mid = (s + e) >>> 1;
            result = guess(mid);
        }
        return mid;
    }
}
