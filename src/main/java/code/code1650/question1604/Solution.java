package code.code1650.question1604;

import java.util.*;

/**
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * <p>
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * <p>
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/7
 */
public class Solution {
    /**
     * 1 <= keyName.length, keyTime.length <= 10的5资方
     * keyName.length == keyTime.length
     * keyTime 格式为 "HH:MM" 。
     * 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
     * 1 <= keyName[i].length <= 10
     * keyName[i] 只包含小写英文字母
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param keyName
     * @param keyTime
     * @return
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        //key是name,value是打卡时间
        Map<String, List<Integer>> map = new HashMap<>(keyName.length);

        for (int i = 0; i < keyName.length; i++) {

            String name = keyName[i];
            String time = keyTime[i];

            List<Integer> timeList = map.computeIfAbsent(name, k -> new ArrayList<>());
            timeList.add(parseTime(time));
        }

        for (String name : map.keySet()) {
            List<Integer> timeList = map.get(name);
            Collections.sort(timeList);
            for (int i = 0; i < timeList.size()-2; i++) {
                if (timeList.get(i + 2) - timeList.get(i) < 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    private Integer parseTime(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }


}
