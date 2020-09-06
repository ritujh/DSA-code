/* Complete the function findDistinctCount given below
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

int findDistinctCount(Node node) {
    Map<Long,Long> map = new HashMap<>();
    return (int)findDistinctCount(node,map);
}
boolean isLeaf(Node node){
  if(node!=null && node.left==null && node.right==null){
    return true;
  }
  return false;
}
/**
prepbyte-https://www.prepbytes.com/panel/mycourses/elevation-switch-program/java/week/10/trees/codingAssignment/DSTNCT

Root to leaf path with maximum distinct nodes
Last Updated: 28-08-2019
Given a Binary Tree, find count of distinct nodes in a root to leaf path with maximum distinct nodes.
gfg: https://www.geeksforgeeks.org/root-leaf-path-maximum-distinct-nodes/
 */

long findDistinctCount(Node node, Map<Long,Long> map){
  if(node==null){
    return 0l;
  }
  if(isLeaf(node)){
    long val = node.value;
    //set.add(val);
    map.put(val,map.getOrDefault(val,0l)+1);
    long size = map.size();
    if(map.get(val)>1){
      map.put(val,map.get(val)-1);
    }else{
      map.remove(val);
    }
    return size;
  }
  long val = node.value;
  //set.add(val);
  map.put(val,map.getOrDefault(val,0l)+1);
  long left = findDistinctCount(node.left,map);
  long right = findDistinctCount(node.right, map);
  //set.remove(val);
  if(map.get(val)>1){
    map.put(val,map.get(val)-1);
  }else{
    map.remove(val);
  }
  
    return Math.max(left,right);
  
}
