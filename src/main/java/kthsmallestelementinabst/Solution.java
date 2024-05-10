package kthsmallestelementinabst;

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
    int res = -1;
    int curr = 0;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root, k);
        return this.res;
    }

    void findKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        findKthSmallest(root.left, k);
        this.curr++;
        if (this.curr == k) {
            this.res = root.val;
            return;
        }
        findKthSmallest(root.right, k);
    }
}
