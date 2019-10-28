package code.code50.question028;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void strStr() {
        String a = "hello";
        String b = "ll";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr1() {
        String a = "hello";
        String b = "ell";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr2() {
        String a = "hel0oell123";
        String b = "ell";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr3() {
        String a = "hel0oell123";
        String b = "";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr4() {
        String a = "hel0oell123";
        String b = "";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr5() {
        String a = "hel0oell123";
        String b = "el5";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr6() {
        String a = "a";
        String b = "a";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr7() {
        String a = "abc";
        String b = "abe";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr8() {
        String a = "mississippi";
        String b = "issip";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }

    @Test
    public void strStr9() {
        String a = "mississippi";
        String b = "issipi";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }
    @Test
    public void strStr10() {
        String a = "aaa";
        String b = "a";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }
    @Test
    public void strStr11() {
        String a = "aaa";
        String b = "aa";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }
    @Test
    public void strStr12() {
        String a = "mississippi";
        String b = "pi";
        assertEquals(a.indexOf(b), solution.strStr(a, b));
    }



}