/**
gfg: https://www.geeksforgeeks.org/path-length-maximum-number-bends/
prepbytes: https://www.prepbytes.com/panel/mycourses/elevation-switch-program/java/week/10/trees/codingAssignment/MAXTRN
 */
/* Complete the function findTurnCount given below
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

int findTurnCount(Node node) {
  if(node==null)return 0;
  
    int l =findTurnCount(node.left,'L',0);
    int r =findTurnCount(node.right,'R',0);
    return Math.max(l,r);
}
int findTurnCount(Node node, char parent, int count){
  if(node==null)return count;
  if(isLeaf(node))return count;
  if(parent=='L'){
    int ll = findTurnCount(node.left,'L',count);
    int lr =findTurnCount(node.right,'R',count+1);
    return Math.max(ll,lr);
  }else{
    int ll = findTurnCount(node.left,'L',count+1);
    int lr =findTurnCount(node.right,'R',count);
    return Math.max(ll,lr);
  }
}
boolean isLeaf(Node node){
  if(node!=null && node.left==null && node.right==null){
    return true;
  }
  return false;
}
