package code.code250.question223;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * @author yan
 * @version 1.0
 * @date 2020/2/11
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        //判断有没有重叠
        int x = getCommon(A, C, E, G);
        int y = x == 0 ? 0 : getCommon(B, D, F, H);

        return (C - A) * (D - B) - x * y + (G - E) * (H - F);
    }

    private int getCommon(int i1, int i2, int i3, int i4) {
        if (i3 >= i1 && i3 <= i2) {
            return i4 > i2 ? i2 - i3 : i4 - i3;
        } else if (i3 < i1) {
            if (i4 >= i1 && i4 <= i2) {
                return i4 - i1;
            } else if (i4 > i2) {
                return i2 - i1;
            }
        }
        return 0;
    }
}
