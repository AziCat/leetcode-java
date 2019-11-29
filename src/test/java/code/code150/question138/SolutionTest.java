package code.code150.question138;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void copyRandomList() throws Exception {
        Solution solution = new Solution();
        Solution.Node node1 = new Solution.Node();
        Solution.Node node2 = new Solution.Node();

        node1.val = 1;
        node1.next = node2;
        node1.random = node2;

        node2.val = 2;
        node2.next = null;
        node2.random = node2;


        Solution.Node copy = solution.copyRandomList(node1);

        System.out.println(copy);
    }

}