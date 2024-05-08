package countgoodnodesinbinarytree;

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
    public int goodNodes(TreeNode root) {
        return findGoodNodes(root, root.val);
    }

    public int findGoodNodes(TreeNode root, int currMax) {
        if (root == null) {
            return 0;
        }
        int count = root.val >= currMax ? 1 : 0;
        return count + findGoodNodes(root.left, Math.max(currMax, root.val)) + findGoodNodes(root.right, Math.max(currMax, root.val));
    }
}
