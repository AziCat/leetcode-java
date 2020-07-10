package code.code400.question374;

/**
 * @author yan
 * @version 1.0
 * @date 2020/7/9
 */
public class GuessGame {
    private final int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    public int guess(int num) {
        if (num < pick) {
            return 1;
        } else if (num > pick) {
            return -1;
        }
        return 0;
    }
}
