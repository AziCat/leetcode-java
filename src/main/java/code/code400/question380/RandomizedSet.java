package code.code400.question380;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/14
 */
public class RandomizedSet {
    /**
     * 用于保存val与val在valList中的索引位置
     */
    private final Map<Integer, Integer> indexTable;
    /**
     * 用于存放val
     */
    private final List<Integer> valList;

    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.indexTable = new HashMap<>();
        this.valList = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (indexTable.containsKey(val)) {
            return false;
        }
        //添加到列表末
        valList.add(val);
        //保存索引位置
        indexTable.put(val, valList.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexTable.containsKey(val)) {
            return false;
        }
        //val索引
        int idx = indexTable.get(val);
        //把需要删除的的元素设置为列表最后一个元素内容
        int lastVal = valList.get(valList.size() - 1);
        //使用set而不是add
        valList.set(idx, lastVal);
        indexTable.put(lastVal, idx);

        //移除
        valList.remove(valList.size() - 1);
        indexTable.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return valList.get(random.nextInt(valList.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        randomizedSet.getRandom();
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        randomizedSet.getRandom();
    }
}
