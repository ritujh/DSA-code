/**
HINT-> sum equals to target solve it by GAIN hash map
Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

leetcode: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3417/

 */

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
    int total;
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        //gain->freq
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        pathSum(root,0,sum,hm);
        return total;
    }
    public void pathSum(TreeNode curr, int sum, int target,  Map<Integer,Integer> hm){
        if(curr==null)return;
        sum +=curr.val;
        int gain = sum-target;
        if(hm.containsKey(gain)){
            total +=hm.get(gain);
        }
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        pathSum(curr.left,sum,target,hm);
        pathSum(curr.right,sum,target,hm);
        hm.put(sum, hm.get(sum) - 1);
        return;
        
    }
}