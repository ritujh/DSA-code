/**
Missing in AP
Arithmetic expression was an interesting concept that we learned in maths. What about solving a problem around that. Let's say I give you N
 elements and I tell you that the elements are representing AP(Arithmetic Progression). But you realize that one element from this AP is missing and you want to find out the missing element. It is easy to find out the missing one for a human but can you write down a program that does this task of finding a missing element from the AP?
 
 Input
2
5
1 4 10 13 16
5
1 5 9 17 21

Output
7
13
 
 */

 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc =new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = sc.nextInt();
        }
        int d = Math.min(arr[1]-arr[0],arr[2]-arr[1]);
        int res = missingOneInAP(arr,n,0,n-1,d);
        System.out.println(res);
      }
    }
    public static int missingOneInAP(int[] arr,int n, int start, int end,int d){
      if(end-start<2){
        return arr[start]+d;
      }
      int mid = start+(end-start)/2;
      if(mid<n && arr[mid] == arr[start]+(mid-start)*d){
        return missingOneInAP(arr,n,mid,end,d);
      }else{
        return missingOneInAP(arr,n,start,mid,d);
      }
    }
  }