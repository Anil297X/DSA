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

    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return answer;
    }


    void inorder(TreeNode node, int k) {

        if(node == null) {
            return;
        }


        // Step 1: visit left subtree
        inorder(node.left, k);


        // Step 2: process current node
        count++;

        if(count == k) {
            answer = node.val;
            return;
        }


        // Step 3: visit right subtree
        inorder(node.right, k);
    }
}