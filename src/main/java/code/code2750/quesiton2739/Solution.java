package code.code2750.quesiton2739;

/**
 * @author yjh
 * @since 2024/4/25
 */
public class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        if (mainTank < 5) {
            return mainTank * 10;
        }
        int addingCount = mainTank / 5;
        int additional = Math.min(addingCount, additionalTank);
        int left = mainTank % 5 + additional;
        return addingCount * 50 + distanceTraveled(left, additionalTank - additional);
    }
}
