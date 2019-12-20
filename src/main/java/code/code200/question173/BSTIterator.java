package code.code200.question173;

import common.TreeNode;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * @author yan
 * @version 1.0
 * @date 2019/12/20
 */
public class BSTIterator {
    private Stack<TreeNode> stack;

    private void pushStack(TreeNode root) {
        if (null != root) {
            stack.push(root);
            pushStack(root.left);
        }
    }

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        pushStack(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode root = stack.pop();
        pushStack(root.right);
        return root.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
