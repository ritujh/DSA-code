/**
The Famous Pythagorean Triplet
We all have heard of Pythagoras Theorem. Let's solve one more problem around that. This time the problem asks you to find Pythagorean triplet from a given set of integers. 
The famous pythagoras formula is 
x2+y2=z2
 that satisfies this formula.
Input
2
5
1 2 5 12 13
5
1 3 5 7 9

Output
Yes
No
 */
import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while(t-->0){
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
          arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        boolean found = false;
        for(int i=n-1;i>=0 && !found;i--){
          found = findPair(arr,0,i-1,i);
        }
        System.out.println(found?"Yes":"No");
      }
    }
    public static boolean findPair(int[] arr, int l, int r,int i){
      long sum = arr[i]*arr[i];
      while(l<r){
        long a = arr[l]*arr[l];
        long b = arr[r]*arr[r];
        if(a+b==sum){
          return true;
        }
        if(a+b<sum){
          l++;
        }else{
          r--;
        }
      }
      return false;
    }
  }