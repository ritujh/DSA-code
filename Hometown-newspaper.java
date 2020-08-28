/**
Hometown Newspaper
Rahul wants to create a newspaper. So he hires peoples who will help him collect the news. Rahul asks them to give the content 
C
 as a string, 
P
 the popularity value and 
D
 if the news is related to his hometown. As Rahul's newspaper is a local newspaper he would print the local news before others in decreasing order of the 
P
 popularity.

Rest all news will be printed in decreasing order of popularity.

Note - Popularity is distinct.

Input
1
3
News1 1 1
News2 2 0
News3 4 1

Output
News3 
News1
News2
 */

import java.util.*;
  import java.io.*;
  class Node{
    String content;
    int popularity;
    int local;
    public String toString(){
      return content+" "+popularity+" "+local;
    }
  }
  class MyComparator implements Comparator{
      public int compare(Object o1, Object o2){
        Node n1 = (Node) o1;
        Node n2 = (Node) o2;
        if(n1.local==n2.local){
          return n2.popularity-n1.popularity;
        }
        return n2.local - n1.local;
      }
  }
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        List<Node> list = new ArrayList<>();
        for(int i=0;i<n;i++){
          Node curr = new Node();
          curr.content = sc.next();
          curr.popularity = sc.nextInt();
          curr.local = sc.nextInt();
          list.add(curr);
        }
        Collections.sort(list,new MyComparator());
        list.forEach(v->System.out.println(v.content));
      }
    }
  }