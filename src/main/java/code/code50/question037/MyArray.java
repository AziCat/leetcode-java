package code.code50.question037;

import java.util.Arrays;

/**
 * @author yan
 * @version 1.0
 * @date 2019/9/27
 */
public class MyArray {
    private int[][] arr;


    MyArray(int[][] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(Arrays.toString(arr[i])).append("\n");
        }
        return sb.toString();
    }
}
