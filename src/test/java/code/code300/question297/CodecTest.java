package code.code300.question297;

import common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodecTest {
    @Test
    public void test() throws Exception {
        Codec codec = new Codec();
        TreeNode treeNode = TreeNode.build(new Integer[]{1, 2, 3, 6, null, 4, 5, null, null, 7});
        String str = codec.serialize(treeNode);
        System.out.println(str);
        TreeNode root = codec.deserialize(str);
        System.out.println(root);
    }

}