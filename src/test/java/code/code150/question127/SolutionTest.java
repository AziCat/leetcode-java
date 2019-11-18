package code.code150.question127;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void ladderLength() throws Exception {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        int length = solution.ladderLength(beginWord, endWord, Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Assert.assertEquals(5, length);

    }

    @Test
    public void ladderLength1() throws Exception {
        Solution solution = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        int length = solution.ladderLength(beginWord, endWord, Arrays.asList("hot", "dot", "dog", "lot", "log"));
        Assert.assertEquals(0, length);

    }

    @Test
    public void ladderLength2() throws Exception {
        Solution solution = new Solution();
        String beginWord = "talk";
        String endWord = "tail";
        int length = solution.ladderLength(beginWord, endWord, Arrays.asList("talk","tons","fall","tail","gale","hall","negs"));
        Assert.assertEquals(0, length);

    }
}