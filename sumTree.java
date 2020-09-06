/**
Convert SumTree
A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in the left subtree and right subtree. You are given a binary tree and the task is to covert that tree into SumTree. 

Note -

You have to complete convertSumTree() function, no need to implement the tree.
Consider empty tree as sumTree with sum=0.
Consider leaf nodes as sumTree.

Input
50 70 80 10 5 1 2 -1 -1 -1 -1 -1 -1 -1 -1

Note - Level order traversal of input tree, where 
−
1
 represents null nodes.

Output
168 15 3 0 0 0 0

 */
/* Complete the function convertToSumTree given below
For your reference
class Node
{
long value;
Node left, right;
public Node(long item)
{
    value = item;
    left = right = null;
}
}
*/

long convertToSumTree(Node node) {
    if(node==null){
      return 0l;
    }
    if(isLeaf(node)){
      long val = node.value;
      node.value = 0l;
      return val;
    }
    long l1=0l;
    long l2 = 0l;
    if(node.left!=null){
      l1 = convertToSumTree(node.left);
      l2 = node.left.value;
      
    }
    long r1 =0l;
    long r2 =0l;
    if(node.right!=null){
      r1 = convertToSumTree(node.right);
      r2 = node.right.value;
    }
    long val = node.value;
    node.value = l1+r1+r2+l2;
    return val;
}
boolean isLeaf(Node node){
  if(node!=null && node.left==null && node.right==null){
    return true;
  }
  return false;
}

