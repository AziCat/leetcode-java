package code.code1250.question1233;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testRemoveSubfolders() {
        Solution solution = new Solution();
        List<String> ans = solution.removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"});
        Assert.assertEquals("[/a/b/c, /a/b/ca, /a/b/d]", ans.toString());
    }

    @Test
    public void testRemoveSubfolders1() {
        Solution solution = new Solution();
        List<String> ans = solution.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"});
        Assert.assertEquals("[/a, /c/d, /c/f]", ans.toString());
    }

    @Test
    public void testRemoveSubfolders2() {
        Solution solution = new Solution();
        List<String> ans = solution.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"});
        Assert.assertEquals("[/a]", ans.toString());
    }

    @Test
    public void testRemoveSubfolders3() {
        Solution solution = new Solution();
        List<String> ans = solution.removeSubfolders(new String[]{"/a","/a/aaaaa","/a/aaaab"});
        Assert.assertEquals("[/a]", ans.toString());
    }
}