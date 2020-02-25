package code.code300.question295;

import org.junit.Test;

public class MedianFinderTest {
    @Test
    public void test() throws Exception {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        medianFinder.addNum(8);
        medianFinder.addNum(5);
        medianFinder.addNum(4);
        medianFinder.addNum(7);
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
    }

}