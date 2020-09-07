/**
The problem statement goes as follow:

You have to find the maximum integer among the set of integers and divide the integer by 2.
Since this is an integer division the result of division will be an integer.
After division if the integer is greater than 0, then we put the updated integer again in the set of integers.

Input
4 6
8 5 3 1
1
2
3
4
6
8

Output
8
5
4
3
2
1
 */
 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int q = sc.nextInt();
      PriorityQueue<Integer> pq = new PriorityQueue<>(n,Collections.reverseOrder());
      for(int i=0;i<n;i++){
        int x = sc.nextInt();
        pq.add(x);
      }
      int last = 0;
      for(int i=0;i<q && pq.isEmpty()==false;i++){
        int first = sc.nextInt();
        dividingNumber(pq,last,first);
        last=first;
      }
      //dividingNumber(pq, qth, n, q);
    }
    private static void dividingNumber(PriorityQueue<Integer> pq,int last,int first){
      int x = 0;
      while(pq.isEmpty()==false && first>last){
        x = pq.poll();
        if(x/2>0)
          pq.add(x/2);
        first--;
      }
      if(pq.isEmpty()==false)
        System.out.println(x);
    }
    
  }