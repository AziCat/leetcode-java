package code.interview.question16_18;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void patternMatching() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("aabaa","ccccccccccccc"));
    }

    @Test
    public void patternMatching1() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("aaba","cacagoca"));
    }
    @Test
    public void patternMatching2() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("abba","dogdogdogdog"));
    }
    @Test
    public void patternMatching3() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("aa",""));
    }
    @Test
    public void patternMatching4() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("a","abcdaerafd"));
    }
    @Test
    public void patternMatching5() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("ab","abcdaerafd"));
    }
    @Test
    public void patternMatching51() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("bbbbbbbbbbbbbbabbbbb","ppppppppppppppjsftcleifftfthiehjiheyqkhjfkyfckbtwbelfcgihlrfkrwireflijkjyppppg"));
    }

    @Test
    public void patternMatching6() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.patternMatching("abba","dogcatcatfish"));
    }

    @Test
    public void patternMatching7() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.patternMatching("aaaa","dogcatcatdog"));
    }
    @Test
    public void patternMatching41() {
        Solution solution = new Solution();
        Assert.assertFalse(solution.patternMatching("ab",""));
    }
    @Test
    public void patternMatching412() {
        Solution solution = new Solution();
        Assert.assertTrue(solution.patternMatching("bbbbbbbbbabbbbbbbbabbbbbbbbbbaabbb",
                "mmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxbymbybximmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxbymbybximmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxbymbybximbymbybximmmbxuxmmbxuxmmbxux"));
    }

}