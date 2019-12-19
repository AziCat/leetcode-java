package code.code200.question155;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {
    @Test
    public void test() throws Exception {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.top());
        minStack.push(-1);
        Assert.assertEquals(-1, minStack.top());
        minStack.pop();
        Assert.assertEquals(-3, minStack.top());
        minStack.pop();
        minStack.pop();
        Assert.assertEquals(-2, minStack.getMin());
    }

}