package code.code1150.question1145;

import common.TreeNode;

/**
 * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
 * <p>
 * 最开始时：
 * <p>
 * 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
 * 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
 * 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
 * <p>
 * 之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。
 * <p>
 * 如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。
 * <p>
 * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
 * <p>
 * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-coloring-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yjh
 * @since 2023/2/3
 */
public class Solution {
    private int leftNums = 0;
    private int rightNums = 0;

    /**
     * 树中节点数目为 n
     * 1 <= x <= n <= 100
     * n 是奇数
     * 1 <= Node.val <= n
     * 树中所有值 互不相同
     *
     * @param root
     * @param n
     * @param x
     * @return
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        //当玩家1选了x之后，为了保证玩家2能染色更多的节点，y必须是x的相邻节点（x的根，左、右节点）
        //计算出x划分的3部分节点数量，如果存在其中一部分的节点数量大于其它两部分节点总和，则玩家2确保获胜
        dfs(root, x);
        int rootNums = n - leftNums - rightNums - 1;
        return rootNums>leftNums+rightNums+1||leftNums>rootNums+rightNums+1||rightNums>rootNums+leftNums+1;
    }

    private int dfs(TreeNode root, int x) {
        if (null == root) {
            return 0;
        }
        int left = dfs(root.left, x);
        int right = dfs(root.right, x);
        if (root.val == x) {
            this.leftNums = left;
            this.rightNums = right;
        }
        return left + right + 1;
    }
}
