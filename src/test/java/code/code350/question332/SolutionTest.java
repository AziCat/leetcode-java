package code.code350.question332;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void findItinerary() throws Exception {
        Solution solution = new Solution();
        List<String> l1 = Arrays.asList("MUC", "LHR");
        List<String> l2 = Arrays.asList("JFK", "MUC");
        List<String> l3 = Arrays.asList("SFO", "SJC");
        List<String> l4 = Arrays.asList("LHR", "SFO");

        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        List<String> ans = solution.findItinerary(list);
        Assert.assertEquals("[JFK, MUC, LHR, SFO, SJC]", ans.toString());
    }

    @Test
    public void findItinerary1() throws Exception {
        Solution solution = new Solution();
        List<String> l1 = Arrays.asList("JFK", "SFO");
        List<String> l2 = Arrays.asList("JFK", "ATL");
        List<String> l3 = Arrays.asList("SFO", "ATL");
        List<String> l4 = Arrays.asList("ATL", "JFK");
        List<String> l5 = Arrays.asList("ATL", "SFO");

        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);

        List<String> ans = solution.findItinerary(list);
        Assert.assertEquals("[JFK, ATL, JFK, SFO, ATL, SFO]", ans.toString());
    }
}