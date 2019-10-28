package code.code50.question022;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void generateParenthesis() {
        List list = solution.generateParenthesis(1);
        Assert.assertEquals("[()]", list.toString());
    }
    @Test
    public void generateParenthesis1() {
        List list = solution.generateParenthesis(0);
        Assert.assertEquals("[]", list.toString());
    }
    @Test
    public void generateParenthesis2() {
        List list = solution.generateParenthesis(2);
        Assert.assertEquals("[(()), ()()]", list.toString());
    }
    @Test
    public void generateParenthesis3() {
        List list = solution.generateParenthesis(3);
        Assert.assertEquals("[((())), (()()), (())(), ()(()), ()()()]", list.toString());
    }
    @Test
    public void generateParenthesis4() {
        List list = solution.generateParenthesis(4);
        //["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
        //["(())(())"]
        //()(())()
        System.out.println(list);
    }
}