package code.code2150.question2105;

/**
 * @author yjh
 * @since 2024/5/9
 */
public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = capacityA;
        int b = capacityB;
        int left = 0;
        int right = plants.length - 1;
        int ans = 0;
        while (left <= right) {
            if (left == right) {
                if (a >= b) {
                    if (a < plants[left]) {
                        ans++;
                    }
                } else if (b < plants[right]) {
                    ans++;
                }
            } else {
                if (a < plants[left]) {
                    ans++;
                    a = capacityA;
                }
                if (b < plants[right]) {
                    ans++;
                    b = capacityB;
                }
            }
            a -= plants[left];
            b -= plants[right];
            left++;
            right--;
        }
        return ans;

    }
}
