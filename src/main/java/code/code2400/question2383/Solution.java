package code.code2400.question2383;

import org.junit.Assert;

/**
 * 2383. 赢得比赛需要的最少训练时长
 *
 * @author yjh
 * @since 2023/3/13
 */
public class Solution {
    /**
     * n == energy.length == experience.length
     * 1 <= n <= 100
     * 1 <= initialEnergy, initialExperience, energy[i], experience[i] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param initialEnergy
     * @param initialExperience
     * @param energy
     * @param experience
     * @return
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int n = energy.length;
        int currentEnergy = initialEnergy;
        int currentExperience = initialExperience;
        for (int i = 0; i < n; i++) {
            if (energy[i] >= currentEnergy) {
                ans += energy[i] - currentEnergy + 1;
                currentEnergy = 1;
            } else {
                currentEnergy -= energy[i];
            }

            if (experience[i] >= currentExperience) {
                ans += experience[i] - currentExperience + 1;
                currentExperience = experience[i] + 1;
            }
            currentExperience += experience[i];

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1});
        Assert.assertEquals(8, ans);
        ans = solution.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50});
        Assert.assertEquals(51, ans);
    }
}
