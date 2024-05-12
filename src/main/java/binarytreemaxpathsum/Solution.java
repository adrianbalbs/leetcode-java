package binarytreemaxpathsum;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = { Integer.MIN_VALUE };
        maxPath(root, res);
        return res[0];
    }

    private int maxPath(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPath(root.left, res));
        int right = Math.max(0, maxPath(root.right, res));
        res[0] = Math.max(res[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}
