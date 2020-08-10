/**
Sort in a Unique way
Rahul has found a new and unique way of sorting the arrays.

If the array is not sorted, he would remove the first or the second half of the array and he keeps on doing this process unless the array is completely sorted.

Your task is to find out the largest sorted array that can be obtained from the given unsorted array.

Input
3
4
1 2 2 4
8
11 12 1 2 13 14 3 4
4
7 6 5 4

Output
4
2
1
prepbytes-https://www.prepbytes.com/panel/mycourses/elevation-switch-program/java/week/6/sorting/codingAssignment/UNIQUESORT
Hint- 
The size of the array is N and N will be always in the power of 2.
Check what should be output for the already sorted array.
You need to print the length of  the largest sorted array.
For example, if the array is 3 2 4 1, think of output for this.

 */

 import java.util.*;
import java.io.*;
  
  public class Main {
    static int maxLen;
    public static void main(String args[]) throws IOException {
      
     Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     while(t-->0){
       int n = sc.nextInt();
       int arr[] = new int[n];
       for(int i=0;i<n;i++){
         arr[i] = sc.nextInt();
       }
       maxLen = 0;
       boolean half1 = halfSort(0,n/2-1,arr);
       boolean half2 = halfSort(n/2,n-1,arr);
       if(half1 && half2 && arr[n/2-1]<=arr[n/2]){
         maxLen = n;
       }
       System.out.println(maxLen);
     }
      
    }
    public static boolean halfSort(int first, int last, int[] arr){
      if(last==first){
        maxLen = Math.max(last-first+1,maxLen);
        return true;
      }
      int mid = first +(last-first)/2;
      boolean half1 = halfSort(first,mid,arr);
      boolean half2 = halfSort(mid+1,last,arr);
      if(half1 && half2 && arr[mid]<=arr[mid+1]){
         maxLen = Math.max(last-first+1,maxLen);
         return true;
       }
       return false;
    }
  }