package code.code250.question211;

import org.junit.Assert;
import org.junit.Test;

public class WordDictionaryTest {
    @Test
    public void test() throws Exception {
        WordDictionary wordDictionary1 = new WordDictionary();
        wordDictionary1.addWord("bad");
        wordDictionary1.addWord("dad");
        wordDictionary1.addWord("mad");

        Assert.assertFalse(wordDictionary1.search("pad"));
        Assert.assertFalse(wordDictionary1.search("padf"));
        Assert.assertFalse(wordDictionary1.search("padf."));
        Assert.assertTrue(wordDictionary1.search("bad"));
        Assert.assertTrue(wordDictionary1.search("ba."));
        Assert.assertTrue(wordDictionary1.search(".a."));
        Assert.assertTrue(wordDictionary1.search(".ad"));
        Assert.assertTrue(wordDictionary1.search("b.d"));

    }

}