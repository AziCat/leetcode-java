package code.code150.question116;

import common.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void connect() throws Exception {
        Solution solution = new Solution();
        Node root = Node.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        root = solution.connect(root);
        System.out.println(root);
    }

}