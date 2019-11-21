package code.code150.question133;

import common2.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void cloneGraph() throws Exception {
        Node n1 = new Node();
        n1.val = 1;
        Node n2 = new Node();
        n2.val = 2;
        Node n3 = new Node();
        n3.val = 3;
        Node n4 = new Node();
        n4.val = 4;

        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);


        Solution solution = new Solution();
        Node copy = solution.cloneGraph(n1);

        System.out.println(copy);
    }

}