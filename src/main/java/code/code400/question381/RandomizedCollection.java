package code.code400.question381;

import java.util.*;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/7/14
 */
public class RandomizedCollection {
    private final Map<Integer, Set<Integer>> indexMap;
    private final List<Integer> valList;
    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        this.indexMap = new HashMap<>();
        this.valList = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        //添加到列表末
        valList.add(val);
        if (indexMap.containsKey(val)) {
            //如果已存在，返回false
            indexMap.get(val).add(valList.size() - 1);
            return false;
        }
        //不存在则新增
        Set<Integer> indexSet = new HashSet<>();
        indexSet.add(valList.size() - 1);
        indexMap.put(val, indexSet);
        return true;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        Set<Integer> indexSet = indexMap.get(val);
        if (indexSet.isEmpty()) {
            indexMap.remove(val);
            return false;
        }
        //末尾元素
        int lastVal = valList.get(valList.size() - 1);
        if (lastVal == val) {
            indexSet.remove(valList.size() - 1);
            valList.remove(valList.size() - 1);
            return true;
        }
        //获取要删除的元素索引
        int firstIdx = indexSet.iterator().next();


        //把末尾元素添加到删除元素的位置
        valList.set(firstIdx, lastVal);
        indexMap.get(lastVal).add(firstIdx);

        //移除val
        indexSet.remove(firstIdx);
        indexMap.get(lastVal).remove(valList.size() - 1);
        valList.remove(valList.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return valList.get(random.nextInt(valList.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(4));
        System.out.println(randomizedCollection.insert(3));
        System.out.println(randomizedCollection.insert(4));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(4));
        System.out.println(randomizedCollection.remove(4));
        System.out.println(randomizedCollection.remove(3));
        System.out.println(randomizedCollection.remove(4));
        System.out.println(randomizedCollection.remove(4));

    }
}
