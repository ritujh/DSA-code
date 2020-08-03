/**
Books Left
Bob has recently got his new collection of novels. He arranges all the books on a shelf. Because of his crazy rules, he only reads a book from one of the ends of the shelf. Thus, each book Bob reads is either leftmost or rightmost book from the shelf. Bob cannot read a book if it has more than K chapters, again a crazy rule. When Bob has read a book, he removes it from the shelf. Bob stops when he is unable to read any book from any end of the shelf. How many books are still present on the shelf?
 
Input
6 6
1 3 1 10 2 9 

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
      int ans = booksLeft(arr,k);
      System.out.println(n-ans);
    }
    public static int booksLeft(int[] arr,int k){
      int count = 0;
      int l=0;
      int r = arr.length -1;
      while(l<=r){
        if(arr[l]<=k){
          count++;
          l++;
        }else
        if(arr[r]<=k){
          count++;
          r--;
        }else{
          break;
        }
      }
      return count;
    }
  }