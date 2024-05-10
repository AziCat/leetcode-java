package code.code2100.question2079;

/**
 * @author yjh
 * @since 2024/5/8
 */
public class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int cur = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (cur < plants[i]) {
                //打水
                ans += 2 * i;
                cur = capacity;
            }
            ans++;
            cur -= plants[i];
        }
        return ans;
    }
}
