/**
Mirror Reflection
PrepBuddy has always been fascinated by how any word/image seems inverted in the mirror. He has a pair of trees and wants to know whether one tree in the pair is the mirror image of another tree in the given pair.

Note - You have to complete checkMirrorTree() function, no need to implement the tree.

Input
5 4 1 3 2 6 7 -1 -1 -1 -1 -1 -1 -1 -1
5 1 4 7 6 2 3 -1 -1 -1 -1 -1 -1 -1 -1

Note - Level order traversal of input trees, where 
−
1
 represents null nodes.

Output
true

 */

 /* Complete the function checkMirrorTree given below
For your reference:

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

boolean checkMirrorTree(Node node1, Node node2) {
    Node invert = mirrorImage(node1);
    return isSame(invert,node2);
}
boolean isSame(Node node1, Node node2){
  if(node1==null && node2==null){
    return true;
  }
  if(node1!=null && node2!=null && node1.value==node2.value){
    return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);  
  }
  return false;
}
public Node mirrorImage(Node node1){
  if(isLeaf(node1)|| node1==null){
    return node1;
  }
  Node temp = mirrorImage(node1.left);
  node1.left = mirrorImage(node1.right);
  node1.right = temp;
  return node1;
}
boolean isLeaf(Node node1){
  if(node1!=null && node1.left==null && node1.right==null){
    return true;
  }
  return false;
}
