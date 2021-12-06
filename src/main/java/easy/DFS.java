package easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * For DFS we traverse each path until we finish that path =========PRE-ORDER===========
 * Collections used:
 * o - Stack
 * <p>
 * Description: We start with a node which we push into the stack , after that we take a look at 1 of its neighbors
 * that second node is pushed also into the path until get into a node that does not have neighbors (basically the end of a path)
 * After that we do a backtrack operation which is basically pull from the stack, in that way we get back to the previous node,
 * once we did a backtrack operation we look for a different neighbor than the one we are coming from and repeat until we visit everything,
 * if there are no neighbors at that level we just continue backtracking.
 * <p>
 * Result: (Multiple depending of the start node)
 * - DFS spanning tree (back edged - dotted lines already visited)
 */
public class DFS {

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode leftRoot = new TreeNode(9);
        TreeNode rightRoot = new TreeNode(20);
        root.left = leftRoot;
        root.right = rightRoot;

        TreeNode leftNode20 = new TreeNode(15);
        TreeNode rightNode20 = new TreeNode(7);

        rightRoot.left = leftNode20;
        rightRoot.right = rightNode20;

        System.out.println(maxDepth(new TreeNode(0)));
    }


    /**
     * Iterative DFS
     * @param root
     * @return
     */
    //Runtime: 6 ms, faster than 5.93% of Java online submissions for Maximum Depth of Binary Tree.
    //Memory Usage: 40.9 MB, less than 8.06% of Java online submissions for Maximum Depth of Binary Tree.
    public static int maxDepth(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        TreeNode current = root;

        int currDepth = 1;
        Stack<TreeNode> helper = new Stack<>();

        //Continue while we still have things to explore
        while (true) {
            //Assign the current depth to the max on each iteration
            maxDepth = Math.max(currDepth, maxDepth);

            if (current.left != null && !visited.contains(current.left)) {
                helper.push(current);
                current = current.left;
                visited.add(current);
                currDepth++;
                continue;
            } else if (current.right != null && !visited.contains(current.right)) {
                helper.push(current);
                current = current.right;
                visited.add(current);
                currDepth++;
                continue;
            }

            if (helper.isEmpty()) {
                break;
            } else {
                current = helper.pop();
                currDepth--;
            }

        }

        return maxDepth;
    }

    public static class TreeNode {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

}