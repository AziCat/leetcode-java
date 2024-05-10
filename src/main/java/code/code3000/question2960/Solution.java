package code.code3000.question2960;

/**
 * @author yjh
 * @since 2024/5/10
 */
public class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage - ans > 0) {
                ans++;
            }
        }
        return ans;
    }
}
