package code.code300.question284;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PeekingIteratorTest {
    @Test
    public void test() throws Exception {
        PeekingIterator peekingIterator = new PeekingIterator(Arrays.asList(1, 2, 3).iterator());
        Integer i = peekingIterator.next();
        System.out.println(i);
        System.out.println(peekingIterator.hasNext());
        i = peekingIterator.peek();
        System.out.println(i);
        i = peekingIterator.next();
        System.out.println(i);
        i = peekingIterator.peek();
        System.out.println(i);
        i = peekingIterator.next();
        System.out.println(i);
        System.out.println(peekingIterator.hasNext());
        i = peekingIterator.peek();
        System.out.println(i);
        i = peekingIterator.next();
        System.out.println(i);
    }

}