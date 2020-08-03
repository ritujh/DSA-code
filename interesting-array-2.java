/**
nteresting Array-2
You are given an array consisting of 
N
 integers and integer 
K
. Find number of pairs that have difference value equal to 
K
.

Input:
First line contains two integers 
N
 and 
K
 space separated. 
Second Line contains 
N
 space-separated integers denoting elements of array.

Output:
Print a single integer denoting the number of pairs.

Time Limit:
1 second

Example
Input
5 2
1 5 3 4 2

Output
3
 */

 import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
      }
      int res = findPairs(arr,n,k);
      System.out.println(res);
    }
    public static int findPairs(int[] arr, int n, int k){
        int count = 0; 
        Arrays.sort(arr);
        int l = 0; 
        int r = 1; 
        while(r < n) 
        { 
            if(arr[r] - arr[l] == k) 
            { 
                count++;
                if(l+1<r && arr[l]==arr[l+1]){
                  l++;
                  continue;
                }else
                  r++; 
            } 
            else if(arr[r] - arr[l] > k) 
                l++; 
            else 
                r++; 
        }  
        return count; 
    }
    
  }