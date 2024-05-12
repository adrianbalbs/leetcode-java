package constructbinarytreefrompreorderandinorder;

import java.util.HashMap;
import java.util.Map;

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
    Map<Integer, Integer> inorderIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(preorder, 0, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {
        if (preorderIndex > preorder.length - 1 || inorderLow > inorderHigh) {
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preorderIndex]);
        int mid = inorderIndex.get(preorder[preorderIndex]);
        curr.left = build(preorder, preorderIndex + 1, inorderLow, mid - 1);
        curr.right = build(preorder, preorderIndex + (mid - inorderLow) + 1, mid + 1, inorderHigh);
        return curr;
    }
}
