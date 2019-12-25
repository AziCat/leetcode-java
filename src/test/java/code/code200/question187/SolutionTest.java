package code.code200.question187;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findRepeatedDnaSequences() throws Exception {
        Solution solution = new Solution();
        List<String> ans = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTTCCCCCAAAAA");
        Assert.assertEquals("[AAAAACCCCC, CCCCCAAAAA]",ans.toString());
    }

}