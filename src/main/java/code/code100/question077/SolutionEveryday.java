package code.code100.question077;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan
 * @version 1.0
 * @date 2020/9/8
 */
public class SolutionEveryday {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();

    /**
     * 回溯算法
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return ans;
    }

    private void backtrack(int s, int e, int k) {
        if (sub.size() == k) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        if (k - sub.size() > e - s + 1) {
            return;
        }
        for (int i = s; i <= e; i++) {
            sub.add(i);
            backtrack(i + 1, e, k);
            sub.remove(sub.size() - 1);
        }
    }

    //static SolutionEveryday a = new SolutionEveryday();

    static {
        System.out.println("A");
    }

    {
        System.out.println("B");
    }

    static {
        System.out.println("C");
    }

    public static void main(String[] args) {
        ClassLoader classLoader = SolutionEveryday.class.getClassLoader();
        System.out.println(classLoader);
    }
}
