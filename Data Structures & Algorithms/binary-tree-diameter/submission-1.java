/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int max = 0;
    private int calculateHeight(TreeNode root){
        if(root == null)return 0;
        int leftheight = calculateHeight(root.left);
        int rightheight = calculateHeight(root.right);
        max = Math.max(max,leftheight + rightheight);
        return 1 + Math.max(leftheight, rightheight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // max = 0;
        calculateHeight(root);
        return max;
        
    }
}
