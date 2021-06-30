package code.code500.question464;

import java.math.BigDecimal;

/**
 * @author yjh
 * @since 2021/6/23
 */
public class Solution {
    static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(121.57725688193142, 25.036301601365555);
        Point p2 = new Point(113.30764968, 23.1200491);

        double distance = getDistance(p1, p2);
        System.out.println(distance);
    }

    private static double getDistance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}

