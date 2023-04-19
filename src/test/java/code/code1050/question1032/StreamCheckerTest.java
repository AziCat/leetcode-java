package code.code1050.question1032;

import junit.framework.TestCase;

public class StreamCheckerTest extends TestCase {

    public void test() {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl", "abc"});
        assertFalse(streamChecker.query('d'));
        assertFalse(streamChecker.query('b'));
        assertFalse(streamChecker.query('c'));
        assertTrue(streamChecker.query('d'));
        assertFalse(streamChecker.query('e'));
        assertTrue(streamChecker.query('f'));
        assertFalse(streamChecker.query('g'));
        assertFalse(streamChecker.query('h'));
        assertFalse(streamChecker.query('i'));
        assertFalse(streamChecker.query('j'));
        assertFalse(streamChecker.query('k'));
        assertTrue(streamChecker.query('l'));
    }
}