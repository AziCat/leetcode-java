package code.code500.question460;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LFUCacheTest extends TestCase {
    @Test
    public void test() {
        LFUCache cache = new LFUCache(3);
        cache.put(2, 2);
        cache.put(1, 1);
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        cache.put(3, 3);
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(3));
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(1, cache.get(1));
        Assert.assertEquals(4, cache.get(4));
    }


    @Test
    public void test1() {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @Test
    public void test2() {
        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        Assert.assertEquals(-1, cache.get(0));
    }
}