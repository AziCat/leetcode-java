package code.code150.question131;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void partition() throws Exception {
        Solution solution = new Solution();
        List<List<String>> ans = solution.partition("kwtbjmsjvbrwriqwxadwnufplszhqccayvdhhvscxjaqsrmrrqngmuvxnugdzjfxeihogzsdjtvdmkudckjoggltcuybddbjoizu");
        for (List<String> an : ans) {
            System.out.println(an.toString());

        }
    }

}