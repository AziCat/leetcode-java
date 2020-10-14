package code.code450.question427;

/**
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 * <p>
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 * <p>
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * <p>
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 * <p>
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-quad-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yan
 * @version 1.0
 * @date 2020/9/8
 */
public class Solution {
    public Node construct(int[][] grid) {
        int length = grid.length;
        Node root = null;
        if (length > 0) {
            root = buildNode(0, 0, length, grid);
        }
        return root;
    }

    private Node buildNode(int row, int col, int length, int[][] grid) {
        if (length == 1) {
            Node leaf = new Node();
            leaf.val = grid[row][col] == 1;
            leaf.isLeaf = true;
            return leaf;
        } else {
            length >>>= 1;
            Node topLeft = buildNode(row, col, length, grid);
            Node topRight = buildNode(row, col + length, length, grid);
            Node bottomLeft = buildNode(row + length, col, length, grid);
            Node bottomRight = buildNode(row + length, col + length, length, grid);
            //判断叶子的值是否相同
            if (topRight.val == bottomLeft.val &&
                    bottomLeft.val == bottomRight.val &&
                    bottomRight.val == topLeft.val && topRight.isLeaf && topLeft.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                return new Node(topLeft.val, true);
            } else {
                return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(false == false);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
