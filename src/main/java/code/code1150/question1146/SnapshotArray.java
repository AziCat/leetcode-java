package code.code1150.question1146;

import java.util.Map;
import java.util.TreeMap;

/**
 * 快照数组
 *
 * @author yjh
 * @since 2024/4/26
 */
public class SnapshotArray {
    /**
     * 当前快照号
     */
    private int currSnap;

    private TreeMap<Integer, Integer>[] history;

    public SnapshotArray(int length) {
        this.currSnap = -1;
        this.history = new TreeMap[length];
    }

    /**
     * 设置值的时候，把当前快照号与值，保存到对应的TreeMap中
     *
     * @param index 索引
     * @param val   val
     */
    public void set(int index, int val) {
        if (null == history[index]) {
            history[index] = new TreeMap<>();
        }
        TreeMap<Integer, Integer> snapHistoryMap = history[index];
        snapHistoryMap.put(currSnap + 1, val);
    }

    public int snap() {
        currSnap += 1;
        return currSnap;
    }

    /**
     * 按索引号获取快照历史，找到<=快照号的对应值
     *
     * @param index   索引
     * @param snap_id 快照号
     * @return int
     */
    public int get(int index, int snap_id) {
        if (null == history[index]) {
            return 0;
        }
        TreeMap<Integer, Integer> snapHistoryMap = history[index];
        if (snapHistoryMap.containsKey(snap_id)) {
            return snapHistoryMap.get(snap_id);
        }
        Map.Entry<Integer, Integer> greatestLow = snapHistoryMap.lowerEntry(snap_id);
        if (null == greatestLow) {
            return 0;
        }
        return greatestLow.getValue();
    }
}
