package serializeanddeserializebinarytree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> nodes = new ArrayList<>();
        serialize(root, nodes);
        return String.join(",", nodes);
    }

    private void serialize(TreeNode root, List<String> nodes) {
        if (root == null) {
            nodes.add("N");
            return;
        }
        serialize(root.left, nodes);
        serialize(root.right, nodes);
        nodes.add(String.valueOf(root.val));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitData = data.split(",");
        return deserialize(splitData);
    }

    TreeNode deserialize(String[] data) {
        if (data[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[index]));
        index++;
        node.left = deserialize(data);
        node.right = deserialize(data);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(0);
        root.right.left = new TreeNode(65);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
