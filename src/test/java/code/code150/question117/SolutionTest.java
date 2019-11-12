package code.code150.question117;

import common.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void connect() throws Exception {
        Solution solution = new Solution();
        Node root = Node.build(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        solution.connect(root);
        System.out.println(root);
    }

    @Test
    public void connect1() throws Exception {
        Solution solution = new Solution();
        Node root = Node.build(new Integer[]{2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, 1});
        solution.connect(root);
        System.out.println(root);
    }

}