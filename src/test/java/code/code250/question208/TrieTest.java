package code.code250.question208;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void test() throws Exception {
        Trie trie = new Trie();

        trie.insert("apple");
        //True
        Assert.assertTrue(trie.search("apple"));
        // 返回 false
        Assert.assertFalse(trie.search("app"));
        // 返回 true
        Assert.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        Assert.assertTrue(trie.search("app"));

    }

}