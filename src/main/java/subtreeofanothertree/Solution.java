package subtreeofanothertree;

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null || isIdentical(root, subRoot)) return true;
        if (root == null) return false;
        return isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);
    }

    boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}
