package code.code100.question093;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void restoreIpAddresses() throws Exception {
        Solution solution = new Solution();
        String s = "192168100100";
        List<String> ans = solution.restoreIpAddresses(s);
        Assert.assertEquals("[192.168.100.100]", ans.toString());
    }
    @Test
    public void restoreIpAddresses1() throws Exception {
        Solution solution = new Solution();
        String s = "0000";
        List<String> ans = solution.restoreIpAddresses(s);
        Assert.assertEquals("[0.0.0.0]", ans.toString());
    }

    @Test
    public void restoreIpAddresses2() throws Exception {
        Solution solution = new Solution();
        String s = "25525511135";
        List<String> ans = solution.restoreIpAddresses(s);
        Assert.assertEquals("[255.255.11.135, 255.255.111.35]", ans.toString());
    }

}