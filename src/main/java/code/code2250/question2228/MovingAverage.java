package code.code2250.question2228;

import java.util.LinkedList;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qIsx9U
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2021/11/2
 */
public class MovingAverage {
    private final LinkedList<Integer> queue;
    private final int size;
    private double sum = 0;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        queue.offerLast(val);
        if (queue.size() > this.size) {
            sum -= queue.pollFirst();
        }
        return sum / queue.size();
    }
}
