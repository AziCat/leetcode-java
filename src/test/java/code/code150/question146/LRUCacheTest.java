package code.code150.question146;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    @Test
    public void test() throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int value = cache.get(1);       // 返回  1
        Assert.assertEquals(1, value);
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        value = cache.get(2);       // 返回 -1 (未找到)
        Assert.assertEquals(-1, value);
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        value = cache.get(1);       // 返回 -1 (未找到)
        Assert.assertEquals(-1, value);
        value = cache.get(3);       // 返回  3
        Assert.assertEquals(3, value);
        value = cache.get(4);       // 返回  4
        Assert.assertEquals(4, value);
    }

    @Test
    public void test1() throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);
    }

}