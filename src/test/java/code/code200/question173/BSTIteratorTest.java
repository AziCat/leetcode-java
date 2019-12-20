package code.code200.question173;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTIteratorTest {
    @Test
    public void test() throws Exception {
        BSTIterator bstIterator = new BSTIterator(TreeNode.build(new Integer[]{27, 7, 28, 3, 15, null, null, null, null, 9, 20}));
        Assert.assertTrue(bstIterator.hasNext());
        Assert.assertEquals(3,bstIterator.next());
        Assert.assertEquals(7,bstIterator.next());
        Assert.assertEquals(9,bstIterator.next());
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        bstIterator.next();
        Assert.assertFalse(bstIterator.hasNext());
    }

}