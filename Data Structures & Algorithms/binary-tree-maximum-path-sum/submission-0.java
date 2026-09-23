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
    public int lineSum(TreeNode root, int[] maxSum){
        if(root==null) return 0;
        int leftSum = lineSum(root.left,maxSum);
        int rightSum = lineSum(root.right,maxSum);
        int pathSum = root.val;
        if(leftSum > 0) pathSum += leftSum;
        if(rightSum > 0) pathSum += rightSum;
        maxSum[0] = Math.max(maxSum[0],pathSum);
        return root.val + Math.max(0,Math.max(leftSum,rightSum));
    }
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        lineSum(root,maxSum);
        return maxSum[0];
    }
}
