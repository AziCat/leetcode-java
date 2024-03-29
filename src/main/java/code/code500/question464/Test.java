package code.code500.question464;

/**
 * @author yjh
 * @since 2021/6/28
 */
public class Test {
    /**
     * 默认地球半径
     */
    private static double EARTH_RADIUS = 6371000;//赤道半径(单位m)

    /**
     * 转化为弧度(rad)
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * @param lon1 第一点的精度
     * @param lat1 第一点的纬度
     * @param lon2 第二点的精度
     * @param lat2 第二点的纬度
     * @return 返回的距离，单位m
     */
    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }

    /**
     * 计算中心经纬度与目标经纬度的距离（米）
     *
     * @param centerLon 中心精度
     * @param centerLat 中心纬度
     * @param targetLon 需要计算的精度
     * @param targetLat 需要计算的纬度
     * @return 米
     */
    private static double distance(double centerLon, double centerLat, double targetLon, double targetLat) {

        double jl_jd = 102834.74258026089786013677476285;// 每经度单位米;
        double jl_wd = 111712.69150641055729984301412873;// 每纬度单位米;
        double b = Math.abs((centerLat - targetLat) * jl_jd);
        double a = Math.abs((centerLon - targetLon) * jl_wd);
        return Math.sqrt((a * a + b * b));
    }

    public static void main(String[] args) {
        double lon = 113.30764968; //当前经度
        double lat = 23.1200491; //当前纬度
        double lon1 = 121.57725688193142;
        double lat1 = 25.036301601365555;
        double dist;
        double dist2;
        dist = getDistance(lon, lat, lon1, lat1);
        dist2 = distance(lon, lat, lon1, lat1);
        System.out.println("1.两点相距：" + dist + " 米");
        System.out.println("2.两点相距：" + dist2 + " 米");
    }
}
